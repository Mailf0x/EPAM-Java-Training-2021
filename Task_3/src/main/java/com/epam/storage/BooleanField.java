package com.epam.storage;

import com.epam.tools.ErrorHandler;

/** BooleanField class is responsible for storing boolean type fields data. */
public class BooleanField extends Field {

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
    public BooleanField(String name, String type, String value) {
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
            boolean a = Boolean.parseBoolean(value);
            boolean b = Boolean.parseBoolean( field.getValue() );
			int c = (int)a;
			int d = (int)b;
			result = c - d;

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
