package by.epam.task3.main;

import by.epam.task3.builder.BuilderFactory;
import by.epam.task3.builder.DomBuilder;
import by.epam.task3.builder.SaxBuilder;
import by.epam.task3.builder.StaxBuilder;
import by.epam.task3.entity.GemType;
import by.epam.task3.exception.GemException;
import by.epam.task3.validator.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class main {
    static Logger logger = LogManager.getLogger();
    public static Set<GemType> setGems;

    public static void main(String[] args) throws GemException {
        String path="resources/gems.xml";
        XmlValidator validator= new XmlValidator();
          if ( validator.validateXML(path,"resources/gems.xsd")) {
           logger.info("File is good");}

       SaxBuilder gemsBuilder = (SaxBuilder) BuilderFactory.createGemBuilder("Sax");
        //StaxBuilder gemsBuilder = (StaxBuilder) BuilderFactory.createGemBuilder("Stax");
        //DomBuilder gemsBuilder = (DomBuilder) BuilderFactory.createGemBuilder("DOM");
        gemsBuilder.buildSetGems(path);
        setGems=gemsBuilder.getGems();
        setGems.forEach(System.out::println);
    }
}
