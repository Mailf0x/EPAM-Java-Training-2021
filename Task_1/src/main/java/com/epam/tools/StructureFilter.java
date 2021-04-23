package com.epam.tools;

import java.util.ArrayList;
import com.epam.storage.Field;
import com.epam.storage.Structure;
import com.epam.storage.Type;

/** StructureFilter class is responsible for filtering Structure objects. */
public class StructureFilter {

    /** Filters Structure objects array. */
    public static ArrayList<Structure> filter(ArrayList<Structure>
            structures, Field floor, Field ceil) {
        ArrayList<Structure> result = new ArrayList<Structure>();
        Field f = null;
        Structure s = null;
        Type t = null;

        // filtering objects
        try {
            t = floor.getType();

            for (int i = 0; i != structures.size(); i++) {
                s = structures.get(i);
                f = s.getField(t);

                if ( f.compareTo(floor) >= 0 && f.compareTo(ceil) <= 0 ) {
                    result.add(s);
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
