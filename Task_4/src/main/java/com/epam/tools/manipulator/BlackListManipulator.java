package com.epam.tools.manipulator;

import com.epam.tools.ErrorHandler;
import com.epam.storage.Customer;
import java.util.ArrayList;
import java.util.Scanner;

/** BlackListManipulator class is responsible for manipulating black list. */
public class BlackListManipulator {

    /** Black list. */
    private final ArrayList<Customer> BLACK_LIST;

    /** Scanner. */
    private final Scanner SCANNER;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      blackList
     *             Black list.
     */
    public BlackListManipulator(ArrayList<Customer> blackList) {
        BLACK_LIST = blackList;
        SCANNER = new Scanner(System.in);
    }

    /**
     * Adds customer to black list.
     * @param      customers
     *             Set of customers.
     * @throws     NullPointerException
     *             If customers is null.
     */
    public void add(ArrayList<Customer> customers) {
        final String CUSTOMER_ALREADY_IN_BLACK_LIST = "error: customer is already in black list";
        final String CUSTOMER_ID = "customer-id";
        final String CUSTOMER_NOT_FOUND = "error: customer not found";
        final String INPUT_INVITATION = ">>> ";
        final String SUCCESS = "log: new customer has been added to black list successfully";
        boolean exists = false;
        Customer customer = null;
        int customerId = 0;

        System.out.print(CUSTOMER_ID + INPUT_INVITATION);
        customerId = SCANNER.nextInt();

        try {

            for (Customer c : customers) {

                if ( c.getID() == customerId ) {
                    exists = true;
                    customer = c;
                    break;
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }

        if (exists) {
            boolean inBlackList = false;

            for (Customer c : BLACK_LIST) {

                if ( c.getID() == customerId ) {
                    inBlackList = true;
                    break;
                }
            }

            if (!inBlackList) {

                if ( BLACK_LIST.add(customer) ) {
                    System.out.println(SUCCESS);
                }

            } else {
                System.out.println(CUSTOMER_ALREADY_IN_BLACK_LIST);
            }

        } else {
            System.out.println(CUSTOMER_NOT_FOUND);
        }
    }

    /** Removes customer from black list. */
    public void remove() {
        final String CUSTOMER_ID = "customer-id";
        final String FAILURE = "error: unable to remove customer";
        final String INPUT_INVITATION = ">>> ";
        final String SUCCESS = "log: customer has been removed successfully";
        int customerId;
        int cstIndex = -1;
        String input;

        System.out.print(CUSTOMER_ID + INPUT_INVITATION);
        input = SCANNER.nextLine();
        customerId = Integer.parseInt(input);

        for (int i = 0; i != BLACK_LIST.size(); i++) {
            Customer c = BLACK_LIST.get(i);

            if ( c.getID() == customerId ) {
                cstIndex = i;
                break;
            }
        }

        if (cstIndex != -1) {

            if ( BLACK_LIST.remove(cstIndex) != null ) {
                System.out.println(SUCCESS);
            }

        } else {
            System.out.println(FAILURE);
        }
    }
}
