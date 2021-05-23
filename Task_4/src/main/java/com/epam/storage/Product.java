package com.epam.storage;

/** Product class is responsible for storing product data. */
public class Product {

    /** Product cost. */
    private final double COST;

    /** Product id. */
    private final int ID;

    /** Product name. */
    private final String NAME;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      cost
     *             Product cost.
     * @param      id
     *             Product id.
     * @param      name
     *             Product name.
     */
    public Product(double cost, int id, String name) {
        COST = cost;
        ID = id;
        NAME = name;
    }

    /** Cost getter. */
    public double getCOST() {
        return COST;
    }

    /** Id getter. */
    public int getID() {
        return ID;
    }

    /** Name getter. */
    public String getNAME() {
        return NAME;
    }
}
