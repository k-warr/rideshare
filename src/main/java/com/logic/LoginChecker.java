package com.logic;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Created by student on 5/4/17.
 */
public class LoginChecker {

    public static boolean userIsLoggedIn(HttpSession session) {
        if (session.getAttribute("username") != null && session.getAttribute("username") != "") {
            return true;
        } else {
            return false;
        }
    }
}
