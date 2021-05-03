package com.epam.tools.exception;

/**
 * InvalidInputException class is responsible for representing invalid
 * input errors.
 */
public class InvalidInputException extends Exception {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      message
     *             Error message.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
