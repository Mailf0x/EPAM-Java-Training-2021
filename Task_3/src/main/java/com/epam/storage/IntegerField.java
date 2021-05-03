package com.epam.storage;

import com.epam.tools.ErrorHandler;

/** IntegerField class is responsible for storing integer type fields data. */
public class IntegerField extends Field {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      name
     *             Field name.
     * @param      type
     *             Field data type.
     * @param      value
     *             String with field value.
     */
    public IntegerField(String name, String type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    /**
     * Compares this object with another.
     * @param      field
     *             Object to compare with.
     * @throws     NullPointerException
     *             If field is null.
     */
    public int compareTo(Field field) {
        int result = 0;

        try {
            int a = Integer.parseInt(value);
            int b = Integer.parseInt( field.getValue() );
            result = a - b;

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
