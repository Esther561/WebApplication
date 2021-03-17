package ictgradschool.web.servlet.v2;

import ictgradschool.web.DAO.CommentDAO;
import ictgradschool.web.model.Comment;
import ictgradschool.web.util.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "comments2", urlPatterns = {"/ajax/v2/comments"})
public class CommentsEndpoint_v2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> comments = new ArrayList<Comment>();
        try {
            if (null != request.getParameter("id")) {
                int id = Integer.parseInt(request.getParameter("id"));
                comments = CommentDAO.getCommentByArticleId(id);
                JSONResponse.send(response, comments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
