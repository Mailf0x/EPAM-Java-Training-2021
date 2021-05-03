package com.epam.tools;

import com.epam.tools.exception.*;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/** ErrorHandler class is responsible for handling exceptions. */
public class ErrorHandler {

    /** Error message. */
    private static final String ERROR = "error: ";

    /**
     * Handles input/output exceptions.
     * @param      e
     *             Exception itself.
     */
    public static void handle(IOException e) {
        final int INPUT_OUTPUT_EXCEPTION = 1;
        final String INPUT_OUTPUT = "input/output error";

        System.out.println(ERROR + INPUT_OUTPUT);
        System.exit(INPUT_OUTPUT_EXCEPTION);
    }

    /**
     * Handles invalid input exceptions.
     * @param      e
     *             Exception itself.
     */
    public static void handle(InvalidInputException e) {
        final int INVALID_INPUT_EXCEPTION = 2;
        final String INVALID_INPUT = "invalid input";

        System.out.println(ERROR + INVALID_INPUT);
        System.exit(INVALID_INPUT_EXCEPTION);
    }

    /**
     * Handles invalid XML file exceptions.
     * @param      e
     *             Exception itself.
     */
    public static void handle(InvalidXMLException e) {
        final int INVALID_XML_EXCEPTION = 3;
        final String INVALID_XML = "invalid XML file";

        System.out.println(ERROR + INVALID_XML);
        System.exit(INVALID_XML_EXCEPTION);
    }

    /**
     * Handles null pointer exceptions.
     * @param      e
     *             Exception itself.
     */
    public static void handle(NullPointerException e) {
        final int NULL_POINTER_EXCEPTION = 4;
        final String NULL_POINTER = "null pointer";

        System.out.println(ERROR + NULL_POINTER);
        System.exit(NULL_POINTER_EXCEPTION);
    }

    /**
     * Handles parser configuration exceptions.
     * @param      e
     *             Exception itself.
     */
    public static void handle(ParserConfigurationException e) {
        final int PARSER_CONFIGURATION_EXCEPTION = 5;
        final String PARSER_CONFIGURATION = "parser configuration error";

        System.out.println(ERROR + PARSER_CONFIGURATION);
        System.exit(PARSER_CONFIGURATION_EXCEPTION);
    }

    /**
     * Handles SAX exceptions.
     * @param      e
     *             Exception itself.
     */
    public static void handle(SAXException e) {
        final int SAX_EXCEPTION = 6;
        final String SAX = "invalid XML file";

        System.out.println(ERROR + SAX);
        System.exit(SAX_EXCEPTION);
    }

    /**
     * Handles unknown type exceptions.
     * @param      e
     *             Exception itself.
     */
    public static void handle(UnknownTypeException e) {
        final int UNKNOWN_TYPE_EXCEPTION = 7;
        final String UNKNOWN_TYPE = "unknown type";

        System.out.println(ERROR + UNKNOWN_TYPE);
        System.exit(UNKNOWN_TYPE_EXCEPTION);
    }
}
