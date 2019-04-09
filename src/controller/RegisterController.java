package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");

        User user = new User(username, password, fullname);
        if (!user.isValid()) {
            req.setAttribute("errors", user.getErrors());
            req.setAttribute("user", user);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        UserModel userModel = new UserModel();
        boolean result = userModel.insert(user);
        if (result) {

        } else {

        }
    }
}
