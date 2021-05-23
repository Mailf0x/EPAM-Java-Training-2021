package com.epam.tools.saver;

import com.epam.storage.Customer;
import com.epam.storage.Order;
import com.epam.tools.ErrorHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** ClientChangesSaver class is responsible for saving client changes. */
public class ClientChangesSaver {

    /** Set of customers. */
    private ArrayList<Customer> CUSTOMERS;

    /** Set of orders. */
    private ArrayList<Order> ORDERS;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      customers
     *             Set of customers.
     * @param      orders
     *             Set of orders.
     */
    public ClientChangesSaver(ArrayList<Customer> customers, ArrayList<Order> orders) {
        CUSTOMERS = customers;
        ORDERS = orders;
    }

    /**
     * Saves customers changes.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public void saveCustomers(Connection connection) {
        final String CLEAR_CUSTOMERS = "DELETE FROM customers";

        try {
            Statement statement = connection.createStatement();
            statement.execute(CLEAR_CUSTOMERS);

            for (Customer c : CUSTOMERS) {
                statement.execute( "INSERT INTO customers VALUES(" + c.getID() + ", '" + c.getNAME() + "')" );
            }

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }

    /**
     * Saves orders changes.
     * @param      connection
     *             Database connection.
     * @throws     SQLException
     *             If data is invalid.
     */
    public void saveOrders(Connection connection) {
        final String CLEAR_ORDERS = "DELETE FROM orders";

        try {
            Statement statement = connection.createStatement();
            statement.execute(CLEAR_ORDERS);

            for (Order o : ORDERS) {
                statement.execute( "INSERT INTO orders VALUES(" + o.getID() + ", " + o.getPRODUCT_ID() + ", " + o.getCUSTOMER_ID() + ")" );
            }

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
    }
}
