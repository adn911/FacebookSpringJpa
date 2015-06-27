package org.facebookjpa.persistance.dao;


import org.facebookjpa.persistance.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by bakhtiar.galib on 2/8/15.
 */
@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    public CommentDaoImpl() {

    }

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insertComment(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void updateComment(Comment updatedComment) {
        entityManager.merge(updatedComment);
    }

    @Override
    public List<Comment> getPostComments(int postId) {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment AS c WHERE c.post.id=:postId", Comment.class);

        query.setParameter("postId", postId);

        return query.getResultList();
    }

    @Override
    public List<Comment> getUserComments(int userId) {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment AS c WHERE c.user.id = :userId", Comment.class);

        query.setParameter("userId", userId);

        return query.getResultList();
    }

    public void removeComment(int commentId) {
        removeComment(getComment(commentId));
    }

    @Override
    public Comment getComment(int commentId) {
        return entityManager.find(Comment.class, commentId);
    }

    @Override
    public void removeComment(Comment comment) {
        entityManager.remove(comment);
    }

}
