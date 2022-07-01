package by.it.academy.Md_AT1.hw4_XML.dom.parser;

import by.it.academy.Md_AT1.hw4_XML.dto.Article;
import by.it.academy.Md_AT1.hw4_XML.dto.Contacts;
import by.it.academy.Md_AT1.hw4_XML.dto.Journal;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;

import static by.it.academy.Md_AT1.hw4_XML.dom.utils.DomParserUtil.parseXMLDocument;

public class DomParserDemo {
    private static final String PATH_TO_JOURNAL = "journal.xml";
    static Document document = parseXMLDocument(PATH_TO_JOURNAL);

    /**
     * Метод парсит узел <contacts></contacts>
     * @param contactsNode
     * @return объект класса Contacts
     */
    public static Contacts parseContacts(Node contactsNode) {
        contactsNode = getNodeOfContacts();
        Contacts contacts = new Contacts();
        NodeList contactsChild = contactsNode.getChildNodes();
        for (int n = 0; n < contactsChild.getLength(); n++) {
            if (contactsChild.item(n).getNodeType() == Node.ELEMENT_NODE) {
                switch (contactsChild.item(n).getNodeName()) {
                    case "address": {
                        contacts.setAddress(contactsChild.item(n).getTextContent());
                        break;
                    }
                    case "tel": {
                        contacts.setTel(contactsChild.item(n).getTextContent());
                        break;
                    }
                    case "email": {
                        contacts.setEmail(contactsChild.item(n).getTextContent());
                        break;
                    }
                    case "url": {
                        contacts.setUrl(contactsChild.item(n).getTextContent());
                        break;
                    }
                }
            }
        }
        return contacts;
    }

    /**
     * Метод парсит узел <article></article>
     * @param articleNode
     * @return объект класса Article
     */
    public static Article parseArticle(Node articleNode) {
        Article article = new Article();
        NodeList articlesChild = articleNode.getChildNodes();
        for (int n = 0; n < articlesChild.getLength(); n++) {
            if (articlesChild.item(n).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            article.setId(((Element) articlesChild).getAttribute("ID"));

            switch (articlesChild.item(n).getNodeName()) {
                case "title": {
                    article.setTitle(articlesChild.item(n).getTextContent());
                    break;
                }
                case "author": {
                    article.setAuthor(articlesChild.item(n).getTextContent());
                    break;
                }
                case "url": {
                    article.setUrl(articlesChild.item(n).getTextContent());
                    break;
                }
                case "hotkeys": {
                    NodeList nodeHotkeys = articlesChild.item(n).getChildNodes();
                    String hotkey;
                    List<String> hotkeys = new ArrayList<>();
                    for (int i = 0; i < nodeHotkeys.getLength(); i++) {
                        Node node = nodeHotkeys.item(i);
                        if (node instanceof Element) {
                            hotkey = node.getChildNodes().item(0).getNodeValue();
                            hotkeys.add(hotkey);
                        }
                    }
                    article.setHotkeys(hotkeys);
                }
            }
        }
        return article;
    }

    /**
     * Метод добавляет объекты класса Article в List
     * @param articlesNode
     * @return ArrayList объектов класса Article
     */
    public static List<Article> setArticlesInList(Node articlesNode) {

        articlesNode = getNodeOfArticles();
        List<Article> articles = new ArrayList<>();
        NodeList articleChild = articlesNode.getChildNodes();
        for (int i = 0; i < articleChild.getLength(); i++) {
            if (articleChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!articleChild.item(i).getNodeName().equals("article")) {
                continue;
            }
            Article article = parseArticle(articleChild.item(i));
            articles.add(article);
        }
        return articles;
    }

    /**
     * Метод объединяет информацию из childNode <title>, <contacts> и <articles> создавая объект класса Journal
     * @param nodeList
     * @return объект класса Journal
     */
    public static Journal setAllNodesToJournal(NodeList nodeList) {
        Journal journal = new Journal();
        for (int n = 0; n < nodeList.getLength(); n++) {
            Node node = nodeList.item(n);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                journal = new Journal();
                Element element = (Element) node;
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                journal.setTitle(title);
                journal.setContacts(parseContacts(node));
                journal.setArticle(setArticlesInList(node));
            }
        }
        return journal;
    }

    /**
     * Метод получает ноду узла <contacts>
     * @return node
     */
    public static Node getNodeOfContacts() {
        Node rootNode = document.getFirstChild();
        Node contactsNode = null;
        NodeList rootChild = rootNode.getChildNodes();
        for (int i = 0; i < rootChild.getLength(); i++) {
            if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (rootChild.item(i).getNodeName().equals("contacts")) {
                contactsNode = rootChild.item(i);
                return contactsNode;
            }
        }
        System.out.println(contactsNode.getNodeValue());
        return null;
    }

    /**
     * Метод получает ноду узла <articles>
     * @return node
     */
    public static Node getNodeOfArticles() {
        Node rootNode = document.getFirstChild();
        Node articlesNode;
        NodeList rootChild = rootNode.getChildNodes();
        for (int i = 0; i < rootChild.getLength(); i++) {
            if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (rootChild.item(i).getNodeName().equals("articles")) {
                articlesNode = rootChild.item(i);
                return articlesNode;
            }
        }
        return null;
    }
}