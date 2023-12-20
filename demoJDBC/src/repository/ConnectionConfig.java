package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
    static Connection connection = null;
    public static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
        return connection;
    }
}

