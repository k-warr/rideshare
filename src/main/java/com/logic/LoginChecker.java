package com.logic;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Created by Kien Warren on 5/4/17.
 */
public class LoginChecker {

    /**
     * User is logged in boolean.
     *
     * @param session the session
     * @return the boolean
     */
    public static boolean userIsLoggedIn(HttpSession session) {
        try {
            String username =  session.getAttribute("username").toString();
        } catch (NullPointerException e) {
            return false;
        }
        if (!session.getAttribute("username").equals(null) && !session.getAttribute("username").equals(' ')) {
            return true;
        } else {
            return false;
        }
    }
}
