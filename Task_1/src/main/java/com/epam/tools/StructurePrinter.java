package com.epam.tools;

import java.util.ArrayList;
import com.epam.storage.Field;
import com.epam.storage.Structure;

/** StructurePrinter class is responsible for printing Structure object. */
public class StructurePrinter {

    /** Prints Structure object. */
    public static void print(ArrayList<Structure> structures) {
        final String FORMATION = "%s: %s\n";
        final String HEADER = "STRUCTURES";
        final String SEPARATOR = "--------------------------------";

        ArrayList<Field> fieldsBuffer = null;
        Field fieldBuffer = null;

        // printing structures
        try {

            System.out.println(SEPARATOR);
            System.out.println(HEADER);

            for (int i = 0; i != structures.size(); i++) {
                fieldsBuffer = structures.get(i).getFields();
                System.out.println(SEPARATOR);

                for (int j = 0; j != fieldsBuffer.size(); j++) {
                    fieldBuffer = fieldsBuffer.get(j);
                    System.out.printf( FORMATION,
                            fieldBuffer.getType().getName(),
                            fieldBuffer.getValue() );
                }

                if ( i == structures.size() - 1 ) {
                    System.out.println(SEPARATOR);
                }
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
    }
}
