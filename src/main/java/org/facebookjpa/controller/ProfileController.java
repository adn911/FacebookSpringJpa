package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.PostService;
import org.facebookjpa.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
public class ProfileController {

    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/profile/{userId}"}, method = RequestMethod.GET)
    public String profile(@PathVariable("userId") int userId, Model model) {
        log.debug("At Profile page");

        User user = userService.getUser(userId);
        model.addAttribute("posts", postService.getUserPostsWithComments(user.getId()));

        return "profile";
    }

}
