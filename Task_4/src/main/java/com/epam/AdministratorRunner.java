package com.epam;

import com.epam.storage.*;
import com.epam.tools.*;
import com.epam.tools.initializer.DatabaseInitializer;
import com.epam.tools.loader.*;
import com.epam.tools.manipulator.*;
import com.epam.tools.saver.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/** AdministratorRunner class is responsible for executing program. */
public class AdministratorRunner {

    /**
     * Program entry point.
     * @param      args
     *             Set of command line arguments.
     * @throws     SQLException
     *             If data is invalid.
     */
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        final String ADD_BLACK_LIST_CUSTOMER = "add_black_list_customer";
        final String ADD_PRODUCT = "add_product";
        final String ADMINISTRATOR = "ADMINISTRATOR";
        final String HELP = "help";
        final String HELP_FILE_PATH = "help\\administrator_help.txt";
        final String INPUT_INVITATION = ">>> ";
        final String PASSWORD = "1998";
        final String QUIT = "quit";
        final String REMOVE_BLACK_LIST_CUSTOMER = "remove_black_list_customer";
        final String REMOVE_PRODUCT = "remove_product";
        final String SAVE_CHANGES = "save_changes";
        final String SHOW_BLACK_LIST = "show_black_list";
        final String SHOW_CUSTOMERS = "show_customers";
        final String SHOW_PRODUCTS = "show_products";
        final String UNKNOWN_COMMAND = "error: unknown command\nuse \"help\" to see list of available commands";
        final String URL = "jdbc:mysql://localhost:3306";
        final String USERNAME = "root";
        ArrayList<Customer> blackList = null;
        ArrayList<Customer> customers = null;
        ArrayList<Product> products = null;
        BlackListManipulator blackListManipulator;
        boolean running = true;
        AdministratorChangesSaver changesSaver;
        Connection connection = null;
        ProductsManipulator productsManipulator;

        DatabaseInitializer.initialize(URL, USERNAME, PASSWORD);

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            blackList = BlackListLoader.load(connection);
            customers = CustomersLoader.load(connection);
            products = ProductsLoader.load(connection);

        } catch (SQLException e) {
            ErrorHandler.handle(e);
        }
        blackListManipulator = new BlackListManipulator(blackList);
        productsManipulator = new ProductsManipulator(products);
        changesSaver = new AdministratorChangesSaver(blackList, products);
        System.out.println(ADMINISTRATOR);

        while (running) {
            String userInput;

            System.out.print(INPUT_INVITATION);
            userInput = SCANNER.nextLine();

            if ( userInput.equalsIgnoreCase(ADD_BLACK_LIST_CUSTOMER) ) {
                blackListManipulator.add(customers);

            } else if ( userInput.equalsIgnoreCase(ADD_PRODUCT) ) {
                productsManipulator.add();

            } else if ( userInput.equalsIgnoreCase(HELP) ) {
                FilePrinter.print(HELP_FILE_PATH);

            } else if ( userInput.equalsIgnoreCase(REMOVE_BLACK_LIST_CUSTOMER) ) {
                blackListManipulator.remove();

            } else if ( userInput.equalsIgnoreCase(REMOVE_PRODUCT) ) {
                productsManipulator.remove();

            } else if ( userInput.equalsIgnoreCase(SAVE_CHANGES) ) {
                changesSaver.saveChanges(connection);

            } else if ( userInput.equalsIgnoreCase(SHOW_BLACK_LIST) ) {
                final String FORMAT = "%d\t%s\n";
                final String HEADER = "id\tname";

                System.out.println(HEADER);

                for (Customer c : blackList) {
                    System.out.printf( FORMAT, c.getID(), c.getNAME() );
                }

            } else if ( userInput.equalsIgnoreCase(SHOW_CUSTOMERS) ) {
                final String FORMAT = "%d\t%s\n";
                final String HEADER = "id\tname";

                System.out.println(HEADER);

                for (Customer c : customers) {
                    System.out.printf( FORMAT, c.getID(), c.getNAME() );
                }

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
