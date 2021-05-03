package com.epam.tools.xml;

import com.epam.storage.Structure;
import com.epam.tools.ErrorHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/** StructureParser class is responsible for parsing structures. */
public class StructureParser {

    /**
     * Parses structures from source XML file.
     * @param      source
     *             Source file path.
     * @throws     IOException
     *             If file doesn't exist.
     * @throws     SAXException
     *             If source file is invalid.
     */
    public static ArrayList<Structure> parseStructures(String source) {
        ArrayList<Structure> result = null;
        SAXParser saxParser;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        StructureHandler structureHandler = new StructureHandler();

        try {
            saxParser = factory.newSAXParser();
            saxParser.parse( new File(source), structureHandler);
            result = structureHandler.getSTRUCTURES();

        } catch (IOException e) {
            ErrorHandler.handle(e);

        } catch (ParserConfigurationException e) {
            ErrorHandler.handle(e);

        } catch (SAXException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
