package filter;

import entity.User;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        HttpSession httpSession = httpServletRequest.getSession();
        String username = (String) httpSession.getAttribute("loggedUser");
        if (username != null && username.length() > 0) {
            UserModel userModel = new UserModel();
            User user = userModel.getOneByUsername(username);
            httpServletRequest.setAttribute("userLogged", user);
            if ("/admin".equalsIgnoreCase(httpServletRequest.getRequestURI())) {
                if (user.getRole() != User.Role.ADMIN.getValue()) {
                    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
