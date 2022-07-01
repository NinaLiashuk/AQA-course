package by.it.academy.Md_AT1.hw4_XML.stax.parser;

import by.it.academy.Md_AT1.hw4_XML.dto.Article;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static by.it.academy.Md_AT1.hw4_XML.stax.utils.StaxParserUtil.getReader;

public class StaxParserArticles {

    /**
     * Метод парсит узел <articles> : создает экземпляры класса Article и добавляет их в List
     * @return ArrayList объектов класса Article
     * @throws XMLStreamException
     */
    public static List<Article> staxParseArticles() throws XMLStreamException {
        List<Article> articleList = null;
        List<String> hotkeyList = null;
        String hotkey = null;
        Article currArticle = null;
        String tagContent = null;

        String noda = null;
        String parentNoda = null;

        XMLStreamReader reader = getReader();

        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {

                case XMLStreamConstants.START_ELEMENT:
                    noda = reader.getLocalName();
                    if (noda.equals("article")) {
                        parentNoda = "ar";
                    }
                    if ("article".equals(reader.getLocalName())) {
                        currArticle = new Article();
                        currArticle.setId(reader.getAttributeValue(0));
                    }
                    if ("articles".equals(reader.getLocalName())) {
                        articleList = new ArrayList<>();
                    }
                    if ("hotkeys".equals(reader.getLocalName())) {
                        hotkeyList = new ArrayList<>();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    if (noda.equals("article")) {
                        parentNoda = null;
                    }
                    switch (reader.getLocalName()) {
                        case "article":
                            articleList.add(currArticle);
                            break;
                        case "title":
                            if (parentNoda != null) {
                                currArticle.setTitle(tagContent);
                            }
                            break;
                        case "author":
                            currArticle.setAuthor(tagContent);
                            break;
                        case "url":
                            if (parentNoda != null) {
                                currArticle.setUrl(tagContent);
                            }
                            break;
                        case "hotkey":
                            hotkey = tagContent;
                            hotkeyList.add(hotkey);
                            break;
                        case "hotkeys":
                            currArticle.setHotkeys(hotkeyList);
                            break;
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    articleList = new ArrayList<>();
                    break;
            }
        }
        return articleList;
    }
}
