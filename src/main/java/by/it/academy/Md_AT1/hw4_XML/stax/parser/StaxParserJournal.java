package by.it.academy.Md_AT1.hw4_XML.stax.parser;

import by.it.academy.Md_AT1.hw4_XML.dto.Journal;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import static by.it.academy.Md_AT1.hw4_XML.stax.parser.StaxParserArticles.staxParseArticles;
import static by.it.academy.Md_AT1.hw4_XML.stax.parser.StaxParserContacts.staxParseContacts;
import static by.it.academy.Md_AT1.hw4_XML.stax.utils.StaxParserUtil.getReader;

public class StaxParserJournal {
    private static final String TAG_JOURNAL = "journal";
    private static final String TAG_TITLE = "title";
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_ARTICLES = "articles";

    public static Journal staxParseJournal() throws XMLStreamException {

        Journal currJon = null;
        String tagContent = null;

        String node = null;
        String parentNode = null;
        XMLStreamReader reader = getReader();
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {

                case XMLStreamConstants.START_ELEMENT:
                    node = reader.getLocalName();
                    if (node.equals(TAG_JOURNAL)) {
                        parentNode = "journal";
                    }
                    if (TAG_JOURNAL.equals(reader.getLocalName())) {
                        currJon = new Journal();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case TAG_JOURNAL:
                            return currJon;
                        case TAG_TITLE:
                            if (parentNode != null) {
                                currJon.setTitle(tagContent);
                                parentNode = null;
                            }
                            break;
                        case TAG_CONTACTS:
                            currJon.setContacts(staxParseContacts());
                            break;
                        case TAG_ARTICLES:
                            currJon.setArticle(staxParseArticles());
                            break;
                    }
                    break;


                case XMLStreamConstants.START_DOCUMENT:
                    currJon = new Journal();
                    break;
            }
        }
        return currJon;
    }
}

