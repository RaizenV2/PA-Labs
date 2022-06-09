package compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Database.createConnection();

            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();

            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();

            Database.getConnection().close();

        } catch (SQLException e) {
            System.err.println(e);
            // Database.rollback();
        }
    }
}
