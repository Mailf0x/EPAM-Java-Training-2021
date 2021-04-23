package com.epam.tools.sorter;

import java.util.Comparator;
import com.epam.storage.Structure;
import com.epam.storage.Type;

/** Sorter class is responsible for sorting Structure objects. */
public abstract class Sorter implements Comparator<Structure> {
    protected Type type;

    /** Compares two Structure objects. */
    public abstract int compare(Structure a, Structure b);

    /** Type getter. */
    public Type getType() {
        return type;
    }
}
