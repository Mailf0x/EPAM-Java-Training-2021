package com.epam.tools.sorter;

import com.epam.storage.Structure;
import java.util.Comparator;

/** Sorter class is responsible for sorting of structure sets. */
public abstract class Sorter implements Comparator<Structure> {

    /** Name of field to sort. */
    protected String fieldName;

    /** Compares two Structure class objects. */
    public abstract int compare(Structure a, Structure b);
}
