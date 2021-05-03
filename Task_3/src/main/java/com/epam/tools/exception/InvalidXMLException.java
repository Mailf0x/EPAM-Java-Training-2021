package com.epam.tools.exception;

/**
 * InvalidXMLException class is responsible for representing invalid XML file
 * errors.
 */
public class InvalidXMLException extends Exception {

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     * @param      message
     *             Error message.
     */
    public InvalidXMLException(String message) {
        super(message);
    }
}
