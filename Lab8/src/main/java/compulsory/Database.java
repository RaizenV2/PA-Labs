package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/speedy";
    private static final String USER = "speedy";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    private Database() {
    }

 
    public static Connection getConnection() {
        return Database.connection;
    }

   
    public static void createConnection() {
        try {
            Database.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Database.connection.setAutoCommit(false);
            System.out.println("Conexiunea a fost facuta");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

  
    public static void closeConnection() throws SQLException {
        if (Database.connection != null) {
            Database.connection.close();
        }
    }


}
