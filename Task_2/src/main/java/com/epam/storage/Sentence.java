package com.epam.storage;

import java.util.ArrayList;

/** Sentence class is responsible for storing sentence data. */
public class Sentence {

    /** Set of sentence words. */
    private final ArrayList<String> words;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      words
     *             Set of sentence words.
     */
    public Sentence(ArrayList<String> words) {
        this.words = words;
    }

    /** Words getter. */
    public ArrayList<String> getWords() {
        return words;
    }
}
