package com.epam;

import com.epam.storage.*;
import com.epam.tools.*;
import com.epam.tools.exception.*;
import com.epam.tools.sorter.*;
import com.epam.tools.xml.*;
import java.util.ArrayList;
import java.util.Collections;

/** Runner class is responsible for executing program. */
public class Runner {

    /**
     * Program entry point.
     * @param      args
     *             Set of command line arguments.
     * @throws     InvalidInputException
     *             In case of invalid user input.
     * @throws     InvalidXMLException
     *             If source XML file is invalid.
     */
    public static void main(String[] args) {
        final int FILTER_ARGUMENTS = 3;
        final int SORT_ARGUMENTS = 1;
        final int SUCCESS = 0;
        final String ASCENDING_SORT_KEY = "-sa";
        final String DESCENDING_SORT_KEY = "-sd";
        final String FILTER_KEY = "-f";
        final String HELP_KEY = "-h";
        final String MANUAL = "help\\manual.txt";
        final String MINUS = "-";
        final String SCHEMA = "data\\structures.xsd";
        final String SORT_KEY = "-s";
        final String STRUCTURES = "data\\structures.xml";
        ArrayList<Structure> structures = null;
        Sorter sorter = null;

        if (args.length == 0) {
            FilePrinter.print(MANUAL);
            System.exit(SUCCESS);
        }

        try {
            boolean validXMLFile = StructureValidator.validate(STRUCTURES, SCHEMA);

            if (validXMLFile) {
                structures = StructureParser.parseStructures(STRUCTURES);

            } else {
                throw new InvalidXMLException(null);
            }

        } catch (InvalidXMLException e) {
            ErrorHandler.handle(e);
        }

        try {

            for (int i = 0; i != args.length; i++) {

                if ( args[i].contains(SORT_KEY) ) {

                    if (i + SORT_ARGUMENTS < args.length && !args[i + 1].contains(MINUS)) {

                        if (args[i].equalsIgnoreCase(ASCENDING_SORT_KEY)) {
                            sorter = new AscendingSorter(args[i + 1]);

                        } else if (args[i].equalsIgnoreCase(DESCENDING_SORT_KEY)) {
                            sorter = new DescendingSorter(args[i + 1]);

                        } else {
                            throw new InvalidInputException(null);
                        }
                        Collections.sort(structures, sorter);

                        i += SORT_ARGUMENTS;

                    } else {
                        throw new InvalidInputException(null);
                    }

                } else if ( args[i].equalsIgnoreCase(FILTER_KEY) ) {

                    if ( i + FILTER_ARGUMENTS < args.length && !args[i+1].contains(MINUS) && !args[i+2].contains(MINUS) && !args[i+3].contains(MINUS) ) {
                        structures = StructuresFilter.filter(structures, args[i+1], args[i+2], args[i+3]);
                        i += FILTER_ARGUMENTS;

                    } else {
                        throw new InvalidInputException(null);
                    }

                } else if ( args[i].equalsIgnoreCase(HELP_KEY) ) {

                    FilePrinter.print(MANUAL);
                    System.exit(SUCCESS);

                } else {
                    throw new InvalidInputException(null);
                }
            }

        } catch (InvalidInputException e) {
            ErrorHandler.handle(e);
        }
        StructuresPrinter.print(structures);
    }
}
