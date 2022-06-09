package homework.DAO;

import homework.Database;

import java.sql.*;

public class CitiesDAO {
    
    public void create(String name, float latitude, float longitude, int countryID) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO cities (name, countryID, latitude, longitude) values (?, ?, ?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, countryID);
            pstmt.setFloat(3, latitude);
            pstmt.setFloat(4, longitude);
            pstmt.executeUpdate();
        }
        con.commit();
    }

   
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from cities where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

   
    public String findById(Integer id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from cities where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    
    public float getLatitudeFromCity(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select latitude from cities where name='" + name + "'")) {
            return rs.next() ? rs.getFloat(1) : null;
        }
    }

  
    public float getLongitudeFromCity(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select latitude from cities where name='" + name + "'")) {
            return rs.next() ? rs.getFloat(1) : null;
        }
    }
}
