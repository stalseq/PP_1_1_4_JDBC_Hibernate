package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final static String DB_SQL = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/mybd";
    private final static String user = "root";
    private final static String password = "root";
    private static Connection connection = null;
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(DB_SQL);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("При соединении возникло исключение: " + e);
        }
        return connection;
    }
}
