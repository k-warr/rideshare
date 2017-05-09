package com.servlets;

import com.entity.Ride;
import com.entity.RideRequest;
import com.entity.User;
import com.logic.LoginChecker;
import com.persistence.RideDao;
import com.persistence.RideRequestDao;
import com.persistence.UserDao;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Created by Kien Warren on 3/22/17.
 */
@WebServlet(
        name = "profilePage",
        urlPatterns = {"/myprofile"}
) public class ProfilePageServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Get request reached.");
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsername(username);
        RideRequestDao rideRequestDao = new RideRequestDao();
        RideDao rideDao = new RideDao();
        List<RideRequest> rideRequests = null;
        List<RideRequest> openRideRequests = null;

        // If logged in
        if (!username.equals(null) && user != null) {

            // A list of all ride requests for current user
            rideRequests = rideRequestDao.getRideRequestByUserId(user.getUserId());
            if (rideRequests != null && rideRequests.size() > 0) {
                log.info("Ride Requests: " + rideRequests.get(0).toString());
                request.setAttribute("riderRideRequests", rideRequests);
//                rideRequests.get(0).getRide().getRideId()
            }

            // If the user has a vehicle (i.e. signed up as driver)
            if (userDao.isDriverByUsername(username)) {
                request.setAttribute("isDriver", true); // enables certain content to be visible on page
                log.info("Driver confirmed. Retrieving rides and open ride requests");

                // Get open ride requests
                openRideRequests = rideRequestDao.getAllOpenRequestsExcludeUser(user.getUserId());
                request.setAttribute("openRideRequests", openRideRequests);

                // Get user's rides
                List<Ride> rides = rideDao.getAllUpcomingRidesByUserId(user.getUserId());
                request.setAttribute("rides", rides);
            }
        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/myProfile.jsp");
        dispatcher.forward(request, response);
    }


}
