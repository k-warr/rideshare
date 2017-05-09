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
 * Created by Kien Warren on 5/7/17.
 */
@WebServlet(
        name = "ToSignupForm",
        urlPatterns={"/toSignupForm"})
public class ToSignupForm extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PropertyManager propertyManager = new PropertyManager();

        if (LoginChecker.userIsLoggedIn(session)) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("servlet.no_context.myprofile"));
//                    getServletContext().getRequestDispatcher("/myprofile");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.signup_form"));
//                    getServletContext().getRequestDispatcher("/signupForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}
