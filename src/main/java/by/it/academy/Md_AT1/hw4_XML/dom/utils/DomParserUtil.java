package by.it.academy.Md_AT1.hw4_XML.dom.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DomParserUtil {

    public static DocumentBuilder createDocumentBuilder(){
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("ParserConfigurationException log");
            return null;
        }
    }

    public static Document parseXMLDocument(String path){
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if(null != documentBuilder){
            try {
                document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(path));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("IOException log");
            }
        }
        return document;
    }
}
