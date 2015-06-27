package org.facebookjpa.persistance.dao;

import org.facebookjpa.persistance.entity.Post;
import org.facebookjpa.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */

@Repository
@Transactional
public class PostDaoImpl implements PostDao {

    @Autowired
    UserDao userDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    LikeDao likeDao;

    @Autowired
    FriendDao friendDao;

    @PersistenceContext
    private EntityManager entityManager;

    public PostDaoImpl() {

    }

    @Override
    public void insertPost(Post post) {
        entityManager.persist(post);
    }

    @Override
    public void updatePost(Post post) {
        entityManager.merge(post);
    }

    @Override
    public Post getPost(int postId) {

        return entityManager.find(Post.class, postId);
    }

    @Override
    public List<Post> getAllPosts() {

        return entityManager.createQuery("SELECT p FROM Post AS p ORDER BY p.created DESC", Post.class).getResultList();
    }

    @Override
    public List<Post> getNewsFeedPostsWithComments(int userId) {
        List<Post> newsFeedPosts = getUserPosts(userId);

        newsFeedPosts.addAll(getFriendsPost(userId));

        return newsFeedPosts;
    }

    public List<Post> getFriendsPost(int userId) {
        List<Post> friendsPosts = new ArrayList<Post>();

        List <User>friends = friendDao.getFriends(userId);
        for (User u : friends) {
            friendsPosts.addAll(getUserPosts(u.getId()));
        }

        return friendsPosts;
    }


    @Override
    public List<Post> getUserPosts(int userId) {
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p WHERE p.user.id = :userId ORDER BY p.created DESC", Post.class);

        query.setParameter("userId", userId);

        return query.getResultList();
    }

    @Override
    public List<Post> getUserPostsWithComments(int userId) {
        List<Post> userPostsWithComments = getUserPosts(userId);

        return userPostsWithComments;
    }

    @Override
    public void removePost(Post post) {
        entityManager.remove(post);
    }

    @Override
    public void removePost(int postId) {
        entityManager.remove(getPost(postId));
    }


    private Post getSingleResultOrNull(TypedQuery<Post> query) {
        query.setMaxResults(1);
        List<Post> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}
