package ictgradschool.web.model;

public class Like {
    private Integer article_id;
    private Integer user_id;

    public Like(Integer article_id, Integer user_id) {
        this.article_id = article_id;
        this.user_id = user_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
