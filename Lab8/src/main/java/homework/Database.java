package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/speedy";
    private static final String USER = "speedy";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    /**
     * This method returns the connection stored in static memory of the Database class
     *
     * @return the connection
     */
    public static Connection getConnection() {
        return Database.connection;
    }

    /**
     * this method creates a new connection based on URL, USER, PASSWORD stored in the memory of the Database class
     */
    public static void createConnection() {
        try {
            Database.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Database.connection.setAutoCommit(false);
            System.out.println("Conexiunea a fost facuta");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * this method closes the databases
     *
     * @throws SQLException exception
     */
    public static void closeConnection() throws SQLException {
        if (Database.connection != null) {
            Database.connection.close();
        }
    }
}
