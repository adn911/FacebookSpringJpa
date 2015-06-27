package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.PostService;
import org.facebookjpa.util.AuthenticationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String showHome(ModelMap model) {
        log.debug("At home page");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);
        model.addAttribute("posts", postService.getNewsFeedPostsWithComments(user.getId()));

        return "home";
    }

}
