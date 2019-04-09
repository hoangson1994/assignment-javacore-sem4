package model;

import java.sql.*;

public class DBConnection {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String UTF8 = "?useUnicode=true&characterEncoding=utf-8";

    static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(CONNECTION_URL + DATABASE + UTF8, USERNAME, PASSWORD);
            }
        } catch (Exception e) {
            connection = null;
        }

        return connection;
    }
}
