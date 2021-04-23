package com.epam.storage;

/**
 * {@code Field} class is responsible for storing field data.
 */
public abstract class Field {

    /** Field value. */
    protected String value;

    /** Field type. */
    protected Type type;

    /**
     * Compares two Field objects.
     * @param      field
     *             {@code Field} class object to be compared.
     * @return     Value 0 if argument object is equal to this object, value
     *             less than 0 if this object is less than argument object and
     *             value greater than 0 if this object is greater than argument
     *             object.
     */
    public abstract int compareTo(Field field);

    /** Value field getter. */
    public String getValue() {
        return value;
    }

    /** Type field getter. */
    public Type getType() {
        return type;
    }
}
