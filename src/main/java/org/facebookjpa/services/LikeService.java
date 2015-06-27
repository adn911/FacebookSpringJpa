package org.facebookjpa.services;

import org.facebookjpa.persistance.entity.Like;
import org.facebookjpa.persistance.entity.Post;
import org.facebookjpa.persistance.entity.User;

import java.util.List;

/**
 * Created by GALIB on 4/10/2015.
 */
public interface LikeService {

    void addLike(Like like);

    void removeLike(int likeId);

    void removeLike(int postId, int userId);

    List<User> getLikedUsers(int postId);

    boolean isPostLikedByUser(int postId, int userId);

    Like getLike(int likeId);

    List<Like> getPostLikes(int postId);

    Long getLikeCount(int postId);
}
