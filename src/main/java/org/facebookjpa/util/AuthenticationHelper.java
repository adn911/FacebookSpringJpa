package org.facebookjpa.util;

import org.facebookjpa.persistance.entity.User;

import javax.servlet.http.HttpSession;

/**
 * Created by bakhtiar.galib on 4/5/15.
 */
public class AuthenticationHelper {

    public static User getAuthenticatedUser(HttpSession httpSession) {
        return (User) httpSession.getAttribute("user");
    }

    public static void setAuthenticatedUser(HttpSession httpSession, User user) {
        httpSession.setAttribute("user", user);
    }

    public static boolean isUserAuthenticated(HttpSession httpSession) {
        return getAuthenticatedUser(httpSession) != null;
    }


}
