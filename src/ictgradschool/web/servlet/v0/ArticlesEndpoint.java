package ictgradschool.web.servlet.v0;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "articles0", urlPatterns = {"/ajax/articles"})
public class ArticlesEndpoint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/ajax/v1/articles").forward(request, response);
//        int id = 0;
//        int from = 0;
//        int count = 0;
//        Article article = null;
//        List<Article> articles = new ArrayList<Article>();
//        try {
//            if (null != request.getParameter("id")) {
//                id = Integer.parseInt(request.getParameter("id"));
//                article=ArticleDAO.getArticleByArticleId(id);
//                JSONResponse.send(response, article);
//            } else if (null != request.getParameter("from") && null != request.getParameter("count")) {
//                from = Integer.parseInt(request.getParameter("from"));
//                count = Integer.parseInt(request.getParameter("count"));
//                articles = ArticleDAO.getAnotherArticle(from, count);
//                JSONResponse.send(response, articles);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
