package com.servlets;

import com.entity.Ride;
import com.entity.RideRequest;
import com.entity.User;
import com.logic.DateManipulator;
import com.logic.LoginChecker;
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
    public static final int REQUEST_DATETIME_DIFF_MINUTES = 30;
    public static final int LEEWAY_TIME_MINUTES = 30;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Get request reached.");
        HttpSession session = request.getSession();

        if (LoginChecker.userIsLoggedIn(session)) {
            UserDao userDao = new UserDao();
            RideDao rideDao = new RideDao();
            RideRequestDao rideRequestDao = new RideRequestDao();
            User user = userDao.getUserByUsername(session.getAttribute("username").toString());
            int requestId = Integer.parseInt(request.getParameter("requestId"));
            RideRequest rideRequest = rideRequestDao.getRideRequest(requestId);
            List<Ride> existingRides = rideDao.getAllUpcomingRidesByUserId(user.getUserId());
            rideRequest.setRequestStatus("Accepted");
            rideRequestDao.updateRideRequest(rideRequest);

            if (existingRides != null) {
                for (Ride ride : existingRides) {
                    Date rideDateTime = DateManipulator.nextDateTime(rideRequest.getDropoffTime(), rideRequest.getRecurrenceDay());

                    if (true) {

                    }
                    ride.setRequestDateTime(DateManipulator.nextDateTime(rideRequest.getDropoffTime(), rideRequest.getRecurrenceDay()));
                }
            } else {
                Ride ride = new Ride();
                Set<RideRequest> rideRequests = new HashSet<>();

                rideRequests.add(rideRequest);
                ride.setUserUserId(user.getUserId());
                ride.setNumOfRecurrences(1);
                ride.setRecurrenceDay(rideRequest.getRecurrenceDay());
                ride.setEndAddress(rideRequest.getDropoffAddress());
                ride.setStartAddress(rideRequest.getPickupAddress());
                ride.setDepartTime(rideRequest.getDropoffTime());
                ride.setNumRidersInclDriver(2);
                ride.setRideRequests(rideRequests);
                ride.setRequestDateTime(DateManipulator.nextDateTime(rideRequest.getDropoffTime(), rideRequest.getRecurrenceDay()));
                rideDao.addRide(ride);

            }
            request.setAttribute("acceptedRide", true);

            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/myprofile");
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
