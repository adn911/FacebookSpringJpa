package org.facebookjpa.persistance.dao;


import org.facebookjpa.persistance.entity.Post;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface PostDao {

    void insertPost(Post post);

    void updatePost(Post post);

    Post getPost(int postId);

    List<Post> getAllPosts();

    List<Post> getNewsFeedPostsWithComments(int userId);

    List<Post> getUserPosts(int userId);

    List<Post> getUserPostsWithComments(int userId);

    void removePost(Post post);

    void removePost(int postId);
}
