package com.epam.tools.saver;

import com.epam.storage.*;
import com.epam.tools.ErrorHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * AdministratorChangesSaver class is responsible for saving administrator
 * changes.
 */
public class AdministratorChangesSaver {

    /** Black list. */
    private final ArrayList<Customer> BLACK_LIST;

    /** Set of products. */
    private final ArrayList<Product> PRODUCTS;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      blackList
     *             Black list.
     * @param      products
     *             Set of products.
     */
    public AdministratorChangesSaver(ArrayList<Customer> blackList, ArrayList<Product> products) {
        BLACK_LIST = blackList;
        PRODUCTS = products;
    }

    /**
     * Saves blackList changes.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public void saveBlackList(Connection connection) {
        final String CLEAR_BLACK_LIST = "DELETE FROM black_list";

        try {
            Statement statement = connection.createStatement();
            statement.execute(CLEAR_BLACK_LIST);

            for (Customer c : BLACK_LIST) {
                statement.execute( "INSERT INTO black_list VALUES(" + c.getID() + ", '" + c.getNAME() + "')" );
            }

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }

    /**
     * Saves all changes.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public void saveChanges(Connection connection) {
        final String SUCCESS = "log: changes has been saved successfully";

        saveBlackList(connection);
        saveProducts(connection);
        System.out.println(SUCCESS);
    }

    /**
     * Saves products changes.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public void saveProducts(Connection connection) {
        final String CLEAR_PRODUCTS = "DELETE FROM products";

        try {
            Statement statement = connection.createStatement();
            statement.execute(CLEAR_PRODUCTS);

            for (Product p : PRODUCTS) {
                statement.execute( "INSERT INTO products VALUES(" + p.getID() + ", '" + p.getNAME() + "', " + String.format("%s", p.getCOST()) + ")" );
            }

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }
}
