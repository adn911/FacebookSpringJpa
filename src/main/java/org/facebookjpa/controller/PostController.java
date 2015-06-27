package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.Post;
import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.PostService;
import org.facebookjpa.util.AuthenticationHelper;
import org.facebookjpa.util.DateTimeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */

@Controller
@RequestMapping("/posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addNewPost(@RequestParam("postContent") String postContent) {
        log.debug("Adding New Post");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);

        Post post = new Post();
        post.setContent(postContent);
        post.setType(1);
        post.setUser(user);

        postService.insertPost(post);

        return "redirect:/home";

    }

    @RequestMapping(value = {"/remove"}, method = RequestMethod.POST)
    public String removePost(@RequestParam("postId") int postId) {
        log.debug("Removing Post");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);
        postService.removePost(postId);

        return "redirect:/home";
    }


}
