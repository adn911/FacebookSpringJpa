package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
@SessionAttributes("user")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String showLogin(Model model) {
        log.debug("At Login page");

        return "login";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.POST)
    public String processLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        User user = userService.loginUser(email, password);

        if (user != null) {
            model.addAttribute("user", user);

            return "redirect:/home";
        }

        model.addAttribute("error", messageSource.getMessage("error.incorrect.credential", null, Locale.getDefault()));

        return "login";
    }

}
