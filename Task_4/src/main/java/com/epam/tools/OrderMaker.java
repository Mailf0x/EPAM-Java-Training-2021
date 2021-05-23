package com.epam.tools;

import com.epam.storage.Customer;
import com.epam.storage.Order;
import java.util.ArrayList;
import java.util.Scanner;

/** OrderMaker class is responsible for making orders. */
public class OrderMaker {

    /** Black list. */
    private final ArrayList<Customer> BLACK_LIST;

    /** Set of orders. */
    private final ArrayList<Order> ORDERS;

    /** Scanner. */
    private final Scanner SCANNER;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      blackList
     *             Black list.
     * @param      orders
     *             Set of orders.
     */
    public OrderMaker(ArrayList<Customer> blackList, ArrayList<Order> orders) {
        BLACK_LIST = blackList;
        ORDERS = orders;
        SCANNER = new Scanner(System.in);
    }

    /**
     * Makes order.
     * @param      customerId
     *             Customer id.
     */
    public void makeOrder(int customerId) {
        final String BLOCKED = "error: you can't make orders";
        final String FAILURE = "error: unable to make order";
        final String INPUT_INVITATION = ">>> ";
        final String PRODUCT_ID = "product-id";
        final String SUCCESS = "log: order has been made successfully";
        boolean inBlackList = false;
        int productId;
        String input;

        System.out.print(PRODUCT_ID + INPUT_INVITATION);
        input = SCANNER.nextLine();
        productId = Integer.parseInt(input);

        for (Customer c : BLACK_LIST) {

            if ( c.getID() == customerId ) {
                inBlackList = true;
                break;
            }
        }

        if (!inBlackList) {

            if ( ORDERS.add( new Order( customerId, ORDERS.size() + 1, productId) ) ) {
                System.out.println(SUCCESS);

            } else {
                System.out.println(FAILURE);
            }

        } else {
            System.out.println(BLOCKED);
        }
    }
}
