package org.facebookjpa.persistance.dao;

import org.facebookjpa.persistance.entity.Like;
import org.facebookjpa.persistance.entity.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface LikeDao {

    void addLike(Like like);

    void removeLike(int likeId);

    void removeLike(int postId, int userId);

    List<User> getLikedUsers(int postId);

    boolean isPostLikedByUser(int postId, int userId);

    Like getLike(int likeId);

    List<Like> getPostLikes(int postId);

    Long getLikeCount(int postId);
}
