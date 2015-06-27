package org.facebookjpa.persistance.dao;


import org.facebookjpa.persistance.entity.Like;
import org.facebookjpa.persistance.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GALIB on 2/8/2015.
 */

@Repository
@Transactional
public class LikeDaoImpl implements LikeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addLike(Like like) {
        entityManager.persist(like);
    }

    @Override
    public void removeLike(int likeId) {
        entityManager.remove(getLike(likeId));
    }


    @Override
    public void removeLike(int postId, int userId) {
        Query query = entityManager.createQuery("DELETE FROM PostLike AS l WHERE l.post.id = :postId AND l.user.id = :userId");

        query.setParameter("postId", postId);
        query.setParameter("userId", userId);

        query.executeUpdate();
    }

    @Override
    public List<User> getLikedUsers(int postId) {
        List<User> likedUsers = new ArrayList<User>();
        List<Like> postLikes = getPostLikes(postId);

        for (Like like : postLikes) {
            likedUsers.add(like.getUser());
        }

        return likedUsers;
    }

    @Override
    public boolean isPostLikedByUser(int postId, int userId) {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM PostLike AS l WHERE l.post.id = :postId AND l.user.id = :userId");

        query.setParameter("postId", postId);
        query.setParameter("userId", userId);

        return (Long) query.getSingleResult() == 1;
    }

    @Override
    public Like getLike(int likeId) {

        return entityManager.find(Like.class, likeId);
    }

    @Override
    public List<Like> getPostLikes(int postId) {
        TypedQuery<Like> query = entityManager.createQuery("SELECT l FROM PostLike AS l WHERE l.post.id = :postId",Like.class);

        return query.setParameter("postId", postId).getResultList();
    }

    @Override
    public Long getLikeCount(int postId) {
        Query query = entityManager.createQuery("SELECT COUNT(l) FROM PostLike AS l WHERE l.post.id = :postId");

        return (Long) query.setParameter("postId", postId).getSingleResult();
    }

    private Like getSingleResultOrNull(TypedQuery<Like> query) {
        query.setMaxResults(1);
        List<Like> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}
