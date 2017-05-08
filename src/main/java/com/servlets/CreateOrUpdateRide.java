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

        if (LoginChecker.userIsLoggedIn(session)) {
            UserDao userDao = new UserDao();
            RideDao rideDao = new RideDao();
            RideRequestDao rideRequestDao = new RideRequestDao();
            User user = userDao.getUserByUsername(session.getAttribute("username").toString());
//            int requestId = Integer.parseInt(session.getAttribute("requestId").toString());
            int requestId = Integer.parseInt(request.getParameter("requestId"));
            RideRequest rideRequest = rideRequestDao.getRideRequest(requestId);
            List<Ride> existingRides = rideDao.getAllUpcomingRidesByUserId(user.getUserId());
            rideRequest.setRequestStatus("Accepted");
            rideRequestDao.updateRideRequest(rideRequest);

            if (existingRides != null) {
                
            } else {
                Ride ride = new Ride();
                Set<RideRequest> rideRequests = new HashSet<>();

                rideRequests.add(rideRequest);
                ride.setUserUserId(user.getUserId());
                ride.setNumOfRecurrences(1);
                ride.setRecurrenceDay(rideRequest.getRecurrenceDay());
                ride.setEndAddress(rideRequest.getDropoffAddress());
                ride.setStartAddress(rideRequest.getPickupAddress());
                ride.setDepartTime(rideRequest.getDropoffTime() - 30);
                ride.setNumRidersInclDriver(2);
                ride.setRideRequests(rideRequests);
                ride.setRequestDateTime(DateManipulator.nextDateTime(rideRequest.getDropoffTime() - 30, rideRequest.getRecurrenceDay()));
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
