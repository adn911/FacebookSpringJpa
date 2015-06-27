package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.UserService;
import org.facebookjpa.util.DateTimeHelper;
import org.facebookjpa.util.ImageUploadHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
public class SignupController {

    private static final Logger log = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String showSignup(Model model) {
        model.addAttribute("signupUser", new User());

        return "signup";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public String processSignup(@Valid @ModelAttribute("signupUser") User signupUser, BindingResult result, @RequestParam(value = "picture", required = false) MultipartFile image, Model model) throws IOException {
        if (!result.hasErrors() ) {

            if(!image.isEmpty() && ImageUploadHelper.isValidImage(image)){

                String webAppRoot = servletContext.getRealPath("");

                String fileName = DateTimeHelper.getCurrentNanoTimeString() + ".jpg";

                ImageUploadHelper.saveImage(webAppRoot, fileName, image);

                signupUser.setProfilePicture(fileName);
            }

            userService.insertUser(signupUser);
            model.addAttribute("success", 1);

        } else {
            model.addAttribute("error", 1);
        }

        return "signup";
    }

}
