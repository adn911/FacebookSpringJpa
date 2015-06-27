package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.UserService;
import org.facebookjpa.util.AuthenticationHelper;
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
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
public class UpdateInfoController {

    private static final Logger log = LoggerFactory.getLogger(UpdateInfoController.class);

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserService userService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = {"/updateInfo"}, method = RequestMethod.GET)
    public String showUpdateForm(Model model) {
        model.addAttribute("userInfo", AuthenticationHelper.getAuthenticatedUser(httpSession));

        return "updateInfo";
    }

    @RequestMapping(value = {"/updateInfo"}, method = RequestMethod.POST)
    public String processUpdate(@Valid @ModelAttribute("userInfo") User updatedUserInfo, BindingResult result, @RequestParam(value = "picture", required = false) MultipartFile image, Model model) throws IOException {
        if (!result.hasErrors()) {

            if(!image.isEmpty() && ImageUploadHelper.isValidImage(image)){

                String webAppRoot = servletContext.getRealPath("");

                String fileName = DateTimeHelper.getCurrentNanoTimeString() + ".jpg";

                ImageUploadHelper.saveImage(webAppRoot, fileName, image);

                updatedUserInfo.setProfilePicture(fileName);
            }

            userService.updateUser(updatedUserInfo);

            httpSession.setAttribute("user", userService.getUser(updatedUserInfo.getId()));

            model.addAttribute("success", 1);
        } else {
            model.addAttribute("error", 1);
        }

        return "updateInfo";
    }

}
