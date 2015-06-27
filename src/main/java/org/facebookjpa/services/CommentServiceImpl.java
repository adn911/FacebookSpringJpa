package org.facebookjpa.services;

import org.facebookjpa.persistance.dao.CommentDao;
import org.facebookjpa.persistance.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by bakhtiar.galib on 2/8/15.
 */

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    public CommentServiceImpl() {

    }

    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }

    @Override
    public void updateComment(Comment updatedComment) {
        commentDao.updateComment(updatedComment);
    }

    @Override
    public List<Comment> getPostComments(int postId) {
        return commentDao.getPostComments(postId);
    }

    @Override
    public List<Comment> getUserComments(int userId) {
        return commentDao.getUserComments(userId);
    }


    @Override
    public void removeComment(int commentId) {
        commentDao.removeComment(commentId);
    }

    @Override
    public void removeComment(Comment comment) {
        commentDao.removeComment(comment);
    }
}
