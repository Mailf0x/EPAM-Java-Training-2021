package com.epam;

import com.epam.storage.*;
import com.epam.tools.*;
import com.epam.tools.initializer.ClientInitializer;
import com.epam.tools.initializer.DatabaseInitializer;
import com.epam.tools.loader.*;
import com.epam.tools.saver.ClientChangesSaver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/** ClientRunner class is responsible for executing program. */
public class ClientRunner {

    /**
     * Program entry point.
     * @param      args
     *             Set of command line arguments.
     * @throws     SQLException
     *             If data is invalid.
     */
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        final String CLIENT = "CLIENT";
        final String HELP = "help";
        final String HELP_FILE_PATH = "help\\client_help.txt";
        final String INPUT_INVITATION = ">>> ";
        final String MAKE_ORDER = "make_order";
        final String PASSWORD = "1998";
        final String QUIT = "quit";
        final String SHOW_PRODUCTS = "show_products";
        final String UNKNOWN_COMMAND = "error: unknown command\nuse \"help\" to see list of available commands";
        final String URL = "jdbc:mysql://localhost:3306";
        final String USERNAME = "root";
        ArrayList<Customer> blackList = null;
        ArrayList<Customer> customers = null;
        ArrayList<Order> orders = null;
        ArrayList<Product> products = null;
        boolean running = true;
        ClientChangesSaver changesSaver;
        ClientInitializer clientInitializer;
        Connection connection = null;
        Customer client;
        OrderMaker orderMaker;

        DatabaseInitializer.initialize(URL, USERNAME, PASSWORD);

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            blackList = BlackListLoader.load(connection);
            customers = CustomersLoader.load(connection);
            orders = OrdersLoader.load(connection);
            products = ProductsLoader.load(connection);

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        changesSaver = new ClientChangesSaver(customers, orders);
        clientInitializer = new ClientInitializer(customers);
        orderMaker = new OrderMaker(blackList, orders);
        System.out.println(CLIENT);
        client = clientInitializer.initialize(changesSaver, connection);

        while (running) {
            String userInput;

            System.out.print(INPUT_INVITATION);
            userInput = SCANNER.nextLine();

            if ( userInput.equalsIgnoreCase(HELP) ) {
                FilePrinter.print(HELP_FILE_PATH);

            } else if ( userInput.equalsIgnoreCase(MAKE_ORDER) ) {
                orderMaker.makeOrder( client.getID() );
                changesSaver.saveOrders(connection);

            } else if ( userInput.equalsIgnoreCase(SHOW_PRODUCTS) ) {
                final String FORMAT = "%d\t%.2f\t%s\n";
                final String HEADER = "id\tcost\tname";

                System.out.println(HEADER);

                for (Product p : products) {
                    System.out.printf( FORMAT, p.getID(), p.getCOST(), p.getNAME() );
                }

            } else if ( userInput.equalsIgnoreCase(QUIT) ) {
                running = false;

                try {
                    connection.close();

                } catch (SQLException e) {
                    ErrorHandler.handle(e);
                }

            } else {
                System.out.println(UNKNOWN_COMMAND);
            }
        }
    }
}
