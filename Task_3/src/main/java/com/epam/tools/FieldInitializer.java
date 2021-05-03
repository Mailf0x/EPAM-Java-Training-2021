package com.epam.tools;

import com.epam.storage.*;
import com.epam.tools.ErrorHandler;
import com.epam.tools.exception.UnknownTypeException;

/** FieldInitializer class is responsible for initializing fields. */
public class FieldInitializer {

    /**
     * Initializes field depending on given type.
     * @param      name
     *             Field name.
     * @param      type
     *             Field data type.
     * @param      value
     *             String with field value.
     * @throws     NullPointerException
     *             If at least one of parameters is null.
     * @throws     UnknownTypeException
     *             If given type is invalid.
     */
    public static Field initialize(String name, String type, String value) {
        final String BOOLEAN = "boolean";
        final String DOUBLE = "double";
        final String INTEGER = "integer";
        final String STRING = "string";
        Field result = null;

        try {

            if ( type.equalsIgnoreCase(BOOLEAN) ) {
                result = new BooleanField(name, type, value);

            } else if ( type.equalsIgnoreCase(DOUBLE) ) {
                result = new DoubleField(name, type, value);

            } else if ( type.equalsIgnoreCase(INTEGER) ) {
                result = new IntegerField(name, type, value);

            } else if ( type.equalsIgnoreCase(STRING) ) {
                result = new StringField(name, type, value);

            } else {
                throw new UnknownTypeException(null);
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);

        } catch (UnknownTypeException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
