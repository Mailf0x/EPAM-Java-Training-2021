package com.epam;

import com.epam.storage.*;
import com.epam.tools.*;
import java.util.ArrayList;

/** Runner class is responsible for executing program. */
public class Runner {

    /**
     * Program entry point.
     * @param      args
     *             Set of command line arguments.
     */
    public static void main(String[] args) {
        final int SUCCESS = 0;
        final String FORMAT = "Result word is \"%s\"\n";
        final String HELP_FILE_PATH = "help\\help.txt";

        ArrayList<Encounter> encounters = null;
        ArrayList<Sentence> sentences = null;
        ArrayList<String> uniqueWords = null;
        Encounter maxEncounter = null;
        String content = null;

        if (args.length == 0) {
            FilePrinter.print(HELP_FILE_PATH);
            System.exit(SUCCESS);
        }
        content = FileReader.read(args[0]);
        sentences = SentencesParser.parse(content);
        uniqueWords = UniqueWordsSelector.select(sentences);
        encounters = EncountersCalculator.calculate(uniqueWords, sentences);
        maxEncounter = MaxEncounterFinder.find(encounters);
        System.out.printf( FORMAT, maxEncounter.getWord() );
    }
}
