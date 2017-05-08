package com.servlets;

import com.logic.LoginChecker;
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
 * Created by student on 5/7/17.
 */
@WebServlet(
        name = "ToBecomeADriverForm",
        urlPatterns={"/toBecomeADriverForm"})
public class ToBecomeADriverForm extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (LoginChecker.userIsLoggedIn(session)) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/becomeADriverForm.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("notLoggedIn", true);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
