package com.servlets;

import com.entity.RideRequest;
import com.entity.User;
import com.logic.LoginChecker;
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

// TODO: How to force redirect to login.jsp when this servlet is targeted and user is not logged in?
// Maybe I have to add the servlet path to the web.xml

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
//        VehicleOwnerDao vehicleOwnerDao = new VehicleOwnerDao();
        List<RideRequest> rideRequests = null;
        List<RideRequest> openRideRequests = null;

        if (!username.equals(null) && user != null) {

            // a list of all ride requests for current user
            rideRequests = rideRequestDao.getRideRequestByUserId(user.getUserId());
            if (rideRequests != null && rideRequests.size() > 0) {
                log.info("Ride Requests: " + rideRequests.get(0).toString());
                request.setAttribute("riderRideRequests", rideRequests);
            }


            // TODO: if driver, get a list of all open ride requests
            // If the user has a vehicle (i.e. signed up as driver)
//                if (vehicleOwnerDao.existsVehicleOwnerByUserId(user.getUserId())) {
            if (userDao.isDriverByUsername(username)) {
                request.setAttribute("isDriver", true); // enables certain content to be visible on page
                log.info("Driver confirmed. Retrieving openRideRequests");
                openRideRequests = rideRequestDao.getAllOpenRequestsExcludeUser(user.getUserId());
                request.setAttribute("openRideRequests", openRideRequests);
            }
            // TODO: if driver, show all rides
                // TODO: link to a page that shows directions to a location
            if (userDao.isDriverByUsername(username)) {
            }
        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

        String url = "/myProfile.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}
