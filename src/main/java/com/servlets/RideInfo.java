package com.servlets;

import com.entity.User;
import com.logic.LoginChecker;
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
 * Created by Kien Warren on 5/8/17.
 */
@WebServlet(
        name = "RideInfo",
        urlPatterns = {"/rideInfo"})
public class RideInfo extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private UserDao userDao;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao = new UserDao();
        HttpSession session = request.getSession();
        User user = userDao.getUserByUsername(session.getAttribute("username").toString());


        if (LoginChecker.userIsLoggedIn(session)) {
            PropertyManager properties = new PropertyManager();

            request.setAttribute("apiKey", properties.getProperty("google_api_key"));
//            request.setAttribute("originAddress", );

            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/rideInfo.jsp");
            dispatcher.forward(request, response);
        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

    }
}
