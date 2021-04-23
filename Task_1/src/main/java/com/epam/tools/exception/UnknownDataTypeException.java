package com.epam.tools.exception;

/**
 * UnknownDataTypeException class is responsible for representing 
 * unknown data type errors.
 */
public class UnknownDataTypeException extends Exception {

    /**
     * Initializes a newly created object so it represents same data as
     * argument. */
    public UnknownDataTypeException(String errorMessage) {
        super(errorMessage);
    }
}
