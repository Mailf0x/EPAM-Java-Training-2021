package com.epam.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** FileReader class is responsible for reading file content. */
public class FileReader {

    /**
     * Reads file content.
     * @param     source
     *            String with file path.
     * @return    String with file content.
     * @throws    FileNotFoundException
     *            If file path is invalid.
     */
    public static String read(String source) {
        Scanner scanner = null;
        String result = null;
        StringBuilder sb = null;

        try {
            scanner = new Scanner( new File(source) );

        } catch (FileNotFoundException e) {
            ErrorHandler.handle(e);
        }

        sb = new StringBuilder();

        while ( scanner.hasNextLine() ) {
            String t = scanner.nextLine();
            sb.append(t);
        }
        result = sb.toString();
        return result;
    }
}
