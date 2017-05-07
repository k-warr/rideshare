package com.logic;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Created by student on 5/4/17.
 */
public class LoginChecker {

    public static boolean userIsLoggedIn(HttpSession session) {
        if (!session.getAttribute("username").equals(null) && !session.getAttribute("username").equals(' ')) {
            return true;
        } else {
            return false;
        }
    }
}
