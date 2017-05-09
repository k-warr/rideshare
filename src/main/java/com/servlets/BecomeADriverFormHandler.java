package com.servlets;

import com.entity.Address;
import com.entity.User;
import com.entity.Vehicle;
import com.logic.LoginChecker;
import com.logic.PropertyManager;
import com.persistence.AddressDao;
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
    private AddressDao addressDao;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropertyManager propertyManager = new PropertyManager();
        log.info("RideRequestFormHandler reached.");
        HttpSession session = request.getSession();

        if (LoginChecker.userIsLoggedIn(session)) {
            int year = -1;
            int maxOccupants = -1;

            try {
                year = Integer.parseInt(request.getParameter("year"));
                maxOccupants = Integer.parseInt(request.getParameter("maxOccupants"));
            } catch (NumberFormatException nfe) {
                log.error("NumberFormatException");
            }

            userDao = new UserDao();
            vehicleDao = new VehicleDao();
            addressDao = new AddressDao();

            User user = userDao.getUserByUsername(session.getAttribute("username").toString());
            String make = request.getParameter("make");
            String model = request.getParameter("model");
            String driversLicense = request.getParameter("driversLicense");
            String licensePlate = request.getParameter("licensePlate");
            String insuranceProvider = request.getParameter("insuranceProvider");
            String vin = request.getParameter("vin");
            String houseNumber = request.getParameter("houseNumber");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");

//            if (!vehicleOwnerDao.existsVehicleOwnerByUserId(user.getUserId())) {
            if (!userDao.isDriverByUsername(user.getUsername())) {
                Vehicle vehicle = new Vehicle(make, model, year);
                int vehicleId = vehicleDao.addVehicleIfDoesntExist(vehicle);
                Address homeAddress = new Address(houseNumber, street, city, state, zipCode);
                addressDao.addAddressIfDoesntExist(homeAddress);

                user.setHomeAddress(homeAddress);
                user.setVehicle(vehicle);
                user.setDriversLicense(driversLicense);
                user.setLicensePlate(licensePlate);
                user.setInsuranceProvider(insuranceProvider);
                user.setVin(vin);
                user.setIsDriver(1);
                if (maxOccupants > 0) {
                    user.setMaxRidersInclDriver(maxOccupants);
                }
                userDao.updateUser(user);

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
//                        getServletContext().getRequestDispatcher("/myprofile");
                        getServletContext().getRequestDispatcher(propertyManager.getProperty("servlet.myprofile"));
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("alreadyDriver", true);
                RequestDispatcher dispatcher =
//                        getServletContext().getRequestDispatcher("/myprofile");
                        getServletContext().getRequestDispatcher(propertyManager.getProperty("servlet.myprofile"));
                dispatcher.forward(request, response);
            }
        } else {
            log.info("no username found");
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
//                    getServletContext().getRequestDispatcher("/login.jsp");
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.login"));
            dispatcher.forward(request, response);
        }
    }
}
