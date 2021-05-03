package com.epam.tools;

import com.epam.storage.Field;
import com.epam.storage.Structure;
import java.util.ArrayList;

/** StructuresPrinter class is responsible for printing structures sets. */
public class StructuresPrinter {

    /**
     * Prints given set of structures.
     * @param      structures
     *             Set of structures.
     * @throws     NullPointerException
     *             If structures is null.
     */
    public static void print(ArrayList<Structure> structures) {
        final String COLON = ": ";
        final String HEADER = "STRUCTURES\n";
        final String SEPARATOR = "----------------------------------------";
        final String STRUCTURE_HEADER = "Structure %d\n";

        System.out.println(HEADER);

        try {

            for (int i = 0; i != structures.size(); i++) {
                ArrayList<Field> fields = structures.get(i).getFIELDS();

                System.out.printf(STRUCTURE_HEADER, i + 1);

                for (Field f : fields) {
                    String output = f.getName().toUpperCase() + COLON + f.getValue();

                    System.out.println(output);
                }
                System.out.println(SEPARATOR);
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
    }
}
