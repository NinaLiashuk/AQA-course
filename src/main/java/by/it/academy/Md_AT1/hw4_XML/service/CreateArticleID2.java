package by.it.academy.Md_AT1.hw4_XML.service;

import by.it.academy.Md_AT1.hw4_XML.dto.Article;

import java.util.ArrayList;
import java.util.List;

public class CreateArticleID2 {

    public static Article createArticleId2(){
        Article article = new Article();
        article.setId("2");
        article.setTitle("Latest reviews");
        article.setAuthor("Mike");
        article.setUrl("/article2");

        List<String> hotkeys = new ArrayList<>();
        hotkeys.add("marckup");
        hotkeys.add("hypertext");

        article.setHotkeys(hotkeys);
        return article;
    }
}
