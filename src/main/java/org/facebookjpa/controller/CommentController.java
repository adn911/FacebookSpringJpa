package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.Comment;
import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.CommentService;
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
@RequestMapping("/comments")
public class CommentController {

    private static final Logger log = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;


    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addNewComment(@RequestParam("postId") int postId, @RequestParam("commentContent") String commentContent) {
        log.debug("Adding New Comment");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);

        Comment comment = new Comment();
        comment.setContent(commentContent);
        comment.setUser(user);
        comment.setPost(postService.getPost(postId));

        commentService.insertComment(comment);

        return "redirect:/home";
    }

    @RequestMapping(value = {"/remove"}, method = RequestMethod.POST)
    public String removeComment(@RequestParam("commentId") int commentId) {
        log.debug("Removing Comment");

        commentService.removeComment(commentId);

        return "redirect:/home";
    }


}
