package org.facebookjpa.services;

import org.facebookjpa.persistance.entity.Comment;
import org.facebookjpa.persistance.entity.Post;
import org.facebookjpa.persistance.entity.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface CommentService {

    void insertComment(Comment comment);

    void updateComment(Comment updatedComment);

    List<Comment> getPostComments(int postId);

    List<Comment> getUserComments(int userId);

    void removeComment(int commentId);

    void removeComment(Comment comment);

}
