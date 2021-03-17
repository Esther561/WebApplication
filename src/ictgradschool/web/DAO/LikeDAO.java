package ictgradschool.web.DAO;

import ictgradschool.web.model.Article;
import ictgradschool.web.model.Like;
import ictgradschool.web.util.DBConnectionUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDAO {
    public static List<Like> getLikeByUserId(int id) throws IOException, SQLException {
        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
            List<Like> likes = new ArrayList<Like>();

            try (PreparedStatement ps = conn.prepareStatement(
                    "select article_id,user_id" +
                            " from likes " +
                            "where user_id = ? ")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        likes.add(new Like(
                                rs.getInt("article_id"),
                                rs.getInt("user_id")

                        )  );
                    }
                    }

                }
            return likes;

        }
        }

//    public static List<String> getTitlesByUserId(int id) throws IOException, SQLException {
//        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
//            int[] likes = null;
//            int i=0;
//
//            try (PreparedStatement ps = conn.prepareStatement(
//                    "select article_id" +
//                            " from likes " +
//                            "where user_id = ? ")) {
//                ps.setInt(1, id);
//                try (ResultSet rs = ps.executeQuery()) {
//                    while (rs.next()) {
//                        assert false;
//                        likes[i]= rs.getInt("article_id");
//                            i++;
//
//                    }
//                }
//
//            }
//            assert false;
//            return getLikeTitleByLikes(likes);
//        }
//    }
    public static List<Article> getLikeTitleByLikes(int id) throws IOException, SQLException {
        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
                try (PreparedStatement ps = conn.prepareStatement(
                        "select article_id" +
                                " from likes " +
                                "where user_id = ? ")) {
                    ps.setInt(1, id);
                    try (ResultSet rs = ps.executeQuery()) {
                        List<Article> articles = new ArrayList<Article>();
                        while (rs.next()) {
                            articles.add(
                                  ArticleDAO.getArticleByArticleId(rs.getInt("article_id"))
                            );
                        }
                        return articles;

                    }


                }

            }

        }
    }






