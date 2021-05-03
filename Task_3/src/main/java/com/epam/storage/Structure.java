package com.epam.storage;

import com.epam.tools.ErrorHandler;
import java.util.ArrayList;

/** Structure class is responsible for storing structure data. */
public class Structure {

    /** Set of structure fields. */
    private final ArrayList<Field> FIELDS;

    /** Structure ID. */
    private final String ID;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      fields
     *             Set of structure fields.
     * @param      id
     *             Structure ID.
     */
    public Structure(ArrayList<Field> fields, String id) {
        FIELDS = fields;
        ID = id;
    }

    /** Fields getter. */
    public ArrayList<Field> getFIELDS() {
        return FIELDS;
    }

    /**
     * Returns field with given name.
     * @param      fieldName
     *             Name of field to find.
     * @throws     NullPointerException
     *             If fieldName is null.
     */
    public Field getField(String fieldName) {
        Field result = null;

        try {

            for (Field f : FIELDS) {

                if ( f.getName().equalsIgnoreCase(fieldName) ) {
                    result = f;
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }

    /** ID getter. */
    public String getID() {
        return ID;
    }
}
