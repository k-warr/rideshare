package com.servlets;

import com.entity.User;
import com.logic.PropertyManager;
import com.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

/**
 *  This servlet handles logic after the Submit button is pressed on the
 * project4_employee_search.jsp form. If the search is empty, then it will redirect
 * the page back to project4_employee_search. Otherwise, it will perform the
 * search
 *
 *@author    Kien Warren
 */
@WebServlet(
        name = "SignupFormHandler",
        urlPatterns = {"/signupFormHandler"}    // must be unique
) public class SignupFormHandler extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
//    private Properties properties;

    private final static PropertyManager propertyManager = new PropertyManager();


    /**
     *  Handles HTTP POST requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
//        ServletContext context = getServletContext();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phoneNumber"));

        User newUser = new User();
        UserDao dao = new UserDao();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setMaxRidersInclDriver(0);
        dao.addUser(newUser);
        log.info("PROPERTIES: " + propertyManager.getProperty("google_api_key"));

        request.setAttribute("newUser", true);

            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
//        }
    }
}