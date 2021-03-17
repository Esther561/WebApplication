package ictgradschool.web.model;

import java.util.ArrayList;
import java.util.List;

public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer author_id;
    private List<Comment> comments = new ArrayList<>();



    public Article(Integer id, String title, String content, Integer author_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
    }

    public Article(Integer id, String title, String content, Integer author_id, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
        this.comments = comments;
    }

    public Article() {
    }

//    public Article(Article article_id) {
//
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
