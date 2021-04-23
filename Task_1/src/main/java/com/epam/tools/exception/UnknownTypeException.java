package com.epam.tools.exception;

/**
 * UnknownTypeException class is responsible for representing unknown data type
 * errors.
 */
public class UnknownTypeException extends Exception {

    /**
     * Initializes a newly created object so it represents same data as
     * argument. */
    public UnknownTypeException(String errorMessage) {
        super(errorMessage);
    }
}
