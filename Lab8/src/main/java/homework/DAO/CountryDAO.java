package homework.DAO;

import homework.Database;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class CountryDAO {

    public void create(String name, int continentID) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into countries values ((?), (?))")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, continentID);
            pstmt.executeUpdate();
        }
    }

   
    public void createWithoutContinent(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO countries (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.execute();
        }
        con.commit();
    }

  
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("select id from countries where name=(?)")) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt(1) : null;
        }
    }

 
    public String findById(Integer id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from countries where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
