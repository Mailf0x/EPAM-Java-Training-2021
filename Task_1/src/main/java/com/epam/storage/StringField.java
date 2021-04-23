package com.epam.storage;

import com.epam.tools.ErrorHandler;

/**
 * StringField class is responsible for storing string data type field
 * data. */
public class StringField extends Field {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     */
    public StringField(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    /** Compares two Field objects. */
    public int compareTo(Field field) {
        int result = 0;

        // comparing strings
        try {
            result = value.compareTo( field.getValue() );

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
