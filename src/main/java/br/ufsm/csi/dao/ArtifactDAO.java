package br.ufsm.csi.dao;

import br.ufsm.csi.model.ArtifactType;
import br.ufsm.csi.model.Character;

import java.sql.*;
import java.util.ArrayList;

public class ArtifactDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Character> getCharacter(){

        ArrayList<Character> characters = new ArrayList<Character>();

        try(Connection connection = new ConectDB().getConexao()){
            this.sql = "SELECT * FROM character";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                Character chara = new Character();
                chara.setCharacterId(this.resultSet.getLong("characterid"));
                chara.setName(this.resultSet.getString("name"));
                chara.setLevel(this.resultSet.getString("level"));
                chara.setCritRate(this.resultSet.getString("critrate"));
                chara.setCritDmg(this.resultSet.getString("critdmg"));

                characters.add(chara);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return characters;
    }

    public String insert(Character chara) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            this.sql = "INSERT INTO character (name, level, critrate, critdmg) " +
                    " VALUES (?, ?, ?, ?)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, chara.getName());
            this.preparedStatement.setString(2, chara.getLevel());
            this.preparedStatement.setString(3, chara.getCritRate());
            this.preparedStatement.setString(4, chara.getCritDmg());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                chara.setCharacterId(this.resultSet.getInt(1));
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

    public String update(Character chara) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            //update from id
            this.sql = "UPDATE character SET name = ?, level = ?, critrate = ?, critdmg = ? " +
                    " WHERE characterid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, chara.getName());
            this.preparedStatement.setString(2, chara.getLevel());
            this.preparedStatement.setString(3, chara.getCritRate());
            this.preparedStatement.setString(4, chara.getCritDmg());
            this.preparedStatement.setLong(5, chara.getCharacterId());

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

    public String delete(Character chara ) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            //delete from id

            this.sql = "delete from character " +
                    " where characterid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setLong(1, chara.getCharacterId());

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
