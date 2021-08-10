package br.ufsm.csi.dao;

import br.ufsm.csi.model.Player;

import java.sql.*;
import java.util.ArrayList;

//CRUD
public class PlayerDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<Player> getPlayer(){
        ArrayList<Player> users = new ArrayList<Player>();

        try(Connection connection = new ConectDB().getConexao()){
            this.sql = "SELECT * FROM player";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                Player user = new Player();
                user.setUserId(this.resultSet.getInt("userid"));
                user.setName(this.resultSet.getString("name"));
                user.setUsername(this.resultSet.getString("username"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public String insert(Player user) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            this.sql = "INSERT INTO player (name, username, password) " +
                    " VALUES (?, ? , ?)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, user.getName());
            this.preparedStatement.setString(2, user.getUsername());
            this.preparedStatement.setString(3, user.getPassword());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                user.setUserId(this.resultSet.getInt(1));
                connection.commit();
                this.status = "OK";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return this.status;
    }

    public String update(Player user) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            //update from id
            this.sql = "UPDATE player SET name = ?, username = ?, password = ? " +
                    " WHERE userid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, user.getName());
            this.preparedStatement.setString(2, user.getUsername());
            this.preparedStatement.setString(3, user.getPassword());
            this.preparedStatement.setInt(4, user.getUserId());

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

    public String delete(Player user) {
        try(Connection connection = new ConectDB().getConexao()) {

            //BEGIN
            connection.setAutoCommit(false);

            //delete from id

            this.sql = "delete from player " +
                    " where userid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, user.getUserId());

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
