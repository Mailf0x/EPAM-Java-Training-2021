package com.epam.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** FileReader class is responsible for reading files. */
public class FileReader {

    /**
     * Reads file.
     * @param      filePath
     *             Path to file.
     * @throws     FileNotFoundException
     *             If file doesn't exist.
     */
    public static String read(String filePath) {
        Scanner scanner = null;
        String result = null;

        try {
            scanner = new Scanner( new File(filePath) );

        } catch (FileNotFoundException e) {
            ErrorHandler.handle(e);
        }

        StringBuilder sb = new StringBuilder();

        while ( scanner.hasNextLine() ) {
            String s = scanner.nextLine();

            sb.append(s);
        }
        result = sb.toString();
        return result;
    }
}
