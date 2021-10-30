package by.epam.task3.builder;

import by.epam.task3.exception.GemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxBuilder extends GemBuilder{
    private static Logger logger = LogManager.getLogger();
    private GemHandler handler = new GemHandler();
    private XMLReader reader;

    public SaxBuilder() {
        super();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException ex) {
            logger.error("Error in Sax: " + ex.getMessage());

        }
        reader.setErrorHandler(new GemErrorHandler());
        reader.setContentHandler(handler);
    }

    @Override
    public void buildSetGems(String filename) throws GemException {
        try {
            reader.parse(filename);
        } catch (IOException ex) {
            logger.error("Error in Sax, check your filename: " + filename,ex);
            throw new GemException("Error in Sax, check your filename: " + filename,ex);
        } catch (SAXException ex) {
            logger.error("Error in Sax: " + ex.getMessage());
            throw new GemException("Error in Sax: " + ex.getMessage());
        }
        gems = handler.getGems();
        logger.info("Gems from sax builder are:\n" + gems);
    }
}
