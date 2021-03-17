package ictgradschool.web.servlet.v1;

import ictgradschool.web.DAO.UserDAO;
import ictgradschool.web.model.User;
import ictgradschool.web.util.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "users1", urlPatterns = {"/ajax/v1/users"})
public class UsersEndpoint_v1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        User user = null;
        if (null != request.getParameter("id")) {
            id = Integer.parseInt(request.getParameter("id"));
            try {
                user = UserDAO.getUserByUserId(id);
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
