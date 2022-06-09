package homework;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Database.createConnection();

        String importLocation = "/Users/speedy/IdeaProjects/java/lab8/src/main/java/homework/files/concap.csv";
        new Tool().addCountriesIntoDatabase(importLocation);
        new Tool().addCitiesIntoDatabase(importLocation);

        double distance = new Tool().calculateDistancesBetweenTwoCities("Bucharest", "Paris");

        Display.displayDistanceInConsole(distance);

        Database.closeConnection();
    }
}
