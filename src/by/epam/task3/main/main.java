package by.epam.task3.main;

import by.epam.task3.builder.BuilderFactory;
import by.epam.task3.builder.DomBuilder;
import by.epam.task3.builder.SaxBuilder;
import by.epam.task3.builder.StaxBuilder;
import by.epam.task3.entity.Gem;
import by.epam.task3.exception.GemException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class main {
    public static Set<Gem> setGems;

    public static void main(String[] args) throws GemException {
        String path="resources/gems.xml";
       // SaxBuilder GemsBuilder = (SaxBuilder) BuilderFactory.createGemBuilder("Sax");
      //  StaxBuilder GemsBuilder = (StaxBuilder) BuilderFactory.createGemBuilder("Stax");
        DomBuilder GemsBuilder = (DomBuilder) BuilderFactory.createGemBuilder("DOM");
        GemsBuilder.buildSetGems(path);
        setGems=GemsBuilder.getGems();
        setGems.forEach(System.out::println);
    }
}
