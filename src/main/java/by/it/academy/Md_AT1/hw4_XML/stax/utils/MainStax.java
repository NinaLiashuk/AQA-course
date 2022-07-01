package by.it.academy.Md_AT1.hw4_XML.stax.utils;

import by.it.academy.Md_AT1.hw4_XML.dto.Journal;

import javax.xml.stream.XMLStreamException;

import static by.it.academy.Md_AT1.hw4_XML.stax.parser.StaxParserJournal.staxParseJournal;

public class MainStax {

    public static void main(String[] args) throws XMLStreamException {
        Journal journal = staxParseJournal();
        System.out.println(journal);
    }
}
