package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("username", username);
        userMap.put("password", password);
        if (username == null || username.length() == 0 || password == null || password.length() == 0) {
            req.setAttribute("error", "Username and Password is required");
            req.setAttribute("user", userMap);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        UserModel userModel = new UserModel();
        User user =  userModel.getOneByUsernameAndPassword(username, password);

        if (user == null) {
            req.setAttribute("error", "Username or Password incorrect");
            req.setAttribute("user", "userMap");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("loggedUser", user.getUsername());
        resp.sendRedirect("/home");
    }
}
