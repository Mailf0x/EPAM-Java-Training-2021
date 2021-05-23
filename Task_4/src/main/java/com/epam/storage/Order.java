package com.epam.storage;

/** Order class is responsible for storing order data. */
public class Order {

    /** Customer id. */
    private int CUSTOMER_ID;

    /** Order id. */
    private int ID;

    /** Product id. */
    private int PRODUCT_ID;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      customerId
     *             Customer id.
     * @param      id
     *             Order id.
     * @param      productId
     *             Product id.
     */
    public Order(int customerId, int id, int productId) {
        CUSTOMER_ID = customerId;
        ID = id;
        PRODUCT_ID = productId;
    }

    /** Customer id getter. */
    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    /** Order id getter. */
    public int getID() {
        return ID;
    }

    /** Product id getter. */
    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }
}
