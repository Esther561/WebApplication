package ictgradschool.web.servlet.v1;

import ictgradschool.web.DAO.LikeDAO;
import ictgradschool.web.model.Like;
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

@WebServlet(name = "likes1", urlPatterns = {"/ajax/v1/likes"})
public class LikeEndpoint_v1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Like> likes = new ArrayList<Like>();
        try {
        if (null != request.getParameter("user")) {
            int id = Integer.parseInt(request.getParameter("user"));
            likes = LikeDAO.getLikeByUserId(id);
            JSONResponse.send(response, likes);
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
