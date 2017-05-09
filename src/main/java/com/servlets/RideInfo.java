package com.servlets;

import com.entity.Ride;
import com.entity.RideRequest;
import com.entity.User;
import com.logic.LoginChecker;
import com.logic.PropertyManager;
import com.persistence.RideDao;
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
import java.util.Set;

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
        HttpSession session = request.getSession();
        PropertyManager propertyManager = new PropertyManager();
        log.info("Reached get request.");
        userDao = new UserDao();
        User user = userDao.getUserByUsername(session.getAttribute("username").toString());

        if (LoginChecker.userIsLoggedIn(session)) {
            RideDao rideDao = new RideDao();
            int rideId = Integer.parseInt(session.getAttribute("rideId").toString());
            Ride ride = rideDao.getRide(rideId);
            Set<RideRequest> rideRequests = ride.getRideRequests();
            log.info("rideId found: " + rideId);

            String origin = "";
            String waypoints = "";
            String destination = "";

            // TODO: Start here

            request.setAttribute("apiKey", propertyManager.getProperty("google_api_key"));

            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.ride_info"));
            dispatcher.forward(request, response);
        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.login"));
            dispatcher.forward(request, response);
        }

    }
}
