package by.epam.task3.validator;

import by.epam.task3.exception.GemException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XmlValidatorTest {

    @Test
    public void testValidateXML() throws GemException {
        XmlValidator validator = new XmlValidator();
        boolean actual  = validator.validateXML("test_resources/gems.xml","test_resources/gems.xsd");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateXMLError() throws GemException {
        XmlValidator validator = new XmlValidator();
        boolean actual  = validator.validateXML("test_resources/gemsError.xml","test_resources/gems.xsd");
        Assert.assertTrue(actual,"There are multiple occurrences of ID value");
    }

    @Test
    public void testValidateXMLFatal() throws GemException {
        XmlValidator validator = new XmlValidator();
        boolean actual  = validator.validateXML("test_resources/gemsFatal.xml","test_resources/gems.xsd");
        Assert.assertFalse(actual,"FATAL GemErrorHandler");
    }
    }
