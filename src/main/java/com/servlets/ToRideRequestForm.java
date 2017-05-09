package com.servlets;

import com.logic.LoginChecker;
import com.logic.PropertyManager;
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
 * Created by Kien Warren on 5/4/17.
 */
@WebServlet(
        name = "ToRideRequestForm",
        urlPatterns = {"/toRideRequestForm"})
public class ToRideRequestForm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PropertyManager propertyManager = new PropertyManager();

        if (LoginChecker.userIsLoggedIn(session)) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.ride_request_form"));
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.login"));
            dispatcher.forward(request, response);
        }
    }
}