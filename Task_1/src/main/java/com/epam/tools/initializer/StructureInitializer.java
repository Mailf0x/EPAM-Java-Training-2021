package com.epam.tools.initializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.epam.storage.Field;
import com.epam.storage.Structure;
import com.epam.storage.Type;
import com.epam.tools.TypeFinder;
import com.epam.tools.ErrorHandler;

/**
 * StructureInitializer class is responsible for initializing Structure
 * objects from the source file.
 */
public class StructureInitializer {

    /**
     * Reads the source file, builds Structure objects and adds them to the
     * ArrayList.
     */
    public static void initialize(ArrayList<Structure> structures,
            String source, ArrayList<Type> types) {
        ArrayList<Field> fieldsBuffer = null;
        Scanner scanner = null;
        String lineBuffer = null;
        String[] stringsBuffer = null;
        Type[] typesBuffer = null;

        // preparing to read the source file
        try {
            scanner = new Scanner( new File(source) );

        } catch (FileNotFoundException e) {
            ErrorHandler.handle(e);
        }

        // reading the source file
        try {

            // reading the header
            lineBuffer = scanner.nextLine();

            if ( lineBuffer.contains(",") ) {
                stringsBuffer = lineBuffer.split(",");
                typesBuffer = new Type[stringsBuffer.length];

                for (int i = 0; i != stringsBuffer.length; i++) {
                    typesBuffer[i] = TypeFinder.find(stringsBuffer[i], types);
                }
            }

            // reading the content
            while ( scanner.hasNextLine() ) {
                lineBuffer = scanner.nextLine();

                if ( lineBuffer.contains(",") ) {
                    stringsBuffer = lineBuffer.split(",");
                    fieldsBuffer = new ArrayList<Field>();

                    for (int i = 0; i != stringsBuffer.length; i++) {
                        fieldsBuffer.add( FieldInitializer.initialize(
                                stringsBuffer[i], typesBuffer[i]) );
                    }
                    structures.add( new Structure(fieldsBuffer) );
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
    }
}
