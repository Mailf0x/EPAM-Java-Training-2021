package com.epam.tools;

import com.epam.storage.Field;
import com.epam.storage.Structure;
import com.epam.storage.Type;

/**
 * StructureComparator class is responsible for comparing two Structure
 * objects.
 */
public class StructureComparator {

    /** Compares two Structure objects. */
    public static int compare(Structure a, Structure b, Type type) {
        Field c = null;
        Field d = null;
        int result = 0;

        // comparing objects
        try {
            c = a.getField(type);
            d = b.getField(type);
            result = c.compareTo(d);

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
