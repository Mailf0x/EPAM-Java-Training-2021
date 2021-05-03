package com.epam.tools.xml;

import com.epam.tools.ErrorHandler;
import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * StructureValidator class is responsible for validating source XML files with
 * structures.
 */
public class StructureValidator {

    /**
     * Checks if source file is valid.
     * @param      sourcePath
     *             Source XML file.
     * @param      schemaPath
     *             XSD file with structure schema.
     * @throws     IOException
     *             If one of files or both don't exist.
     * @throws     SAXException
     *             If source file is invalid.
     */
    public static boolean validate(String sourcePath, String schemaPath) {
        boolean result = false;
        File schemaFile = new File(schemaPath);
        File sourceFile = new File(sourcePath);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source source = new StreamSource(sourceFile);

        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(source);
            result = true;

        } catch (IOException e) {
            ErrorHandler.handle(e);

        } catch (SAXException e) {
            ErrorHandler.handle(e);
        }
        return result;
    }
}
