package com.epam.tools.sorter;

import com.epam.storage.Field;
import com.epam.storage.Structure;
import com.epam.tools.ErrorHandler;

/**
 * AscendingSorter class is responsible for ascending sorting of structure
 * sets.
 */
public class AscendingSorter extends Sorter {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      fieldName
     *             Name of field to sort.
     */
    public AscendingSorter(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Compares two Structure class objects.
     * @param      a
     *             First object to compare.
     * @param      b
     *             Second object to compare.
     * @throws     NullPointerException
     *             If a or b or both are null.
     */
    public int compare(Structure a, Structure b) {
        int result = 0;

        try {
            Field c = a.getField(fieldName);
            Field d = b.getField(fieldName);
            result = c.compareTo(d);

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
