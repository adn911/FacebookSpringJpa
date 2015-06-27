package org.facebookjpa.services;

import org.facebookjpa.persistance.dao.PostDao;
import org.facebookjpa.persistance.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    public PostServiceImpl() {

    }

    @Override
    public void insertPost(Post post) {
       postDao.insertPost(post);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public Post getPost(int postId) {
        return postDao.getPost(postId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @Override
    public List<Post> getNewsFeedPostsWithComments(int userId) {
        return postDao.getNewsFeedPostsWithComments(userId);
    }

    @Override
    public List<Post> getUserPosts(int userId) {
       return postDao.getUserPosts(userId);
    }

    @Override
    public List<Post> getUserPostsWithComments(int userId) {
        return postDao.getUserPostsWithComments(userId);
    }

    @Override
    public void removePost(Post post) {
        postDao.removePost(post);
    }

    @Override
    public void removePost(int postId) {
      postDao.removePost(postId);
    }
}
