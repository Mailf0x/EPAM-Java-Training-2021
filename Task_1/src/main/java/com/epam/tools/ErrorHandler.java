package com.epam.tools;

import java.io.FileNotFoundException;
import com.epam.tools.exception.*;

/** ErrorHandler class is responsible for handling exceptions. */
public class ErrorHandler {

    /** Error message. */
    private static final String ERROR = "error: ";

    /** Handles FileNotFoundException. */
    public static void handle(FileNotFoundException e) {
        final int FILE_NOT_FOUND_ERROR = 1;
        final String FILE_NOT_FOUND = "file not found";

        System.out.println(ERROR + FILE_NOT_FOUND);
        System.exit(FILE_NOT_FOUND_ERROR);
    }

    /** Handles InvalidInputException. */
    public static void handle(InvalidInputException e) {
        final int INVALID_INPUT_ERROR = 2;
        final String INVALID_INPUT = "invalid input";

        System.out.println(ERROR + INVALID_INPUT);
        System.exit(INVALID_INPUT_ERROR);
    }

    /** Handles NullPointerException. */
    public static void handle(NullPointerException e) {
        final int NULL_POINTER_ERROR = 3;
        final String NULL_POINTER = "null pointer";

        System.out.println(ERROR + NULL_POINTER);
        System.exit(NULL_POINTER_ERROR);
    }

    public static void handle(NumberFormatException e) {
        final int NUMBER_FORMAT_ERROR = 4;
        final String NUMBER_FORMAT = "invalid number format";

        System.out.println(ERROR + NUMBER_FORMAT);
		System.exit(NUMBER_FORMAT_ERROR);
	}

    /** Handles UnknownDataTypeException. */
    public static void handle(UnknownDataTypeException e) {
        final int UNKNOWN_DATA_TYPE_ERROR = 5;
        final String UNKNOWN_DATA_TYPE = "unknown data type";

        System.out.println(ERROR + UNKNOWN_DATA_TYPE);
        System.exit(UNKNOWN_DATA_TYPE_ERROR);
    }

    /** Handles UnknownTypeException. */
    public static void handle(UnknownTypeException e) {
        final int UNKNOWN_TYPE_ERROR = 6;
        final String UNKNOWN_TYPE = "unknown type";

        System.out.println(ERROR + UNKNOWN_TYPE);
        System.exit(UNKNOWN_TYPE_ERROR);
    }
}
