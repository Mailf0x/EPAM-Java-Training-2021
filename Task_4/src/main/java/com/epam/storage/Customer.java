package com.epam.storage;

/** Customer class is responsible for storing customer data. */
public class Customer {

    /** Customer id. */
    private final int ID;

    /** Customer name. */
    private final String NAME;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      id
     *             Customer id.
     * @param      name
     *             Customer name.
     */
    public Customer(int id, String name) {
        ID = id;
        NAME = name;
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
