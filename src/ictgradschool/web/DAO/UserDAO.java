package ictgradschool.web.DAO;

import ictgradschool.web.model.User;
import ictgradschool.web.util.DBConnectionUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static User getUserByUserId(int id) throws IOException, SQLException {
        try (Connection conn = DBConnectionUtils.getConnectionFromClasspath("connection.properties")) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "select id,fname,lname,gender" +
                        " from users " +
                            "where id = ? ")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new User(
                                rs.getInt("id"),
                                rs.getString("fname"),
                                rs.getString("lname"),
                                rs.getString("gender")
                                );
                    }else{
                        return null;
                    }

                }
            }
        }
    }

}
