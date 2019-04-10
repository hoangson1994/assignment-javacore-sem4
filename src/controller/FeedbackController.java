package controller;

import entity.Feedback;
import entity.User;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FeedbackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/feedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        User user = (User) req.getAttribute("userLogged");
        Feedback feedback = new Feedback(title, content, user.getId());
        if (!feedback.isValid()) {
            req.setAttribute("errors", feedback.getErrors());
            req.setAttribute("feedback", feedback);
            req.getRequestDispatcher("/feedback.jsp").forward(req, resp);
            return;
        }
        FeedbackModel feedbackModel = new FeedbackModel();
        boolean result = feedbackModel.insert(feedback);

        if (result) {
            req.setAttribute("submit-success", true);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }
}
