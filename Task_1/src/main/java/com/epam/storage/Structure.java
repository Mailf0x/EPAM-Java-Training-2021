package com.epam.storage;

import java.util.ArrayList;
import com.epam.tools.ErrorHandler;

/** Structure class is responsible for storing structure data */
public class Structure {

    /** Set of Field class objects. */
    private ArrayList<Field> fields;

    /**
     * Initializes a newly created object so it represents same data as
     * argument. */
    public Structure(ArrayList<Field> fields) {
        this.fields = fields;
    }

    /** Fields getter. */
    public ArrayList<Field> getFields() {
        return fields;
    }

    /** Returns field of demanded type. */
    public Field getField(Type type) {
        Field result = null;

        // finding the field
        try {

            for (int i = 0; i != fields.size(); i++) {

                if ( fields.get(i).getType() == type) {
                    result = fields.get(i);
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
