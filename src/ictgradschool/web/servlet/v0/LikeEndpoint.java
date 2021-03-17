package ictgradschool.web.servlet.v0;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "likes0", urlPatterns = {"/ajax/likes"})
public class LikeEndpoint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/ajax/v1/likes");
        dispatcher.forward(request, response);
//        List<Like> likes = new ArrayList<Like>();
//        try {
//        if (null != request.getParameter("user")) {
//            int id = Integer.parseInt(request.getParameter("user"));
//            likes = LikeDAO.getLikeByUserId(id);
//            JSONResponse.send(response, likes);
//        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
