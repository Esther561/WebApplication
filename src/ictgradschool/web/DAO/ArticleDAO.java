package ictgradschool.web.DAO;

import ictgradschool.web.model.Article;
import ictgradschool.web.util.DBConnectionUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

    public static Article getArticleByArticleId(int id) throws IOException, SQLException {
        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "select id,title,content,author_id" +
                            " from articles " +
                            "where id = ? ")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Article(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("content"),
                                rs.getInt("author_id")
                        );
                    }else{
                        return null;
                    }

                }
            }
        }
    }

    public static List<Article> getArticleAll() throws IOException, SQLException {
        List<Article> articles = new ArrayList<Article>();
        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "select id,title,content,author_id" +
                            " from articles")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        articles.add(new Article(
                                rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("content"),
                                rs.getInt("author_id")
                        ));
                    }
                }
            }
        }
        return articles;
    }

    public static List<Article> getAnotherArticle(int from, int count) throws IOException, SQLException {
        List<Article> articles = new ArrayList<Article>();
        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "select id,title,content,author_id"+
                            " from articles limit  ? offset ?"
            )) {
                ps.setInt(1, count);
                ps.setInt(2, from);


                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String content = rs.getString("content");
                        String contentSummary = content.length() > 80 ? content.substring(0,75) + "..." : content;
                        articles.add(new Article(
                                rs.getInt("id"),
                                rs.getString("title"),
                                contentSummary,
                                rs.getInt("author_id")
                        ));
                    }
                }
            }
        }
        return articles;
    }


}
