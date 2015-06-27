package org.facebookjpa.services;

import org.facebookjpa.persistance.dao.LikeDao;
import org.facebookjpa.persistance.entity.Like;
import org.facebookjpa.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by GALIB on 4/10/2015.
 */
@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDao likeDao;

    @Override
    public void addLike(Like like) {
        likeDao.addLike(like);
    }

    @Override
    public void removeLike(int likeId) {
        likeDao.removeLike(likeId);
    }

    @Override
    public void removeLike(int postId, int userId) {
        likeDao.removeLike(postId,userId);
    }

    @Override
    public List<User> getLikedUsers(int postId) {
        return likeDao.getLikedUsers(postId);
    }

    @Override
    public boolean isPostLikedByUser(int postId, int userId) {
        return likeDao.isPostLikedByUser(postId, userId);
    }

    @Override
    public Like getLike(int likeId) {
        return null;
    }

    @Override
    public List<Like> getPostLikes(int postId) {
        return likeDao.getPostLikes(postId);
    }

    @Override
    public Long getLikeCount(int postId) {
        return likeDao.getLikeCount(postId);
    }
}
