package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Dwayne", "Johnson", (byte) 51);
        userDao.saveUser("Vin", "Diesel", (byte) 55);
        userDao.saveUser("Jason", "Statham", (byte) 56);
        userDao.saveUser("Bruce", "Willis", (byte) 69);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
