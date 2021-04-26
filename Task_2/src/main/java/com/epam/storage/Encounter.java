package com.epam.storage;

/** Encounter class is responsible for storing word encounters data. */
public class Encounter {

    /**
     * Number of sentences containing the word.
     */
    private final int number;

    /**
     * The word itself.
     */
    private final String word;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      number
     *             Number of sentences containing the word.
	 * @param      word
	 *             The word itself.
     */
    public Encounter(int number, String word) {
        this.number = number;
        this.word = word;
    }

    /** Number getter. */
    public int getNumber() {
        return number;
    }

    /** Word getter. */
    public String getWord() {
        return word;
    }
}
