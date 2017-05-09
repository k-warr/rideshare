package com.servlets;

import com.entity.User;
import com.logic.LoginChecker;
import com.logic.PropertyManager;
import com.persistence.SessionFactoryProvider;
import com.persistence.UserDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kien Warren on 5/7/17.
 */
@WebServlet(
        name = "admin",
        urlPatterns={"/adminPage"})
public class Admin extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PropertyManager propertyManager = new PropertyManager();
        String username = " ";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Check if user is admin
        if (username.equals("admin")) {
            UserDao userDao = new UserDao();
            if (request.getParameter("fromAdmin") != null && request.getParameter("fromAdmin").equals("yes")) {
                if (request.getParameter("userId") != null) {
                    int userId = Integer.parseInt(request.getParameter("userId"));
                    userDao.deleteUser(userId);
                }
            }
            List<User> users = userDao.getAllUsers();
            request.setAttribute("users", users);

            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("notAdmin", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("servlet.no_context.myprofile"));
            dispatcher.forward(request, response);
        }
    }
}
