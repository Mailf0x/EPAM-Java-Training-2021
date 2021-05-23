package com.epam.tools;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/** ErrorHandler class is responsible for handling errors. */
public class ErrorHandler {

    /** Error message. */
    private static final String ERROR = "error:";

    /**
     * Handles file errors.
     * @param      e
     *             Exception object.
     */
    public static void handle(FileNotFoundException e) {
        final int FILE_NOT_FOUND_ERROR = 1;
        final String FILE_NOT_FOUND = "file not found";

        System.out.println(ERROR + FILE_NOT_FOUND);
        System.exit(FILE_NOT_FOUND_ERROR);
    }

    /**
     * Handles null pointer errors.
     * @param      e
     *             Exception object.
     */
    public static void handle(NullPointerException e) {
        final int NULL_POINTER_ERROR = 2;
        final String NULL_POINTER = "null pointer";

        System.out.println(ERROR + NULL_POINTER);
        System.exit(NULL_POINTER_ERROR);
    }

    /**
     * Handles SQL errors.
     * @param      e
     *             Exception object.
     */
    public static void handle(SQLException e) {
        final int SQL_ERROR = 3;
        final String SQL = "sql error";

        System.out.println(ERROR + SQL);
        System.exit(SQL_ERROR);
    }
}
