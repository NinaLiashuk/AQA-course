package by.it.academy.Md_AT1.hw4_XML.dto;

import java.util.List;

public class Journal {
    private String title;
    private Contacts contacts;
    private List<Article> article;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\n' +
                ", contacts=" + contacts +
                ", articles=" + article +
                '}';
    }
}
