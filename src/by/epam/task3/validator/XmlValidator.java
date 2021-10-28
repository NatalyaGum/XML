package by.epam.task3.validator;


import by.epam.task3.exception.GemException;
import by.epam.task3.builder.GemErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XmlValidator {
    static Logger logger = LogManager.getLogger();

    public static boolean validateXML(String xmlFilePath) throws GemException {

        final String SCHEMA_PATH = "resources/gems.xsd";
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(SCHEMA_PATH);

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFilePath);
            validator.setErrorHandler(new GemErrorHandler());
            validator.validate(source);

        } catch (SAXException exception){
        logger.error("File can't validate because: " + exception.getMessage());
        return false;

        } catch (IOException exception) {
            logger.error("File can't validate because: " + exception.getMessage());
            throw new GemException (exception);

        }
        return true;
    }

}
