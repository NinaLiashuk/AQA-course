package by.it.academy.Md_AT1.hw4_XML.stax.parser;

import by.it.academy.Md_AT1.hw4_XML.dto.Article;
import by.it.academy.Md_AT1.hw4_XML.dto.Contacts;
import by.it.academy.Md_AT1.hw4_XML.dto.Journal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;

import java.util.List;

import static by.it.academy.Md_AT1.hw4_XML.service.CreateArticleList.createArticleList;
import static by.it.academy.Md_AT1.hw4_XML.service.CreateContacts.createContacts;
import static by.it.academy.Md_AT1.hw4_XML.stax.parser.StaxParserArticles.staxParseArticles;
import static by.it.academy.Md_AT1.hw4_XML.stax.parser.StaxParserContacts.staxParseContacts;
import static by.it.academy.Md_AT1.hw4_XML.stax.parser.StaxParserJournal.staxParseJournal;
import static org.junit.jupiter.api.Assertions.*;

class StaxParserTest {

    @Test
    @DisplayName("checking, that value Contacts after parsing the same as in XML-file")
    void parseContacts() throws XMLStreamException {
        Contacts contacts;
        contacts = staxParseContacts();

        assertTrue(contacts.equals(createContacts()),
                "assert, that contacts would have the same value as in the XML-document");
    }


    @Test
    @DisplayName("checking, that value List<Articles> after parsing the same as in XML-file")
    void parseArticle() throws XMLStreamException {
        List<Article> articleList;
        articleList = staxParseArticles();

        assertTrue(articleList.equals(createArticleList()),
                "assert, that articles would have the same value as in the XML-document");
    }

    @Test
    @DisplayName("checking, that value Journal after parsing the same as in XML-file")
    void parseJournal() throws XMLStreamException{
        Journal journal;
        journal = staxParseJournal();

        assertTrue(journal.getTitle().equals("Very Useful Journal"),
                "assert, that title would have the same value as in the XML-document");
        assertTrue(journal.getContacts().equals(createContacts()),
                "assert, that contacts would have the same value as in the XML-document");
        assertTrue(journal.getArticle().equals(createArticleList()),
                "assert, that articles would have the same value as in the XML-document");
    }
}