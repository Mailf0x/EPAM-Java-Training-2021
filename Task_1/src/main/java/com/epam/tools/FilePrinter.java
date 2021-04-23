package com.epam.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** FilePrinter class is responsible for printing file content. */
public class FilePrinter {

    /** Prints file content. */
    public static void print(String filePath) {
        Scanner scanner = null;
        String buffer = null;

        // preparing to read
        try {
            scanner = new Scanner( new File(filePath) );

        } catch (FileNotFoundException e) {
            ErrorHandler.handle(e);
        }

        // printing the file
        try {

            while ( scanner.hasNextLine() ) {
                buffer = scanner.nextLine();
                System.out.println(buffer);
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
    }
}
