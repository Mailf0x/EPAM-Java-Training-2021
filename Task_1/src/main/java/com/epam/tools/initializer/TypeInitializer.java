package com.epam.tools.initializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.epam.storage.Type;
import com.epam.tools.ErrorHandler;

/**
 * TypeInitializer class is responsible for initializing Type objects
 * from the source file.
 */
public class TypeInitializer {

    /**
     * Reads source file, builds Type objects and adds them to the ArrayList.
     */
    public static void initialize(ArrayList<Type> types, String source) {
        Scanner scanner = null;
        String lineBuffer = null;
        String[] stringsBuffer = null;
        String dataTypeBuffer = null;
        String nameBuffer = null;

        // preparing to read the source file
        try {
            scanner = new Scanner( new File(source) );

        } catch (FileNotFoundException e) {
            ErrorHandler.handle(e);
        }

        // reading the source file
        try {

            // skipping the header
            scanner.nextLine();

            // reading the content
            while ( scanner.hasNextLine() ) {
                lineBuffer = scanner.nextLine();

                if ( lineBuffer.contains(",") ) {
                    stringsBuffer = lineBuffer.split(",");
                    nameBuffer = stringsBuffer[0];
                    dataTypeBuffer = stringsBuffer[1];
                    types.add( new Type(dataTypeBuffer, nameBuffer) );
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
    }
}
