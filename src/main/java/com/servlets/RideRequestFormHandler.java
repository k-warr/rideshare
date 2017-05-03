package com.servlets;

import com.entity.Address;
import com.entity.RideRequest;
import com.entity.User;
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

/**
 * Created by Kien Warren on 5/2/17.
 */
@WebServlet(
        name = "RideRequestFormHandler",
        urlPatterns= {"/rideRequestFormHandler"})
public class RideRequestFormHandler extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        ServletContext context = getServletContext();

        String username = request.getParameter("username");
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

        originAddress.setAddressNumber(addressNumberOrigin);
        originAddress.setStreetName(streetOrigin);
        originAddress.setCity(cityOrigin);
        originAddress.setState(stateOrigin);
        originAddress.setZipCode(zipCodeOrigin);
        addressDao.addAddressIfDoesntExist(originAddress);

        destinationAddress.setAddressNumber(addressNumberDestination);
        destinationAddress.setStreetName(streetDestination);
        destinationAddress.setCity(cityDestination);
        destinationAddress.setState(stateDestination);
        destinationAddress.setZipCode(zipCodeDestination);
        addressDao.addAddressIfDoesntExist(destinationAddress);

        rideRequest.setPickupAddressId(originAddress.getAddressId());
        rideRequest.setDropoffAddressId(destinationAddress.getAddressId());
        rideRequest.setDropoffTime(dropoffTime);
        rideRequest.setRecurrenceDay(recurrenceDay);
        rideRequest.setUserId(requestor.getUserId());
        rideRequestDao.addRideRequest(rideRequest);

        String url = "/test.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
//        }
    }
}
