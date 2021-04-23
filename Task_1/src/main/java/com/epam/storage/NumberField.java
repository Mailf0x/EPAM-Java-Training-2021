package com.epam.storage;

import com.epam.tools.ErrorHandler;

/**
 * NumberField class is responsible for storing number data type field
 * data.
 */
public class NumberField extends Field {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     */
    public NumberField(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    /** Compares two Field objects. */
    public int compareTo(Field field) {
        int a = 0;
        int b = 0;

        // recognizing numbers
        try {
            a = Integer.parseInt(value);  
            b = Integer.parseInt( field.getValue() );

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        } catch (NumberFormatException e) {
            ErrorHandler.handle(e);
        }
        return a - b;
    }
}
