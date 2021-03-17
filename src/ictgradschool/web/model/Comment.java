package ictgradschool.web.model;


import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
    private Integer id;
    private String content;
    private Timestamp time;
    private Integer user_id;
    private Integer article_id;
    private User user;

    public Comment(Integer id, String content, Timestamp time, Integer user_id, Integer article_id) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.user_id = user_id;
        this.article_id = article_id;
    }

    public Comment(Integer id, String content, Timestamp time, Integer user_id, Integer article_id, User user) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.user_id = user_id;
        this.article_id = article_id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
