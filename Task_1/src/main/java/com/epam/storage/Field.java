package com.epam.storage;

/** Field class is responsible for storing field data. */
public abstract class Field {

    /** Field value. */
    protected String value;

    /** Field type. */
    protected Type type;

    /** Compares two Field objects. */
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
