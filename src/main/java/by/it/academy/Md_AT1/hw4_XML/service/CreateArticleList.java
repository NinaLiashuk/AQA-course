package by.it.academy.Md_AT1.hw4_XML.service;

import by.it.academy.Md_AT1.hw4_XML.dto.Article;

import java.util.ArrayList;
import java.util.List;

import static by.it.academy.Md_AT1.hw4_XML.service.CreateArticleID1.createArticleId1;
import static by.it.academy.Md_AT1.hw4_XML.service.CreateArticleID2.createArticleId2;

public class CreateArticleList {

    public static List<Article> createArticleList(){
        List<Article> articleList = new ArrayList<>();
        articleList.add(createArticleId1());
        articleList.add(createArticleId2());
        return articleList;
    }
}
