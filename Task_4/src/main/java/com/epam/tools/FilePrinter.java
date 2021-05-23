package com.epam.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** FilePrinter class is responsible for printing files. */
public class FilePrinter {

    /**
     * Prints file.
     * @param      filePath
     *             Path to file.
     * @throws     FileNotFoundException
     *             If file doesn't exist.
     */
    public static void print(String filePath) {
        Scanner scanner = null;

        try {
            scanner = new Scanner( new File(filePath) );

        } catch (FileNotFoundException e) {
            ErrorHandler.handle(e);
        }

        while ( scanner.hasNextLine() ) {
            String buffer = scanner.nextLine();
            System.out.println(buffer);
        }
    }
}
