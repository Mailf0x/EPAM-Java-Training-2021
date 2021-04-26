package com.epam.tools;

import java.util.ArrayList;
import java.util.HashSet;
import com.epam.storage.Sentence;

/** UniqueWordsSelector class is responsible for selecting unique words. */
public class UniqueWordsSelector {

    /**
     * Selects unique words.
     * @param      source
     *             Set of sentences.
     * @return     Set of unique words.
     * @throws     NullPointerException
     *             If source is null.
     */
    public static ArrayList<String> select(ArrayList<Sentence> source) {
        ArrayList<String> result = null;

        try {
            HashSet<String> uwb = new HashSet<>();

            for (Sentence i : source) {
                ArrayList<String> wb = i.getWords();

                uwb.addAll(wb);
            }
            result = new ArrayList<>(uwb);

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
