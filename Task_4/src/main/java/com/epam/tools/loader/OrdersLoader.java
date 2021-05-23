package com.epam.tools.loader;

import com.epam.storage.Order;
import com.epam.tools.ErrorHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** OrdersLoader class is responsible for loading orders. */
public class OrdersLoader {

    /**
     * Loads orders.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public static ArrayList<Order> load(Connection connection) {
        ArrayList<Order> result = new ArrayList<>();

        try {
            final String CUSTOMER_ID = "customer_id";
            final String ID = "id";
            final String PRODUCT_ID = "product_id";
            final String SELECT = "SELECT * FROM orders";
            final String USE_DATABASE = "USE shop";

            Statement statement = connection.createStatement();
            statement.execute(USE_DATABASE);
            ResultSet rs = statement.executeQuery(SELECT);

            while ( rs.next() ) {
                int customer_id = rs.getInt(CUSTOMER_ID);
                int id = rs.getInt(ID);
                int product_id = rs.getInt(PRODUCT_ID);

                result.add( new Order(customer_id, id, product_id) );
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
