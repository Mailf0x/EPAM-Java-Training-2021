package com.epam.tools.sorter;

import com.epam.storage.Field;
import com.epam.storage.Structure;
import com.epam.storage.Type;
import com.epam.tools.ErrorHandler;
import com.epam.tools.StructureComparator;

/**
 * AscendingSorter class is responsible for ascending sorting of
 * Structure objects. */
public class AscendingSorter extends Sorter {
    public AscendingSorter(Type type) {
        this.type = type;
    }

    /** Compares two Structure objects. */
    public int compare(Structure a, Structure b) {
        int result = 0;

        // comparing objects
        try {
            result = StructureComparator.compare(a, b, type);

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
