package com.epam.storage;

/** Type class is responsible for storing type data. */
public class Type {
    private String dataType;
    private String name;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments. */
    public Type(String dataType, String name) {
        this.dataType = dataType;
        this.name = name;
    }

    /** DataType getter. */
    public String getDataType() {
        return dataType;
    }

    /** Name getter. */
    public String getName() {
        return name;
    }
}
