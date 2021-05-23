package com.epam.tools.initializer;

import com.epam.tools.ErrorHandler;
import com.epam.tools.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** DatabaseInitializer class is responsible for initializing database. */
public class DatabaseInitializer {

    /**
     * Initializes database.
     * @param      url
     *             Database URL.
     * @param      username
     *             Username.
     * @param      password
     *             User password.
     * @throws     SQLException
     *             If arguments are invalid, if shop database doesn't exist.
     */
    public static void initialize(String url, String username, String password) {
        Connection connection;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }

        try {
            final String USE_DATABASE = "USE shop";

            statement.execute(USE_DATABASE);

        } catch (SQLException e) {
            final String SCRIPT = "data\\create_database.sql";
            final String SEMICOLON = ";";
            String buf = FileReader.read(SCRIPT);
            String[] script = buf.split(SEMICOLON);

            try {

                for (String s : script) {
                    statement.execute(s);
                }

            } catch (SQLException ex) {
                ErrorHandler.handle(ex);
            }
        }
    }
}
