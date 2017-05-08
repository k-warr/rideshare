package com.servlets;

import com.entity.User;
import com.entity.Vehicle;
import com.logic.LoginChecker;
import com.persistence.SessionFactoryProvider;
import com.persistence.UserDao;
import com.persistence.VehicleDao;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 5/6/17.
 */
@WebServlet(
        name = "BecomeADriverFormHandler",
        urlPatterns= {"/becomeADriverFormHandler"})
public class BecomeADriverFormHandler extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private UserDao userDao;
    private VehicleDao vehicleDao;
//    private VehicleOwnerDao vehicleOwnerDao;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("RideRequestFormHandler reached.");
        HttpSession session = request.getSession();
        log.info("User logged in? (LoginChecker.userIsLoggedIn) " + LoginChecker.userIsLoggedIn(session));
        if (LoginChecker.userIsLoggedIn(session)) {
            int year = -1;
            int maxOccupants = -1;
            int vin = -1;

            try {
                year = Integer.parseInt(request.getParameter("year"));
                maxOccupants = Integer.parseInt(request.getParameter("maxOccupants"));
                vin = Integer.parseInt(request.getParameter("vin"));
            } catch (NumberFormatException nfe) {
                log.error("NumberFormatException");
            }

            userDao = new UserDao();
//            vehicleOwnerDao = new VehicleOwnerDao();
            vehicleDao = new VehicleDao();
            User user = userDao.getUserByUsername(session.getAttribute("username").toString());
            String make = request.getParameter("make");
            String model = request.getParameter("model");


            String driversLicense = request.getParameter("driversLicense");
            String licensePlate = request.getParameter("licensePlate");
            String insuranceProvider = request.getParameter("insuranceProvider");

//            if (!vehicleOwnerDao.existsVehicleOwnerByUserId(user.getUserId())) {
            if (true) {
                Vehicle vehicle = new Vehicle(make, model, year);
                int vehicleId = vehicleDao.addVehicleIfDoesntExist(vehicle);

//                VehicleOwner vehicleOwner = new VehicleOwner();
//                vehicleOwner.setVehicle(vehicle);
//                vehicleOwner.setUser(user);
//                vehicleOwner.setVin(vin);
//                vehicleOwner.setDriversLicense(driversLicense);
//                vehicleOwner.setLicensePlate(licensePlate);
//                vehicleOwner.setMaxRidersInclDriver(maxOccupants);
//                vehicleOwner.setInsuranceProvider(insuranceProvider);
//
//                user.setVehicleOwner(vehicleOwner);
////                userDao.updateUser(user);
//                Set<VehicleOwner> set = new HashSet<VehicleOwner>();
//                set.add(vehicleOwner);
//                vehicle.setVehicleOwners(set);
//                vehicleDao.addVehicleIfDoesntExist(vehicle);
//                vehicleOwnerDao.addVehicleOwner(vehicleOwner);

                request.setAttribute("becomeADriverSignupSuccess", true);
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher("/myprofile");
                dispatcher.forward(request, response);
            } else {
                // TODO: redirect to user already exists

            }
        } else {
            log.info("no username found");
            response.sendRedirect("/noLoginFound.jsp");
        }

    }
}
