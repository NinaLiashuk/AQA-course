package by.it.academy.Md_AT1.hw4_XML.dom.parser;

import by.it.academy.Md_AT1.hw4_XML.dto.Article;
import by.it.academy.Md_AT1.hw4_XML.dto.Contacts;
import by.it.academy.Md_AT1.hw4_XML.dto.Journal;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static by.it.academy.Md_AT1.hw4_XML.dom.parser.DomParserDemo.*;
import static by.it.academy.Md_AT1.hw4_XML.dom.utils.DomParserUtil.parseXMLDocument;
import static by.it.academy.Md_AT1.hw4_XML.service.CreateArticleID1.createArticleId1;
import static by.it.academy.Md_AT1.hw4_XML.service.CreateArticleID2.createArticleId2;
import static by.it.academy.Md_AT1.hw4_XML.service.CreateArticleList.createArticleList;
import static by.it.academy.Md_AT1.hw4_XML.service.CreateContacts.createContacts;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DomParserDemoTest {
    private static final String PATH_TO_JOURNAL = "journal.xml";
    static Document document = parseXMLDocument(PATH_TO_JOURNAL);


    @Test
    void method_parseContacts_return_Contact_with_data() {
        Contacts contacts = new Contacts();
        NodeList nodeList = document.getElementsByTagName("contacts");
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            contacts = parseContacts(node);
        }
        assertTrue(contacts.equals(createContacts()),
                "assert, that contacts have the same value as in the XML-document");
    }

    @Test
    void method_parseArticle_return_Article_with_data() {
        Article articleParse = new Article();
        NodeList nodeList = document.getElementsByTagName("article");
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(0);
            articleParse = parseArticle(node);
        }
        assertTrue(articleParse.equals(createArticleId1()),
                "assert, that article has the same value as in the XML-document");
        assertThat(articleParse).isNotSameAs(createArticleId1());
    }

    @Test
    void method_setArticlesInList_set_all_articles_in_ArrayList() {
        List<Article> articleList = new ArrayList<>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            articleList = setArticlesInList(node);
        }
        assertThat(articleList)
                .isNotNull()
                .hasSize(2);

        assertTrue(articleList.contains(createArticleId1()),
                "assert, that List<Article> contains data from first node <article> from the XML-file");

        assertTrue(articleList.contains(createArticleId2()),
                "assert, that List<Article> contains data from second node <article> from the XML-file");
    }

    @Test
    void checking_that_method_set_all_nodes_to_journal() {
        Journal journal;
        NodeList nodeList = document.getChildNodes();
        journal = setAllNodesToJournal(nodeList);

        assertTrue(journal.getTitle().equals("Very Useful Journal"),
                "assert, that title has the same value as in the XML-document");
        assertTrue(journal.getContacts().equals(createContacts()),
                "assert, that contacts have the same value as in the XML-document");
        assertTrue(journal.getArticle().equals(createArticleList()),
                "assert, that articles have the same value as in the XML-document");
    }

    @Test
    void method_should_return_node_of_Contacts() {
        Node nodeOfContacts = getNodeOfContacts();

        assertTrue(nodeOfContacts.getNodeName().equals("contacts"),
                "assert, that name of node Contacts is 'contacts'");
    }

    @Test
    void method_should_return_node_of_Articles() {
        Node nodeOfArticles = getNodeOfArticles();

        assertThat(nodeOfArticles.getNodeName())
                .isEqualTo("articles")
                .isNotEqualTo("article");

        assertTrue(nodeOfArticles.getNodeName().equals("articles"),
                "assert, that name of node Articles is 'articles'");
    }

    @Test
    void method_return_node_of_Articles_should_be_failed() {
        Node nodeOfArticles = getNodeOfArticles();

        assertTrue(nodeOfArticles.getNodeName().equals("article"),
                "assert, that name of node Articles is 'articles'");
    }
}