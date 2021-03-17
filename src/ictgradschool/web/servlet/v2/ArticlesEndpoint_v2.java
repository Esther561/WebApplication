package ictgradschool.web.servlet.v2;

import ictgradschool.web.DAO.ArticleDAO;
import ictgradschool.web.model.Article;
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

@WebServlet(name = "articles2", urlPatterns = {"/ajax/v2/articles"})
public class ArticlesEndpoint_v2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        int from = 0;
        int count = 0;
        Article article = null;
        List<Article> articles = new ArrayList<Article>();
        try {
            if (null != request.getParameter("id")) {
                id = Integer.parseInt(request.getParameter("id"));
                article= ArticleDAO.getArticleByArticleId(id);
                JSONResponse.send(response, article);
            } else if (null != request.getParameter("from") && null != request.getParameter("count")) {
                from = Integer.parseInt(request.getParameter("from"));
                count = Integer.parseInt(request.getParameter("count"));
                articles = ArticleDAO.getAnotherArticle(from, count);
                JSONResponse.send(response, articles);
            } else {
                articles = ArticleDAO.getArticleAll();
                JSONResponse.send(response, articles);
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
