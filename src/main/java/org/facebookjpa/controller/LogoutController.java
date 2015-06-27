package org.facebookjpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
public class LogoutController {

    private static final Logger log = LoggerFactory.getLogger(LogoutController.class);

    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(Model model) {
        log.debug("Loggin out User With Session Id: " + httpSession.getId());

        httpSession.invalidate();

        return "redirect:/login";
    }

}
