package org.facebookjpa.controller;

import org.facebookjpa.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
public class ProfileInfoController {

    private static final Logger log = LoggerFactory.getLogger(ProfileInfoController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/info"}, method = RequestMethod.GET)
    public String showInfo(ModelMap model) {
        log.debug("at Profile Info page");

        return "profileInfo";
    }

}
