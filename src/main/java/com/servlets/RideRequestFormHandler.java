package com.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by student on 5/2/17.
 */
@WebServlet(
        name = "RideRequestFormHandler",
        urlPatterns= {"/rideRequestFormHandler"})
public class RideRequestFormHandler extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        ServletContext context = getServletContext();

//        EmployeeDirectory directory = (EmployeeDirectory) context.getAttribute("employeeDirectory");
        String username = request.getParameter("username");
        String addressNumberOrigin = request.getParameter("numberOrigin");
        String streetOrigin = request.getParameter("streetOrigin");
        String cityOrigin = request.getParameter("cityOrigin");
        int zipCodeOrigin = Integer.parseInt(request.getParameter("zipCodeOrigin"));
        String addressNumberDestination = request.getParameter("numberDestination");
        String streetDestination = request.getParameter("streetDestination");
        String cityDestination = request.getParameter("cityDestination");
        int zipCodeDestination = Integer.parseInt(request.getParameter("zipCodeDestination"));




//        String searchTerm = request.getParameter("searchTerm");
//        String searchType = request.getParameter("searchType");

//        if (searchTerm == null || searchTerm.equals("")) {
//            session.setAttribute("noResultsFound", "Please key in values in the search bar below.");
//            response.sendRedirect("/java112/project4-search_display");
//        } else {
//            Search search = directory.searchDatabase(searchTerm, searchType);
//            session.setAttribute("employeesResults", search);

        String url = "/test.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
//        }
    }
}
