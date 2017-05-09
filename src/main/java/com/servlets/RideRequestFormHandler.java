package com.servlets;

import com.entity.Address;
import com.entity.RideRequest;
import com.entity.User;
import com.logic.LoginChecker;
import com.logic.PropertyManager;
import com.persistence.AddressDao;
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

/**
 * Created by Kien Warren on 5/2/17.
 */
@WebServlet(
        name = "RideRequestFormHandler",
        urlPatterns= {"/rideRequestFormHandler"})
public class RideRequestFormHandler extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("RideRequestFormHandler get request reached.");
        HttpSession session = request.getSession();
        PropertyManager propertyManager = new PropertyManager();
        UserDao userDao = new UserDao();

        if (LoginChecker.userIsLoggedIn(session)) {
            String username = session.getAttribute("username").toString();
            User user = userDao.getUserByUsername(username);

            String addressNumberOrigin = request.getParameter("numberOrigin");
            String streetOrigin = request.getParameter("streetOrigin");
            String cityOrigin = request.getParameter("cityOrigin");
            String stateOrigin = request.getParameter("stateOrigin");
            String zipCodeOrigin = request.getParameter("zipCodeOrigin");
            String addressNumberDestination = request.getParameter("numberDestination");
            String streetDestination = request.getParameter("streetDestination");
            String cityDestination = request.getParameter("cityDestination");
            String stateDestination = request.getParameter("stateDestination");
            String zipCodeDestination = request.getParameter("zipCodeDestination");
            int dropoffTime = Integer.parseInt(request.getParameter("dropoffTime"));
            String recurrenceDay = request.getParameter("recurrenceDay");

            User requestor = new UserDao().getUserByUsername(username);
            Address originAddress = new Address();
            Address destinationAddress= new Address();
            AddressDao addressDao = new AddressDao();
            RideRequest rideRequest = new RideRequest();
            RideRequestDao rideRequestDao = new RideRequestDao();
            int originAddressId;
            int destinationAddressId;

            originAddress.setAddressNumber(addressNumberOrigin);
            originAddress.setStreetName(streetOrigin);
            originAddress.setCity(cityOrigin);
            originAddress.setState(stateOrigin);
            originAddress.setZipCode(zipCodeOrigin);
            originAddress.setFullAddress(addressNumberOrigin + " " + streetOrigin + " " + cityOrigin + ", "
                    + stateOrigin + " " + zipCodeOrigin);
            originAddressId = addressDao.addAddressIfDoesntExist(originAddress);

            destinationAddress.setAddressNumber(addressNumberDestination);
            destinationAddress.setStreetName(streetDestination);
            destinationAddress.setCity(cityDestination);
            destinationAddress.setState(stateDestination);
            destinationAddress.setZipCode(zipCodeDestination);
            destinationAddress.setFullAddress(addressNumberDestination + " " + streetDestination + " " + cityDestination + ", "
                    + stateDestination + " " + zipCodeDestination);
            destinationAddressId = addressDao.addAddressIfDoesntExist(destinationAddress);

            rideRequest.setDropoffTime(dropoffTime);
            rideRequest.setPickupAddress(addressDao.getAddress(originAddressId));
            rideRequest.setDropoffAddress(addressDao.getAddress(destinationAddressId));
            rideRequest.setRecurrenceDay(recurrenceDay);
            rideRequest.setUser(requestor);
            rideRequest.setRequestStatus("Active");
            rideRequest.setRequestTime(new Date());
            rideRequestDao.addRideRequest(rideRequest);

            request.setAttribute("successfulRideRequestSubmission", true);

            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("servlet.myprofile"));
            dispatcher.forward(request, response);
        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.login"));
//                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
