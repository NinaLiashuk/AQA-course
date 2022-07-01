package by.it.academy.Md_AT1.hw4_XML.stax.utils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParserUtil {
    private static final String PATH_TO_JOURNAL = "journal.xml";

    public static XMLStreamReader getReader() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try {
            reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(PATH_TO_JOURNAL));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }
}
