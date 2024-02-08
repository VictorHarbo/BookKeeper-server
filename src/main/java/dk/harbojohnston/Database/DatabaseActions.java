package dk.harbojohnston.Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseActions {

    public static void connectToDb() throws IOException {
        String propertiesPath =  "conf/database.properties";

        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream(propertiesPath));


        String jdbcUrl = databaseProperties.getProperty("database.url");
        String username = databaseProperties.getProperty("database.username");
        String password = databaseProperties.getProperty("database.password");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the database!");

            // Perform database operations here...


        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }


}
