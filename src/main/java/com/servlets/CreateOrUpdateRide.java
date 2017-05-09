package com.servlets;

import com.entity.Ride;
import com.entity.RideRequest;
import com.entity.User;
import com.logic.DateManipulator;
import com.logic.LoginChecker;
import com.logic.PropertyManager;
import com.persistence.RideDao;
import com.persistence.RideRequestDao;
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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kien Warren on 5/8/17.
 */
@WebServlet(
        name = "CreateOrUpdateRide",
        urlPatterns = {"/createOrUpdateRide"})
public class CreateOrUpdateRide extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Get request reached.");
        HttpSession session = request.getSession();
        PropertyManager propertyManager = new PropertyManager();

        // Check if user is logged in
        if (LoginChecker.userIsLoggedIn(session)) {
            UserDao userDao = new UserDao();
            RideDao rideDao = new RideDao();
            RideRequestDao rideRequestDao = new RideRequestDao();
            User user = userDao.getUserByUsername(session.getAttribute("username").toString());
            int requestId = Integer.parseInt(request.getParameter("requestId"));
            RideRequest rideRequest = rideRequestDao.getRideRequest(requestId);
            List<Ride> existingRides = rideDao.getAllUpcomingRidesByUserId(user.getUserId());

            boolean rideExistsAtSameTime = false;

            // If there are any active rides coming up
            if (existingRides != null) {
                log.info("Rides exist. ");
                Date rideRequestDateTime;
                for (Ride ride : existingRides) {
                    rideRequestDateTime = DateManipulator.nextDateTime(rideRequest.getDropoffTime(), rideRequest.getRecurrenceDay());
                    Date rideDateTime = ride.getRequestDateTime();
                    int rideId = ride.getRideId();
                    Set<RideRequest> rideRequests = ride.getRideRequests();

                    // Check if the ride datetime and request datetime are within 30 minutes sof one another
                    if (Math.abs(rideRequestDateTime.getTime() - rideDateTime.getTime()) <= Integer.parseInt(propertyManager.getProperty("thirty_minutes_in_milliseconds"))) {
                        log.info("Found ride within timeframe. RideId = " + rideId);
                        rideExistsAtSameTime = true;
                        // Check if ride is full
                        if (ride.getNumRidersInclDriver() < userDao.getUser(ride.getUserUserId()).getMaxRidersInclDriver()) {
                            rideRequest.setRequestStatus("Accepted");
                            rideRequest.setRide(ride);
                            rideRequestDao.updateRideRequest(rideRequest);

                            log.info("Found matching ride. Adding ride request to rideId = " + rideId);

                            ride.setNumRidersInclDriver(ride.getNumRidersInclDriver() + 1);
                            rideRequests.add(rideRequest);

                            rideRequestDao.updateRideRequest(rideRequest);
                            rideDao.updateRide(ride);

                            request.setAttribute("acceptedRide", true);
                            RequestDispatcher dispatcher =
                                    getServletContext().getRequestDispatcher("myprofile");
                            dispatcher.forward(request, response);
                            return;
                        }
                        log.info("Ride was full.");
                    }
                }

                if (rideExistsAtSameTime == true) {
                    log.info("Already has a full ride at the same time as accepted ride request...going back to myprofile page.");

                    request.setAttribute("fullRide", true);
                    RequestDispatcher dispatcher =
                            getServletContext().getRequestDispatcher("myprofile");
                    dispatcher.forward(request, response);
                    return;
                }
                log.info("No matching rides found.");
            } // end check if there are any existing rides


                Ride ride = new Ride();
                Set<RideRequest> rideRequests = new HashSet<>();

                rideRequests.add(rideRequest);

                ride.setUserUserId(user.getUserId());
                ride.setNumOfRecurrences(1);
                ride.setRecurrenceDay(rideRequest.getRecurrenceDay());
                ride.setEndAddress(rideRequest.getDropoffAddress());
//                ride.setStartAddress(rideRequest.getPickupAddress());
                ride.setStartAddress(user.getHomeAddress());
                ride.setDepartTime(rideRequest.getDropoffTime());
                ride.setNumRidersInclDriver(2);
                ride.setRideRequests(rideRequests);
                ride.setRequestDateTime(DateManipulator.nextDateTime(rideRequest.getDropoffTime(), rideRequest.getRecurrenceDay()));
                rideRequest.setRide(ride);
                rideRequest.setRequestStatus("Accepted");
                rideRequestDao.updateRideRequest(rideRequest);
                rideDao.addRide(ride);

            request.setAttribute("acceptedRide", true);
            RequestDispatcher dispatcher =
//                    getServletContext().getRequestDispatcher("myprofile");
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("servlet.myprofile"));
            dispatcher.forward(request, response);
            return;

        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.login"));
//                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

    }
}
