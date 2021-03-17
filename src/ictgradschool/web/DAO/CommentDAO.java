package ictgradschool.web.DAO;

import ictgradschool.web.model.Comment;
import ictgradschool.web.util.DBConnectionUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    public static List<Comment>  getCommentByArticleId(int id) throws IOException, SQLException {
        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "select id,content,time, user_id, article_id from comments where article_id = ? order by time asc ")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    List<Comment> comments = new ArrayList<>();
                    while (rs.next()) {
                        int this_id = rs.getInt("id");
                        comments.add(new Comment(
                                this_id,
                                rs.getString("content"),
                                rs.getTimestamp("time"),
                                rs.getInt("user_id"),
                                rs.getInt("article_id"),
                                UserDAO.getUserByUserId(rs.getInt("user_id"))
                                ));
                    }
                    return comments;

                }


            }


        }


    }


}
