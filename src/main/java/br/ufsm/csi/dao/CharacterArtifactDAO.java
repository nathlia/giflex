package br.ufsm.csi.dao;

import br.ufsm.csi.model.Artifact;
import br.ufsm.csi.model.CharacterArtifact;

import java.sql.*;
import java.util.ArrayList;

public class CharacterArtifactDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<CharacterArtifact> getCharacterArtifact() {
        ArrayList<CharacterArtifact> characterArtifacts = new ArrayList<>();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM characterartifact";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                CharacterArtifact characterArtifact = new CharacterArtifact();
                characterArtifact.setCharacterArtifactId(this.resultSet.getInt("characterartifactid"));
                characterArtifact.setCharacterId(this.resultSet.getInt("characterid"));
                characterArtifact.setArtifactId(this.resultSet.getInt("artifactid"));

                characterArtifacts.add(characterArtifact);
            }

            for (CharacterArtifact ca : characterArtifacts) {
                ca.setCharacter(new CharacterDAO().getCharacterById(ca.getCharacterId()));
                ca.setArtifact(new ArtifactDAO().getArtifactById(ca.getArtifactId()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return characterArtifacts;
    }

    public ArrayList<Artifact> getCharacterArtifactList(int characterid) {
        ArrayList<Artifact> artifacts = new ArrayList<>();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "select a.* " +
                    "from characterartifact ca " +
                    "inner join artifact a on a.artifactid = ca.artifactid " +
                    "where ca.characterid = " + characterid;

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                Artifact artifact = new Artifact();
                artifact.setArtifactId(this.resultSet.getInt("artifactid"));
                artifact.setArtifactTypeId(this.resultSet.getInt("artifacttypeid"));
                artifact.setArtifactSetTypeId(this.resultSet.getInt("artifactsettypeid"));
                artifact.setMainStatId(this.resultSet.getInt("mainstatid"));
                artifact.setMainStatValue(this.resultSet.getDouble("mainstatvalue"));

                artifacts.add(artifact);
            }

            for (Artifact a : artifacts) {
                a.setArtifactType(new ArtifactTypeDAO().getArtifactTypeById(a.getArtifactTypeId()));
                a.setArtifactSetType(new ArtifactSetTypeDAO().getArtifactSetTypebyId(a.getArtifactSetTypeId()));
                a.setMainStat(new SubstatDAO().getSubstatById(a.getMainStatId()));
                a.setSubstats(new ArtifactSubstatDAO().getSubstatByArtifactId(a.getArtifactId()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artifacts;
    }

    public CharacterArtifact getCharacterArtifactById(int id) {
        CharacterArtifact characterArtifactFound = new CharacterArtifact();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM characterartifact";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                if (this.resultSet.getInt("characterartifactid") == id) {
                    CharacterArtifact characterArtifact = new CharacterArtifact();
                    characterArtifact.setCharacterArtifactId(this.resultSet.getInt("characterartifactid"));
                    characterArtifact.setCharacterId(this.resultSet.getInt("characterid"));
                    characterArtifact.setArtifactId(this.resultSet.getInt("artifactid"));

                    characterArtifactFound = characterArtifact;
                }
            }

            characterArtifactFound.setCharacter(new CharacterDAO().getCharacterById(characterArtifactFound.getCharacterId()));
            characterArtifactFound.setArtifact(new ArtifactDAO().getArtifactById(characterArtifactFound.getArtifactId()));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return characterArtifactFound;
    }

    public String insert(CharacterArtifact characterArtifact) {
        try (Connection connection = new ConectDB().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "INSERT INTO characterartifact (characterid, artifactid)" +
                    "VALUES (?, ?);";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setInt(1, characterArtifact.getCharacterId());
            this.preparedStatement.setInt(2, characterArtifact.getArtifactId());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                characterArtifact.setArtifactId(this.resultSet.getInt(1));
                connection.commit();
                System.out.println("* - Artifact added to Character with success! - *");
                this.status = "OK";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return this.status;
    }

    public String update(CharacterArtifact characterArtifact) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            //update from id
            this.sql = "UPDATE characterartifact SET characterid = ?, artifactid = ?" +
                    "WHERE characterartifactid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, characterArtifact.getCharacterId());
            this.preparedStatement.setInt(2, characterArtifact.getArtifactId());
            this.preparedStatement.setInt(3, characterArtifact.getCharacterArtifactId());

            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                System.out.println("* - Artifact equipped updated with success - *");
                this.status = "OK";
            } else {
                this.status = "ERROR";
                System.out.println("x - Error: Could not update Artifact equipped - x");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

    public String delete(CharacterArtifact characterArtifact) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            this.sql = "DELETE FROM  characterartifact" +
                    " WHERE characterartifactid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, characterArtifact.getCharacterArtifactId());

            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                this.status = "OK";
                System.out.println("* - Artifact was deleted with success - *");
            } else {
                this.status = "ERROR";
                System.out.println("x - Error: Could not delete Artifact - x");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }
}
