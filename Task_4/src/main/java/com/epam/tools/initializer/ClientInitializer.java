package com.epam.tools.initializer;

import com.epam.storage.Customer;
import com.epam.tools.ErrorHandler;
import com.epam.tools.saver.ClientChangesSaver;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/** ClientInitializer class is responsible for initializing client. */
public class ClientInitializer {

    /** Set of customers. */
    private final ArrayList<Customer> CUSTOMERS;

    /** Scanner. */
    private final Scanner SCANNER;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      customers
     *             Set of customers.
     */
    public ClientInitializer(ArrayList<Customer> customers) {
        CUSTOMERS = customers;
        SCANNER = new Scanner(System.in);
    }

    /**
     * Initializes customer.
     * @param      changesSaver
     *             Client changes saver.
     * @param      connection
     *             Database connection.
     * @throws     NullPointerException
     *             If at least one of arguments is null.
     */
    public Customer initialize(ClientChangesSaver changesSaver, Connection connection) {
        final String CUSTOMER_WAS_CREATED = "log: client profile has been created successfully";
        final String CUSTOMER_WAS_FOUND = "log: client has been initialized successfully";
        final String INPUT_INVITATION = ">>> ";
        final String YOUR_NAME = "your-name";
        boolean newCustomer = true;
        Customer result = null;
        int clientId = 0;
        String clientName;

        System.out.print(YOUR_NAME + INPUT_INVITATION);
        clientName = SCANNER.nextLine();

        for (int i = 0; i != CUSTOMERS.size(); i++) {
            Customer c = CUSTOMERS.get(i);

            if ( c.getID() > clientId ) {
                clientId = c.getID() + 1;
            }

            if ( c.getNAME().equalsIgnoreCase(clientName) ) {
                newCustomer = false;
                result = c;
                System.out.println(CUSTOMER_WAS_FOUND);
                break;
            }
        }

        if (newCustomer) {
            result = new Customer(clientId, clientName);
            CUSTOMERS.add(result);

            try {
                changesSaver.saveCustomers(connection);

            } catch (NullPointerException e) {
                ErrorHandler.handle(e);
            }
            System.out.println(CUSTOMER_WAS_CREATED);
        }
        return result;
    }
}
