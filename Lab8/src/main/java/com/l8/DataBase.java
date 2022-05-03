package com.l8;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "andrei";
    private static final String PASSWORD = "damian";
    private DataBase(){}
    public static Connection getConnection() {
        Connection newConnection = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Am reusit sa facem conexiunea la server1");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex.getClass().getName()+" "+ex.getMessage());
        }

        try {
            newConnection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Am obtinut conexiunea dorita ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Eroareeee!");
        }
        return  newConnection;
    }

}
