package com.servlets;

import com.logic.PropertyManager;

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
        name = "Logout",
        urlPatterns = {"/logout"})
public class Logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropertyManager propertyManager = new PropertyManager();
        HttpSession session = request.getSession();

        session.invalidate();
        response.sendRedirect(propertyManager.getProperty("jsp.index"));
        return;
    }
}