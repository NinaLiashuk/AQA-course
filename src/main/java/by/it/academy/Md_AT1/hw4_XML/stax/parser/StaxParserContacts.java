package by.it.academy.Md_AT1.hw4_XML.stax.parser;

import by.it.academy.Md_AT1.hw4_XML.dto.Contacts;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import static by.it.academy.Md_AT1.hw4_XML.stax.utils.StaxParserUtil.getReader;

public class StaxParserContacts {
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_TEL = "tel";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_URL = "url";

    public static Contacts staxParseContacts() throws XMLStreamException {

        Contacts currCon = null;
        String tagContent = null;

        String node = null;
        String parentNode = null;
        XMLStreamReader reader = getReader();
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {

                case XMLStreamConstants.START_ELEMENT:
                    node = reader.getLocalName();
                    if (node.equals(TAG_CONTACTS)) {
                        parentNode = "contacts";
                    }
                    if (TAG_CONTACTS.equals(reader.getLocalName())) {
                        currCon = new Contacts();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    if (node.equals(TAG_CONTACTS)) {
                        parentNode = null;
                    }
                    switch (reader.getLocalName()) {
                        case TAG_CONTACTS:
                            return currCon;
                        case TAG_ADDRESS:
                            currCon.setAddress(tagContent);
                            break;
                        case TAG_TEL:
                            currCon.setTel(tagContent);
                            break;
                        case TAG_EMAIL:
                            currCon.setEmail(tagContent);
                            break;
                        case TAG_URL:
                            if (parentNode != null) {
                                currCon.setUrl(tagContent);
                            }
                            break;
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    currCon = new Contacts();
                    break;
            }
        }
        return currCon;
    }
}
