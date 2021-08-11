package br.ufsm.csi.dao;

import br.ufsm.csi.model.UserCharacter;

import java.sql.*;
import java.util.ArrayList;

public class UserCharacterDAO {
    private String sql;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String status;

    public ArrayList<UserCharacter> getUserCharacter() {
        ArrayList<UserCharacter> userCharacters = new ArrayList<>();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM usercharacter";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                UserCharacter userCharacter = new UserCharacter();
                userCharacter.setUserCharacterId(this.resultSet.getInt("usercharacterid"));
                userCharacter.setCharacterId(this.resultSet.getInt("characterid"));
                userCharacter.setPlayerId(this.resultSet.getInt("userid"));

                userCharacters.add(userCharacter);
            }

            for (UserCharacter uc : userCharacters) {
                uc.setPlayer(new PlayerDAO().getPlayerById(uc.getPlayerId()));
                uc.setCharacter(new CharacterDAO().getCharacterById(uc.getCharacterId()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userCharacters;
    }

    public UserCharacter getUserCharacterById(int id) {
        UserCharacter userCharacterFound = new UserCharacter();

        try (Connection connection = new ConectDB().getConexao()) {
            this.sql = "SELECT * FROM usercharacter";

            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sql);

            while (this.resultSet.next()) {
                if (this.resultSet.getInt("usercharacterid") == id) {
                    UserCharacter userCharacter = new UserCharacter();
                    userCharacter.setUserCharacterId(this.resultSet.getInt("usercharacterid"));
                    userCharacter.setCharacterId(this.resultSet.getInt("characterid"));
                    userCharacter.setPlayerId(this.resultSet.getInt("userid"));

                    userCharacterFound = userCharacter;
                }
            }
                userCharacterFound.setPlayer(new PlayerDAO().getPlayerById(userCharacterFound.getPlayerId()));
                userCharacterFound.setCharacter(new CharacterDAO().getCharacterById(userCharacterFound.getCharacterId()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userCharacterFound;
    }

    public String insert(UserCharacter userCharacter) {
        try (Connection connection = new ConectDB().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "INSERT INTO usercharacter (characterid, userid) " +
                    " VALUES (?, ?)";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setInt(1, userCharacter.getCharacterId());
            this.preparedStatement.setInt(2, userCharacter.getPlayerId());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                userCharacter.setUserCharacterId(this.resultSet.getInt(1));
                connection.commit();
                System.out.println("* - Character was added to User with success! - *");
                this.status = "OK";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
        }

        return this.status;
    }

    public String update(UserCharacter userCharacter) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            //update from id
            this.sql = "UPDATE usercharacter SET  characterid = ?, userid = ? " +
                    " WHERE usercharacterid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, userCharacter.getCharacterId());
            this.preparedStatement.setInt(2, userCharacter.getPlayerId());
            this.preparedStatement.setInt(3, userCharacter.getUserCharacterId());

            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                System.out.println("* - Character linked to User updated with success - *");
                this.status = "OK";
            } else {
                this.status = "ERROR";
                System.out.println("x - Error: Could not update Character linked to User- x");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

    public String delete(UserCharacter userCharacter) {
        try (Connection connection = new ConectDB().getConexao()) {
            connection.setAutoCommit(false);

            this.sql = "DELETE FROM usercharacter " +
                    " WHERE usercharacterid = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, userCharacter.getUserCharacterId());

            int ok = this.preparedStatement.executeUpdate();
            if (ok > 0) {
                connection.commit();
                this.status = "OK";
                System.out.println("* - Character was removed from User with success - *");
            } else {
                this.status = "ERROR";
                System.out.println("x - Error: Could not remove Character from User- x");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.status;
    }

}
