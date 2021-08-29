package br.ufsm.csi.dao;

import br.ufsm.csi.model.ArtifactSubstat;
import br.ufsm.csi.model.Substat;

import java.sql.*;
import java.util.ArrayList;

public class ArtifactSubstatDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<ArtifactSubstat> getArtifactSubstat() {
        ArrayList<ArtifactSubstat> artifactSubstats = new ArrayList<>();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM artifactsubstat ";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                ArtifactSubstat artifactSubstat = new ArtifactSubstat();
                artifactSubstat.setArtifactSubstatId(this.resultSet.getInt("artifactsubstatid"));
                artifactSubstat.setArtifactId(this.resultSet.getInt("artifactid"));
                artifactSubstat.setSubstatId(this.resultSet.getInt("substatid"));
                artifactSubstat.setSubstatValue(this.resultSet.getDouble("substatvalue"));

                artifactSubstats.add(artifactSubstat);
            }

            for (ArtifactSubstat a : artifactSubstats) {
                a.setSubstat(new SubstatDAO().getSubstatById(a.getSubstatId()));
                a.setArtifact(new ArtifactDAO().getArtifactById(a.getArtifactId()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artifactSubstats;
    }

    public ArrayList<Substat> getSubstatByArtifactId(int artifactId) {
        ArrayList<Substat> substats = new ArrayList<>();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "select s.*, asub.substatvalue " +
                    "from artifactsubstat asub " +
                    "inner join substat s on s.substatid = asub.substatid " +
                    "where asub.artifactid =  " + artifactId;

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                Substat substat = new Substat();
                substat.setSubstatId(this.resultSet.getInt("substatid"));
                substat.setName(this.resultSet.getString("name"));
                substat.setValue(this.resultSet.getDouble("substatvalue"));

                substats.add(substat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return substats;
    }

    public ArrayList<ArtifactSubstat> getArtifactSubstatById(int id) {
        ArrayList<ArtifactSubstat> artifactSubstats = new ArrayList<>();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM artifactsubstat ";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                if (this.resultSet.getInt("artifactsubstatid") == id) {
                    ArtifactSubstat artifactSubstat = new ArtifactSubstat();
                    artifactSubstat.setArtifactSubstatId(this.resultSet.getInt("artifactsubstatid"));
                    artifactSubstat.setArtifactId(this.resultSet.getInt("artifactid"));
                    artifactSubstat.setSubstatId(this.resultSet.getInt("substatid"));
                    artifactSubstat.setSubstatValue(this.resultSet.getDouble("substatvalue"));

                    artifactSubstats.add(artifactSubstat);
                }
            }

            for (ArtifactSubstat a : artifactSubstats) {
                a.setSubstat(new SubstatDAO().getSubstatById(a.getSubstatId()));
                a.setArtifact(new ArtifactDAO().getArtifactById(a.getArtifactId()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artifactSubstats;
    }

    public String insert(ArtifactSubstat artifactSubstat) {
        try (Connection connection = new ConectDB().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "INSERT INTO artifactsubstat (artifactid, substatid, substatvalue)" +
                    "VALUES (?, ?, ?);";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setInt(1, artifactSubstat.getArtifactId());
            this.preparedStatement.setInt(2, artifactSubstat.getSubstatId());
            this.preparedStatement.setDouble(3, artifactSubstat.getSubstatValue());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                artifactSubstat.setArtifactId(this.resultSet.getInt(1));
                connection.commit();
                System.out.println("* - Substat added to Artifact with success! - *");
                this.status = "OK";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return this.status;
    }

    public String update(ArtifactSubstat artifactSubstat) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            //update from id
            this.sql = "UPDATE artifactsubstat SET artifactid = ?, substatid = ?, substatvalue = ? " +
                    "WHERE artifactsubstatid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, artifactSubstat.getArtifactId());
            this.preparedStatement.setInt(2, artifactSubstat.getSubstatId());
            this.preparedStatement.setDouble(3, artifactSubstat.getSubstatValue());
            this.preparedStatement.setInt(4, artifactSubstat.getArtifactSubstatId());

            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                System.out.println("* - Substat of Artifact updated with success - *");
                this.status = "OK";
            } else {
                this.status = "ERROR";
                System.out.println("x - Error: Could not update Substats of Artifact - x");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

    public String delete(ArtifactSubstat artifactSubstat) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            this.sql = "DELETE FROM artifactsubstat " +
                    " WHERE artifactsubstatid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, artifactSubstat.getArtifactSubstatId());

            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                this.status = "OK";
                System.out.println("* - Substat was deleted with success - *");
            } else {
                this.status = "ERROR";
                System.out.println("x - Error: Could not delete Substat - x");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }
}
