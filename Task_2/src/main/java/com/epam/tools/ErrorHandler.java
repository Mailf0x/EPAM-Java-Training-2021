package com.epam.tools;

import java.io.FileNotFoundException;

/** ErrorHandler class is responsible for handling exceptions */
public class ErrorHandler {

    /** Error message format. */
    private static final String ERROR = "error: ";

    /** Handles FileNotFoundException. */
    public static void handle(FileNotFoundException e) {
        final int FILE_NOT_FOUND_ERROR = 1;
        final String FILE_NOT_FOUND = "file not found";

        System.out.println(ERROR + FILE_NOT_FOUND);
        System.exit(FILE_NOT_FOUND_ERROR);
    }

    /** Handles NullPointerException. */
    public static void handle(NullPointerException e) {
        final int NULL_POINTER_ERROR = 2;
        final String NULL_POINTER = "null pointer";

        System.out.println(ERROR + NULL_POINTER);
        System.exit(NULL_POINTER_ERROR);
    }
}
