package com.servlets;

import com.entity.User;
import com.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Kien Warren on 5/8/17.
 */
@WebServlet(
        name = "CreateOrUpdateRide",
        urlPatterns = {"/createOrUpdateRide"})
public class CreateOrUpdateRide extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Get request reached.");
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsername(session.getAttribute("username").toString());


    }
}
