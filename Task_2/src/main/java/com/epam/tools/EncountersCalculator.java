package com.epam.tools;

import com.epam.storage.*;
import java.util.ArrayList;

/**
 * EncountersCalculator class is responsible for calculating word
 * encounters.
 */
public class EncountersCalculator {

    /**
     * Calculates word encounters.
     * @param      words
     *             Set of unique words.
     * @param      sentences
     *             Set of sentences.
     * @return     Set of encounters.
     */
    public static ArrayList<Encounter> calculate(ArrayList<String> words, ArrayList<Sentence> sentences) {
        ArrayList<Encounter> result = new ArrayList<>();

        try {

            for (String i : words) {
                int e = 0;

                for (Sentence j : sentences) {
                    ArrayList<String> w = j.getWords();

                    for (String k : w) {

                        if ( i.compareTo(k) == 0 ) {
                            e += 1;
                            break;
                        }
                    }
                }
                result.add( new Encounter(e, i) );
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
