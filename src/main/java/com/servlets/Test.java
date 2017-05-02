package com.servlets;

import com.entity.User;
import com.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  This servlet handles logic after the Submit button is pressed on the
 * project4_employee_search.jsp form. If the search is empty, then it will redirect
 * the page back to project4_employee_search. Otherwise, it will perform the
 * search
 *
 *@author    Kien Warren
 */
@WebServlet(
        name = "testPage",
        urlPatterns = {"/test"}    // must be unique
) public class Test extends HttpServlet {

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

//        EmployeeDirectory directory = (EmployeeDirectory) context.getAttribute("employeeDirectory");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phoneNumber"));

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        UserDao dao = new UserDao();
        dao.addUser(newUser);
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