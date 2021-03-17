package ictgradschool.web.servlet.v0;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "users", urlPatterns = {"/ajax/users"})
public class UsersEndpoint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/ajax/v1/users");
        dispatcher.forward(request, response);
//        int id = 0;
//        User user = null;
//        if (null != request.getParameter("id")) {
//            id = Integer.parseInt(request.getParameter("id"));
//            try {
//                user = UserDAO.getUserByUserId(id);
//                JSONResponse.send(response, user);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
