package br.ufsm.csi.dao;

import br.ufsm.csi.model.ArtifactType;

import java.sql.*;
import java.util.ArrayList;

public class ArtifactTypeDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<ArtifactType> getArtifactType(){

        ArrayList<ArtifactType> artTypes = new ArrayList<>();

        try(Connection connection = new ConectDB().getConexao()){
            this.sql = "SELECT * FROM artifacttype";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                ArtifactType artType = new ArtifactType();
                artType.setArtifactTypeId(this.resultSet.getInt("artifacttypeid"));
                artType.setName(this.resultSet.getString("name"));

                artTypes.add(artType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return artTypes;
    }

    public ArtifactType getArtifactTypeById(int id){
        ArtifactType ArtTypeFound = new ArtifactType();

        try(Connection connection = new ConectDB().getConexao()){
            this.sql = "SELECT * FROM artifacttype ";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                if (this.resultSet.getInt("artifacttypeid") == id) {
                    ArtifactType artType = new ArtifactType();
                    artType.setArtifactTypeId(this.resultSet.getInt("artifacttypeid"));
                    artType.setName(this.resultSet.getString("name"));

                    ArtTypeFound = artType;
                }
            }
            System.out.println("* - Inside Artifact Type Get- *");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ArtTypeFound;
    }

    public String insert(ArtifactType artType) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            this.sql = "INSERT INTO artifacttype (name) " +
                    " VALUES (?)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, artType.getName());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                artType.setArtifactTypeId(this.resultSet.getInt(1));
                connection.commit();
                System.out.println("Adicionado com sucesso!");
                this.status = "OK";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return this.status;
    }

    public String update(ArtifactType artType) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            //update from id
            this.sql = "UPDATE artifacttype SET name = ? " +
                    " WHERE artifacttypeid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, artType.getName());
            this.preparedStatement.setInt(2, artType.getArtifactTypeId());

            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                this.status = "OK";
                System.out.println("Atualizado com sucesso! !");
            } else {
                this.status = "ERROR";
                System.out.println("Ocorreu um erro ao atualizar! !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }
        return this.status;
    }

    public String delete(ArtifactType artType ) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            //delete from id
            this.sql = "delete from artifacttype " +
                    " where artifacttypeid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, artType.getArtifactTypeId());

            int ok2 = this.preparedStatement.executeUpdate();

            if (ok2 > 0) {
                connection.commit();
                this.status = "OK";
                System.out.println("Usuario deletado com sucesso! !");
            } else {
                this.status = "ERROR";
                System.out.println("Usuario nao existe.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return this.status;
    }
}
