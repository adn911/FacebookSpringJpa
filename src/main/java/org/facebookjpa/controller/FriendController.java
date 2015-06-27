package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.FriendService;
import org.facebookjpa.util.AuthenticationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
public class FriendController {

    private static final Logger log = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    FriendService friendService;

    @RequestMapping(value = {"/friends"}, method = RequestMethod.GET)
    public String showFriends(Model model) {
        log.debug("at Friends page");

        User user = (User) AuthenticationHelper.getAuthenticatedUser(httpSession);
        model.addAttribute("friends", friendService.getFriends(user.getId()));

        return "friends";
    }


    @RequestMapping(value = {"/addFriend"}, method = RequestMethod.GET)
    public String showAddableFriends(Model model) {
        log.debug("at Friends page");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);
        model.addAttribute("usersNotFriends", friendService.getUsersNotFriend(user.getId()));

        return "addFriend";
    }

    @RequestMapping(value = {"/removeFriend"}, method = RequestMethod.POST)
    public String removeFriend(@RequestParam("userId") int friendId) {
        log.debug("at Friends page");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);
        friendService.removeFriend(user.getId(), friendId);

        return "redirect:/friends";
    }

    @RequestMapping(value = {"/addFriend"}, method = RequestMethod.POST)
    public String addFriend(@RequestParam("userId") int friendId) {
        log.debug("at Friends page");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);
        friendService.addFriend(user.getId(), friendId);

        return "redirect:/addFriend";
    }


}
