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
        name = "ToLoginForm",
        urlPatterns={"/toLoginForm"})
public class ToLoginForm extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropertyManager propertyManager = new PropertyManager();
        HttpSession session = request.getSession();

        if (LoginChecker.userIsLoggedIn(session)) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.index"));
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(propertyManager.getProperty("jsp.login"));
            dispatcher.forward(request, response);
        }
    }
}
