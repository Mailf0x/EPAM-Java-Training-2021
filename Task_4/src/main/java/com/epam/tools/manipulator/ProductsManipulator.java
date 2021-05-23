package com.epam.tools.manipulator;

import com.epam.storage.Product;
import java.util.ArrayList;
import java.util.Scanner;

/** ProductsManipulator class is responsible for manipulating products. */
public class ProductsManipulator {

    /** Set of products. */
    private final ArrayList<Product> PRODUCTS;

    /** Scanner. */
    private final Scanner SCANNER;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      products
     *             Set of products.
     */
    public ProductsManipulator(ArrayList<Product> products) {
        PRODUCTS = products;
        SCANNER = new Scanner(System.in);
    }

    /** Adds product to set of products. */
    public void add() {
        final String COST = "cost";
        final String FAILURE = "error: unable to add product";
        final String ID = "id";
        final String INPUT_INVITATION = ">>> ";
        final String NAME = "name";
        final String SUCCESS = "log: product has been added successfully";
        int id;
        double cost;
        String input;
        String name;

        System.out.print(COST + INPUT_INVITATION);
        input = SCANNER.nextLine();
        cost = Double.parseDouble(input);
        System.out.print(ID + INPUT_INVITATION);
        input = SCANNER.nextLine();
        id = Integer.parseInt(input);
        System.out.print(NAME + INPUT_INVITATION);
        name = SCANNER.nextLine();

        if ( PRODUCTS.add( new Product(cost, id, name) ) ) {
            System.out.println(SUCCESS);

        } else {
            System.out.println(FAILURE);
        }
    }

    /** Removes product from set of products. */
    public void remove() {
        final String FAILURE = "error: unable to remove product";
        final String ID = "id";
        final String INPUT_INVITATION = ">>> ";
        final String SUCCESS = "log: product has been removed successfully";
        int prdIndex = -1;
        int productId;
        String input;

        System.out.print(ID + INPUT_INVITATION);
        input = SCANNER.nextLine();
        productId = Integer.parseInt(input);

        for (int i = 0; i != PRODUCTS.size(); i++) {
            Product p = PRODUCTS.get(i);

            if ( p.getID() == productId ) {
                prdIndex = i;
                break;
            }
        }

        if ( PRODUCTS.remove(prdIndex) != null ) {
            System.out.println(SUCCESS);

        } else {
            System.out.println(FAILURE);
        }
    }
}
