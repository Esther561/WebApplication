package ictgradschool.web.servlet.v2e;

import ictgradschool.web.DAO.LikeDAO;
import ictgradschool.web.DAO.UserDAO;
import ictgradschool.web.model.Article;
import ictgradschool.web.model.User;
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

@WebServlet(name = "users2e", urlPatterns = {"/ajax/v2e/users"})
public class UsersEndpoint_v2e extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        User user = null;
        List<Article> articles = new ArrayList<Article>();
        if (null != request.getParameter("id")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {
                user = UserDAO.getUserByUserId(id);
                articles = LikeDAO.getLikeTitleByLikes(id);
                user.setArticles(articles);

                JSONResponse.send(response, user);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
