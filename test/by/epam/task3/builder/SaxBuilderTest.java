package by.epam.task3.builder;

import by.epam.task3.entity.GemType;
import by.epam.task3.entity.Semiprecious;
import by.epam.task3.entity.VisualParameters;
import by.epam.task3.exception.GemException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.YearMonth;
import java.util.Set;

import static by.epam.task3.entity.GemColor.PURPLE;
import static org.testng.Assert.*;

public class SaxBuilderTest {
    SaxBuilder gemsBuilder;

    @BeforeTest
    public void init() {
         gemsBuilder=new SaxBuilder();
    }

    @Test
    public void testBuildSetGems() throws GemException {
        String xmlPath="test_resources/gems.xml";
        gemsBuilder.buildSetGems(xmlPath);
        Set<GemType> actual=gemsBuilder.getGems();

        Semiprecious expected=new Semiprecious();
        expected.setName("citrine");
        expected.setOrigin("Germany");
        expected.setId("gem-1");
        VisualParameters visualParameter=new VisualParameters();
        visualParameter.setColor(PURPLE);
        visualParameter.setTransparency(26);
        visualParameter.setCut(5);
        expected.setParameters(visualParameter);
        expected.setValue(5.7);
        expected.setDate(YearMonth.parse("2015-01"));

        Assert.assertTrue(actual.contains(expected));

    }

    @Test (expectedExceptions = GemException.class, expectedExceptionsMessageRegExp = ".*Error in Sax, check your filename:.*")
    public void testBuildSetGemsError() throws GemException {
        String xmlPath="test_resources/gemsNone.xml";

        gemsBuilder.buildSetGems(xmlPath);
    }
}