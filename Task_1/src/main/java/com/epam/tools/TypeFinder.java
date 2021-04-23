package com.epam.tools;

import java.util.ArrayList;
import com.epam.storage.Type;

/** TypeFinder class is responsible for finding Type object. */
public class TypeFinder {

    /** Find method finds Type object by its name. */
    public static Type find(String name, ArrayList<Type> types) {
        Type result = null;

        // finding Type object
        try {

            for (int i = 0; i != types.size(); i++) {

                if ( types.get(i).getName().compareTo(name) == 0 ) {
                    result = types.get(i);
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
