package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {


    public UserDaoJDBCImpl() throws SQLException {
    }
    public void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS USERS(ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT, NAME VARCHAR(45), LASTNAME VARCHAR(45), AGE INT)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Во время создания таблицы возникло исключение: " + e);
        }
    }
    public void dropUsersTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS USERS";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Во время создания таблицы возникло исключение: " + e);
        }
    }
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = "INSERT INTO users(NAME, LASTNAME, AGE) VALUES(?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setLong(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.err.println("Во время операции возникло исключение: " + e);
        }
    }
    public void removeUserById(long id) throws SQLException {
        String sql = "DELETE FROM USERS WHERE ID=?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            System.out.println("Во время удаление по id возникло исключение: " + e);
        }
    }
    public List<User> getAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();
        String sql = "SELECT ID, NAME, LASTNAME, AGE FROM USERS";
        try (Connection connection = getConnection(); Statement statement= connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLastName(resultSet.getString("LASTNAME"));
                user.setAge(resultSet.getByte("AGE"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Во время выводы таблицы возникло исключение: " + e);
        }
        return listUser;
    }
    public void cleanUsersTable() throws SQLException {
        String sql = "DELETE FROM USERS";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Во время создания таблицы возникло исключение: " + e);
        }
    }
}
