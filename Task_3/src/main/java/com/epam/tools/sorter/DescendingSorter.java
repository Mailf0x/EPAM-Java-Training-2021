package com.epam.tools.sorter;

import com.epam.storage.Field;
import com.epam.storage.Structure;
import com.epam.tools.ErrorHandler;

/**
 * DescendingSorter class is responsible for descending sorting of structure
 * sets.
 */
public class DescendingSorter extends Sorter {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      fieldName
     *             Name of field to sort.
     */
    public DescendingSorter(String fieldName) {
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
            result = d.compareTo(c);

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
