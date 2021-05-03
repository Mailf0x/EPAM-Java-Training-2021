package com.epam.tools.exception;

/**
 * UnknownTypeException class is responsible for representing unknown type
 * errors.
 */
public class UnknownTypeException extends Exception {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      message
     *             Error message.
     */
    public UnknownTypeException(String message) {
        super(message);
    }
}
