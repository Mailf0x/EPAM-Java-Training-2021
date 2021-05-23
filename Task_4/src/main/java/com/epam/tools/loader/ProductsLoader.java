package com.epam.tools.loader;

import com.epam.storage.Product;
import com.epam.tools.ErrorHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** ProductsLoader class is responsible for loading products. */
public class ProductsLoader {

    /**
     * Loads products.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public static ArrayList<Product> load(Connection connection) {
        ArrayList<Product> result = new ArrayList<>();

        try {
            final String COST = "cost";
            final String ID = "id";
            final String NAME = "name";
            final String SELECT = "SELECT * FROM products";
            final String USE_DATABASE = "USE shop";

            Statement statement = connection.createStatement();
            statement.execute(USE_DATABASE);
            ResultSet rs = statement.executeQuery(SELECT);

            while ( rs.next() ) {
                double cost = rs.getDouble(COST);
                int id = rs.getInt(ID);
                String name = rs.getString(NAME);

                result.add( new Product(cost, id, name) );
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
