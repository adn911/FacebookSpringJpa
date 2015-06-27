package org.facebookjpa.persistance.dao;

import org.facebookjpa.persistance.entity.Comment;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface CommentDao {

    void insertComment(Comment comment);

    void updateComment(Comment updatedComment);

    List<Comment> getPostComments(int postId);

    List<Comment> getUserComments(int userId);

    void removeComment(int commentId);

    Comment getComment(int commentId);

    void removeComment(Comment comment);
}
