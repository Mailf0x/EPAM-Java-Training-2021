package com.epam.tools;

import com.epam.storage.Field;
import com.epam.storage.Structure;
import com.epam.tools.exception.InvalidInputException;
import java.util.ArrayList;

/** StructuresFilter class is responsible for filtering structures. */
public class StructuresFilter {

    /**
     * Filters given structures by given measures.
     * @param      structures
     *             Set of structures.
     * @param      fieldName
     *             Name of field to filter.
     * @param      floorValue
     *             Floor value of fields.
     * @param      ceilValue
     *             Ceil value of fields.
     * @throws     InvalidInputException
     *             If at least one of structures doesn't has field with given name.
     * @throws     NullPointerException
     *             If at least one of arguments is null.
     */
    public static ArrayList<Structure> filter(ArrayList<Structure> structures, String fieldName, String floorValue, String ceilValue) {
        ArrayList<Structure> result = new ArrayList<>();

        try {
            Field ceil = null;
            Field floor = null;
            int i = 0;
            String type = structures.get(0).getField(fieldName).getType();

            if (type == null) {
                throw new InvalidInputException(null);
            }

            ceil = FieldInitializer.initialize(fieldName, type, ceilValue);
            floor = FieldInitializer.initialize(fieldName, type, floorValue);

            for (Structure s : structures) {
                Field f = s.getField(fieldName);

                if ( f.compareTo(floor) >= 0 && f.compareTo(ceil) <= 0 ) {
                    result.add(s);
                }
            }

        } catch (InvalidInputException e) {
            ErrorHandler.handle(e);

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
