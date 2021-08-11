package br.ufsm.csi.dao;

import br.ufsm.csi.model.Artifact;

import java.sql.*;
import java.util.ArrayList;

public class ArtifactDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Artifact> getArtifact() {
        ArrayList<Artifact> artifacts = new ArrayList<>();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM artifact";
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

            //fazer for loop e setar cada objeto da foreign key
            //for a in artifacts
            //  a.artifactType = artifactTypeDAO.getartifactType(a.artifactTypeid);

            for (Artifact a : artifacts) {
                a.setArtifactType(new ArtifactTypeDAO().getArtifactTypeById(a.getArtifactTypeId()));
                a.setArtifactSetType(new ArtifactSetTypeDAO().getArtifactSetTypebyId(a.getArtifactSetTypeId()));
                a.setMainStat(new SubstatDAO().getSubstatById(a.getMainStatId()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return artifacts;

    }

    public Artifact getArtifactById(int id) {
        Artifact artifactFound = new Artifact();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM artifact";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                if (this.resultSet.getInt("artifactid") == id) {
                    Artifact artifact = new Artifact();
                    artifact.setArtifactId(this.resultSet.getInt("artifactid"));
                    artifact.setArtifactTypeId(this.resultSet.getInt("artifacttypeid"));
                    artifact.setArtifactSetTypeId(this.resultSet.getInt("artifactsettypeid"));
                    artifact.setMainStatId(this.resultSet.getInt("mainstatid"));
                    artifact.setMainStatValue(this.resultSet.getDouble("mainstatvalue"));

                    artifactFound = artifact;
                }
            }

            //fazer for loop e setar cada objeto da foreign key
            artifactFound.setArtifactType(new ArtifactTypeDAO().getArtifactTypeById(artifactFound.getArtifactTypeId()));
            artifactFound.setArtifactSetType(new ArtifactSetTypeDAO().getArtifactSetTypebyId(artifactFound.getArtifactSetTypeId()));
            artifactFound.setMainStat(new SubstatDAO().getSubstatById(artifactFound.getMainStatId()));

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return artifactFound;
    }

    public String insert(Artifact artifact) {
        try (Connection connection = new ConectDB().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "INSERT INTO artifact (artifacttypeid, artifactsettypeid, mainstatid, mainstatvalue) " +
                    " VALUES (?, ?, ?, ?)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setInt(1, artifact.getArtifactTypeId());
            this.preparedStatement.setInt(2, artifact.getArtifactSetTypeId());
            this.preparedStatement.setInt(3, artifact.getMainStatId());
            this.preparedStatement.setDouble(4, artifact.getMainStatValue());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                artifact.setArtifactId(this.resultSet.getInt(1));
                connection.commit(); 
                System.out.println("* - Artifact added with success! - *");
                this.status = "OK";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return this.status;
    }

    public String update(Artifact artifact) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            //update from id
            this.sql = "UPDATE artifact SET artifacttypeid=?, artifactsettypeid=?, mainstatid=?, mainstatvalue=?" +
                    "WHERE artifactid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, artifact.getArtifactTypeId());
            this.preparedStatement.setInt(2, artifact.getArtifactSetTypeId());
            this.preparedStatement.setInt(3, artifact.getMainStatId());
            this.preparedStatement.setDouble(4, artifact.getMainStatValue());
            this.preparedStatement.setDouble(5, artifact.getArtifactId());


            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                System.out.println("* - Artifact updated with success - *");
                this.status = "OK";
            } else {
                this.status = "ERROR";
                System.out.println("x - Error: Could not update Artifact - x");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

    public String deleteCharacterArtifact(Artifact artifact) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            this.sql = "DELETE FROM characterartifact " +
                    "WHERE  characterartifact.artifactid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, artifact.getArtifactId());

            int deletedFromCharacter = this.preparedStatement.executeUpdate();
            if (deletedFromCharacter > 0) {
                connection.commit();
                this.status = "OK";
                System.out.println("* - Artifact was removed from Character - *");
            } else {
                System.out.println(" x - Artifact could not be removed from Character - x");
                this.status = "ERROR";
            }

            if (this.status.equals("OK")) {
                this.sql = "DELETE FROM artifact " +
                        " WHERE artifactid = ?";

                this.preparedStatement = connection.prepareStatement(this.sql);
                this.preparedStatement.setInt(1, artifact.getArtifactId());

                int deletedArtifact = this.preparedStatement.executeUpdate();
                if (deletedArtifact > 0) {
                    connection.commit();
                    this.status = "OK";
                    System.out.println("* - Artifact was deleted with success - *");
                } else {
                    this.status = "ERROR";
                    System.out.println("x - Error: Could not delete Artifact - x");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

    public String deleteArtifactSubtstat(Artifact artifact) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            this.sql = "DELETE FROM artifactsubstat " +
                    "WHERE  artifactsubstat.artifactid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, artifact.getArtifactId());

            int deletedFromSubstat = this.preparedStatement.executeUpdate();
            if (deletedFromSubstat > 0) {
                connection.commit();
                this.status = "OK";
                System.out.println("* - Artifact was removed from Substat - *");
            } else {
                System.out.println(" x - Artifact could not be removed from Substat - x");
                this.status = "ERROR";
            }

            if (this.status.equals("OK")) {
                this.sql = "DELETE FROM artifact " +
                        " WHERE artifactid = ?";

                this.preparedStatement = connection.prepareStatement(this.sql);
                this.preparedStatement.setInt(1, artifact.getArtifactId());

                int deletedArtifact = this.preparedStatement.executeUpdate();
                if (deletedArtifact > 0) {
                    connection.commit();
                    this.status = "OK";
                    System.out.println("* - Artifact was deleted with success - *");
                } else {
                    this.status = "ERROR";
                    System.out.println("x - Error: Could not delete Artifact - x");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }
}
