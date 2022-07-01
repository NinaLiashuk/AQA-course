package by.it.academy.Md_AT1.hw4_XML.dom.utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import static by.it.academy.Md_AT1.hw4_XML.dom.parser.DomParserDemo.setAllNodesToJournal;
import static by.it.academy.Md_AT1.hw4_XML.dom.utils.DomParserUtil.parseXMLDocument;

public class MainDom {

    private static final String PATH_TO_JOURNAL = "journal.xml";
    private static Document document = parseXMLDocument(PATH_TO_JOURNAL);

    public static void main(String[] args) {
        NodeList nodeList = document.getChildNodes();
        System.out.println(setAllNodesToJournal(nodeList));
    }
}
