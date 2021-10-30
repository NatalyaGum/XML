package by.epam.task3.builder;

import by.epam.task3.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.YearMonth;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class GemHandler extends DefaultHandler {

    private Set<GemType> gems;
    private GemType current;
    private GemXmlTag currentXmlTag;
    private EnumSet<GemXmlTag> withText;

    public GemHandler() {
        gems = new HashSet<>();
        withText = EnumSet.range(GemXmlTag.COLOR, GemXmlTag.DATE_OF_PROCESSING);
    }

    public Set<GemType> getGems() {
        return gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (GemXmlTag.PRECIOUS.getTitle().equals(qName)) {
            current = new Precious();
            Name name = Name.valueOf(attrs.getValue("name").toUpperCase());
            ((Precious) current).setName(name);
            if (attrs.getValue("origin") != null) {
                current.setOrigin(attrs.getValue("origin"));
            }
            if (attrs.getValue("id") != null) {
                current.setId(attrs.getValue("id"));
            }
        } else if (GemXmlTag.SEMIPRECIOUS.getTitle().equals(qName)) {
            current = new Semiprecious();
            ((Semiprecious) current).setName(attrs.getValue("name"));
            if (attrs.getValue("origin") != null) {
                current.setOrigin(attrs.getValue("origin"));
            }
            if (attrs.getValue("id") != null) {
                current.setId(attrs.getValue("id"));
            }
        } else {
            GemXmlTag temp = GemXmlTag.valueOf(qName.toUpperCase().replace("-", "_"));
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (GemXmlTag.PRECIOUS.getTitle().equals(qName)
                || GemXmlTag.SEMIPRECIOUS.getTitle().equals(qName)) {
            gems.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case COLOR:
                    current.getParameters().setColor(GemColor.valueOf(data.toUpperCase()));
                    break;
                case TRANSPARENCY:
                    current.getParameters().setTransparency(Integer.parseInt(data));
                    break;
                case CUT:
                    current.getParameters().setCut(Integer.parseInt(data));
                    break;
                case VALUE:
                    current.setValue(Double.parseDouble(data));
                    break;
                case DATE_OF_PROCESSING:
                    current.setDate(YearMonth.parse(data));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }

}
