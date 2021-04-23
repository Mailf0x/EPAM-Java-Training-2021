package com.epam.tools.initializer;

import com.epam.storage.Field;
import com.epam.storage.NumberField;
import com.epam.storage.StringField;
import com.epam.storage.Type;
import com.epam.tools.ErrorHandler;
import com.epam.tools.exception.UnknownDataTypeException;

/**
 * FieldInitializer class is responsible for determining how to create
 * Field object.
 */
public class FieldInitializer {

    /** Number data type name. */
    static final String NUMBER = "number";

    /** String data type name. */
    static final String STRING = "string";

    /**
     * Gets data type of Type object and determines which constructor should be
     * called to create Field object.
     */
    public static Field initialize(String value, Type type) {
        Field result = null;
        String dataType = null;

        // recognizing data type
        try {

            dataType = type.getDataType();

            if ( dataType.compareTo(STRING) == 0 ) {
                result = new StringField(value, type);

            } else if ( dataType.compareTo(NUMBER) == 0 ) {
                result = new NumberField(value, type);

            } else {
                throw new UnknownDataTypeException(null);
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);

        } catch (UnknownDataTypeException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
