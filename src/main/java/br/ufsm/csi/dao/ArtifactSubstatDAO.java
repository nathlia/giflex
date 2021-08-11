package br.ufsm.csi.dao;

import br.ufsm.csi.model.ArtifactSubstat;

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
                artifactSubstat.setSubstatId(this.resultSet.getInt("artifactid"));
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
}
