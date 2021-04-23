package com.epam;

import java.util.ArrayList;
import java.util.Collections;

import com.epam.storage.*;
import com.epam.tools.*;
import com.epam.tools.exception.InvalidInputException;
import com.epam.tools.initializer.*;
import com.epam.tools.sorter.*;

/** {@code Runner} class is responsible for executing program */
public class Runner {

    /** Program entry point. */
    public static void main(String args[]) {

        // success exit code
        final int SUCCESS = 0;

        // argument numbers
        final int SORT_ARGUMENTS = 1;
        final int FILTER_ARGUMENTS = 3;

        // file pathes
        final String HELP_FILE = "help\\help.txt";
        final String STRUCTURES_FILE = "data\\structures.csv";
        final String TYPES_FILE = "data\\types.csv";

        // keys
        final String ASCENDING_SORT_KEY = "-sa";
        final String DESCENDING_SORT_KEY = "-sd";
        final String FILTER_KEY = "-f";
        final String HELP_KEY = "-h";
        final String MINUS = "-";
        final String SORT_KEY = "-s";

        ArrayList<Structure> structures = new ArrayList<Structure>();
        ArrayList<Type> types = new ArrayList<Type>();
        Field ceil = null;
        Field floor = null;
        Sorter sorter = null;
        Type type = null;

        // checking arguments existence
        if (args.length == 0) {
            FilePrinter.print(HELP_FILE);
            System.exit(SUCCESS);
        }

        // initializing types
        TypeInitializer.initialize(types, TYPES_FILE);

        // initializing structures
        StructureInitializer.initialize(structures, STRUCTURES_FILE, types);

        // recognizing command line arguments
        try {

            for (int i = 0; i != args.length; i++) {

                // recognizing sort commands
                if ( args[i].contains(SORT_KEY) ) {

                    // checking syntax
                    if ( i + SORT_ARGUMENTS < args.length
                            && !args[i+1].contains(MINUS) ) {
                        type = TypeFinder.find(args[i+1], types);

                    } else {
                        throw new InvalidInputException(null);
                    }

                    if ( args[i].compareTo(ASCENDING_SORT_KEY) == 0 ) {
                        sorter = new AscendingSorter(type);

                    } else if ( args[i].compareTo(DESCENDING_SORT_KEY)
                            == 0 ) {
                        sorter = new DescendingSorter(type);
                    }
                    Collections.sort(structures, sorter);

                    // skipping arguments
                    i += SORT_ARGUMENTS;

                // recognizing filter command
                } else if ( args[i].compareTo(FILTER_KEY) == 0 ) {

                    // checking syntax
                    if ( i + FILTER_ARGUMENTS < args.length
                            && !args[i+1].contains(MINUS)
                            && !args[i+2].contains(MINUS)
                            && !args[i+3].contains(MINUS) ) {
                        type = TypeFinder.find(args[i+1], types);

                    } else {
                        throw new InvalidInputException(null);
                    }

                    floor = FieldInitializer.initialize(args[i+2], type);
                    ceil = FieldInitializer.initialize(args[i+3], type);
                    structures = StructureFilter
                            .filter(structures, floor, ceil);

                    // skipping arguments
                    i += FILTER_ARGUMENTS;

                // recognizing help command
                } else if ( args[i].compareTo(HELP_KEY) == 0 ) {
                    FilePrinter.print(HELP_FILE);
                    System.exit(SUCCESS);

                } else {
                    throw new InvalidInputException(null);
                }
            }
            StructurePrinter.print(structures);

        } catch (InvalidInputException e) {
            ErrorHandler.handle(e);
        }
    }
}
