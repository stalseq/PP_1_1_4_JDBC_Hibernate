package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Dwayne", "Johnson", (byte) 51);
        userService.saveUser("Vin", "Diesel", (byte) 55);
        userService.saveUser("Jason", "Statham", (byte) 56);
        userService.saveUser("Bruce", "Willis", (byte) 69);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
