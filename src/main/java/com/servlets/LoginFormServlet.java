package com.servlets;

import com.entity.User;
import com.logic.PropertyManager;
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
 * Created by Kien Warren on 5/3/17.
 */
@WebServlet(
        name = "LoginFormServlet",
        urlPatterns = {"/loginFormServlet"})
public class LoginFormServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private UserDao userDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PropertyManager propertyManager = new PropertyManager();
        userDao = new UserDao();

        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        User user = userDao.getUserByUsername(username);
        log.info("Form Username: " + username + " Form password: " + password);

        // Check if user exists and password is not null
        if (user != null && !password.equals(null) && !password.equals(' ')) {
            log.info("LoginFormServlet reached. Username = " + username + " User.getUsername: " + user.getUsername());
            // Check if password matches
            if (user.getPassword().equals(password)) {
                if (userDao.isDriverByUsername(username)) {
                    session.setAttribute("isDriverSession", true);
                }
                session.setAttribute("username", username);
                response.sendRedirect(propertyManager.getProperty("servlet.no_context.myprofile"));
            } else {
                session.invalidate();
                response.sendRedirect(propertyManager.getProperty("jsp.failed_login"));
                return;
            }
        } else {
            session.invalidate();
            response.sendRedirect(propertyManager.getProperty("jsp.failed_login"));
            return;
        }
    }
}
