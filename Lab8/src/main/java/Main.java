import com.l8.DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{

    public static void createCityTable(Connection c )
    {
        Statement stmt = null;

        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlQuery = "CREATE TABLE CITY " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " CODE            INT     NOT NULL, " +
                " CONTINENT        CHAR(50));";

        try {
            stmt.executeUpdate(sqlQuery);
            System.out.println("Table CITY created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createContinentsTable(Connection c)
    {
        Statement stmt = null;

        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlQuery = "CREATE TABLE CONTINETS " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME TEXT NOT NULL);";

        try {
            stmt.executeUpdate(sqlQuery);
            System.out.println("Table CONTINENTS created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Connection newConnection  = DataBase.getConnection();
//        createContinentsTable(newConnection);
//        createCityTable(newConnection);
    }
}
