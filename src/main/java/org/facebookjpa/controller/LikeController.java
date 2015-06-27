package org.facebookjpa.controller;

import org.facebookjpa.persistance.entity.Like;
import org.facebookjpa.persistance.entity.Post;
import org.facebookjpa.persistance.entity.User;
import org.facebookjpa.services.LikeService;
import org.facebookjpa.services.PostService;
import org.facebookjpa.util.AuthenticationHelper;
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
@RequestMapping("/likes")
public class LikeController {

    private static final Logger log = LoggerFactory.getLogger(LikeController.class);

    @Autowired
    HttpSession httpSession;

    @Autowired
    LikeService likeService;

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String toggleLike(@RequestParam("postId") int postId) {
        log.debug("Adding Like");

        User user = AuthenticationHelper.getAuthenticatedUser(httpSession);

        if( likeService.isPostLikedByUser(postId,user.getId())){
            likeService.removeLike(postId,user.getId());
        }else{
            Like like = new Like();
            like.setUser(user);
            like.setPost(postService.getPost(postId));
            like.setActive(true);

            likeService.addLike(like);
        }

        return "redirect:/home";
    }

}
