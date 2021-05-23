package com.epam.tools.loader;

import com.epam.storage.Customer;
import com.epam.tools.ErrorHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** BlackListLoader class is responsible for loading black list. */
public class BlackListLoader {

    /**
     * Loads black list.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public static ArrayList<Customer> load(Connection connection) {
        ArrayList<Customer> result = new ArrayList<>();

        try {
            final String ID = "id";
            final String NAME = "name";
            final String SELECT = "SELECT * FROM black_list";
            final String USE_DATABASE = "USE shop";

            Statement statement = connection.createStatement();
            statement.execute(USE_DATABASE);
            ResultSet rs = statement.executeQuery(SELECT);

            while ( rs.next() ) {
                int id = rs.getInt(ID);
                String name = rs.getString(NAME);

                result.add( new Customer(id, name) );
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
