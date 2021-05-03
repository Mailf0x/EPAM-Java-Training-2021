package com.epam.storage;

import com.epam.tools.ErrorHandler;

/** DoubleField class is responsible for storing double type fields data. */
public class DoubleField extends Field {

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
    public DoubleField(String name, String type, String value) {
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
            double a = Double.parseDouble(value);
            double b = Double.parseDouble( field.getValue() );

            if (a < b) {
                result = -1;

            } else if (a > b) {
                result = 1;
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
