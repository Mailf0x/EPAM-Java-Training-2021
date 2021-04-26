package com.epam.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** FilePrinter class is responsible for printing file content. */
public class FilePrinter {

    /**
     * Prints file content.
     * @param      source
     *             String with file path.
     * @throws     FileNotFoundException
     *             If file path is invalid.
     */
    public static void print(String source) {
        Scanner scanner = null;
        String buffer = null;

        try {
            scanner = new Scanner( new File(source) );

        } catch (FileNotFoundException e) {
            ErrorHandler.handle(e);
        }

        while ( scanner.hasNextLine() ) {
            buffer = scanner.nextLine();
            System.out.println(buffer);
        }
    }
}
