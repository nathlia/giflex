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
}
