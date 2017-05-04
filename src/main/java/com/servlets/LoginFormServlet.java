package com.servlets;

import com.entity.User;
import com.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by student on 5/3/17.
 */
@WebServlet(
        name = "LoginFormServlet",
        urlPatterns = {"/loginFormServlet"})
public class LoginFormServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private UserDao userDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao = new UserDao();
        HttpSession session = request.getSession();

        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        User user = userDao.getUserByUsername(username);

        log.info("LoginFormServlet reached. Username = " + username);

        if (user != null) {
            session.setAttribute("username", username);
//            String url = "j_security_check?j_username=" + username + "&j_password=" + password;
            String url = "/myProfile.jsp";
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/index.jsp");
        }
    }
}
