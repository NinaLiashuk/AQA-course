package by.it.academy.Md_AT1.hw4_XML.service;

import by.it.academy.Md_AT1.hw4_XML.dto.Article;

import java.util.ArrayList;
import java.util.List;

public class CreateArticleID1 {

    public static Article createArticleId1(){
        Article article = new Article();
        article.setId("1");
        article.setTitle("Issue overview");
        article.setAuthor("Jhon");
        article.setUrl("/article1");

        List<String> hotkeys = new ArrayList<>();
        hotkeys.add("language");
        hotkeys.add("marckup");
        hotkeys.add("hypertext");

        article.setHotkeys(hotkeys);
        return article;
    }
}
