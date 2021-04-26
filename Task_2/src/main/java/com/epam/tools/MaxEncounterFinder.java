package com.epam.tools;

import com.epam.storage.Encounter;
import java.util.ArrayList;

/** MaxEncounterFinder class is responsible for finding most frequent word. */
public class MaxEncounterFinder {

    /**
     * Finds most frequent word.
     * @param      source
     *             Set of word encounters.
     * @return     Encounter of most frequent word.
     * @throws     NullPointerException
     *             If source is null.
     */
    public static Encounter find(ArrayList<Encounter> source) {
        Encounter result = null;

        try {
            result = source.get(0);

            for (Encounter i : source) {

                if ( i.getNumber() > result.getNumber() ) {

                    result = i;
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
