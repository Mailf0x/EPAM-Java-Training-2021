package com.epam.storage;

/** Field class is responsible for storing field data. */
public abstract class Field {

    /** Field name. */
    protected String name;

    /** Field data type. */
    protected String type;

    /** String with field value. */
    protected String value;

    /** Compares this object with another. */
    public abstract int compareTo(Field field);

    /** Name getter. */
    public String getName() {
        return name;
    }

    /** Type getter. */
    public String getType() {
        return type;
    }

    /** Value getter. */
    public String getValue() {
        return value;
    }
}
