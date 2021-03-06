package by.epam.task3.builder;

import by.epam.task3.entity.*;
import by.epam.task3.exception.GemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Set;

public class DomBuilder extends GemBuilder {
    private static Logger logger = LogManager.getLogger();
    private DocumentBuilder documentBuilder;

    @Override
    public Set<GemType> getGems() {
        return super.getGems();
    }

    public DomBuilder() {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            logger.error( "Error in Dom: " + ex.getMessage());
        }
    }

    @Override
    public void buildSetGems(String filename) throws GemException {
        Document doc;
        try {
            doc = documentBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList semipreciousList = root.getElementsByTagName("semiprecious");
            NodeList preciousList = root.getElementsByTagName("precious");
            for (int i = 0; i < semipreciousList.getLength(); i++) {
                Element gemElement = (Element) semipreciousList.item(i);
                Semiprecious gem = buildSemiprecious(gemElement);
                gems.add(gem);
            }
            for (int i = 0; i < preciousList.getLength(); i++) {
                Element gemElement = (Element) preciousList.item(i);
                Precious gem = buildPrecious(gemElement);
                gems.add(gem);
            }
        } catch (IOException ex) {
            logger.error( "Error in Dom, check your filename: " + filename,ex);
            throw new GemException("Error in Dom, check your filename: " + filename,ex);
        } catch (SAXException ex) {
            logger.error( "Error in Dom: " + ex.getMessage());
            throw new GemException("Error in Dom: " + ex.getMessage());
        }
        logger.info( "Gems from dom builder are:\n" + gems);
    }

    private Semiprecious buildSemiprecious(Element element) {
        Semiprecious semiprecious = new Semiprecious();
        semiprecious.setName(element.getAttribute("name"));
        build(element, semiprecious);
        return semiprecious;
    }

    private Precious buildPrecious(Element element) {
        Precious precious = new Precious();
        Name name = Name.valueOf(element.getAttribute("name").toUpperCase());
        precious.setName(name);
        build(element, precious);
        return precious;
    }

    private void build(Element element, GemType gem) {
        if (element.getAttribute("origin")!= null){
        gem.setOrigin(element.getAttribute("origin"));}
        gem.setId(element.getAttribute("id"));
        VisualParameters parameters = gem.getParameters();
        Element parametersElement = (Element) element.getElementsByTagName("visual-parameters").item(0);
        parameters.setColor(GemColor.valueOf(getElementTextContent(parametersElement, "color").toUpperCase()));
        parameters.setTransparency(Integer.parseInt(getElementTextContent(parametersElement, "transparency")));
        parameters.setCut(Integer.parseInt(getElementTextContent(parametersElement, "cut")));
        gem.setValue(Double.parseDouble(getElementTextContent(element, "value")));
        String date = getElementTextContent(element, "date-of-processing");
        gem.setDate(YearMonth.parse(date));
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
