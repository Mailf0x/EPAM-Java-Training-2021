package com.epam.tools.xml;

import com.epam.storage.*;
import com.epam.tools.ErrorHandler;
import com.epam.tools.FieldInitializer;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * StructureHandler class is responsible for reading XML files with structures.
 */
public class StructureHandler extends DefaultHandler {

    /** Set of structures. */
    private final ArrayList<Structure> STRUCTURES;
    private final String FIELD = "field";
    private final String STRUCTURE = "structure";
    private ArrayList<Field> fields;
    private String id;
    private String name;
    private String type;
    private String value;

    /**
     * Initializes a newly created object so it represents same data as
     * arguments.
     */
    public StructureHandler() {
        STRUCTURES = new ArrayList<>();
    }

    /** Structures getter. */
    public ArrayList<Structure> getSTRUCTURES() {
        return STRUCTURES;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        value = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        try {

            if ( qName.equalsIgnoreCase(STRUCTURE) ) {
                STRUCTURES.add( new Structure(fields, id) );

            } else if ( qName.equalsIgnoreCase(FIELD) ) {
                fields.add( FieldInitializer.initialize(name, type, value) );
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        try {

            if ( qName.equalsIgnoreCase(STRUCTURE) ) {
                fields = new ArrayList<>();
                id = attrs.getValue(0);

            } else if ( qName.equalsIgnoreCase(FIELD) ) {
                name = attrs.getValue(0);
                type = attrs.getValue(1);
            }

        } catch (NullPointerException e) {
            ErrorHandler.handle(e);
        }
    }
}
