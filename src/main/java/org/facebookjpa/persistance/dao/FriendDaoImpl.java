package org.facebookjpa.persistance.dao;

import org.facebookjpa.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FriendDaoImpl implements FriendDao {

    @Autowired
    private UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    public FriendDaoImpl() {
    }

    public List<User> getUsersNotFriend(int userId) {
        List<User> usersNotFriends = userDao.getAllUsers();

        usersNotFriends.removeAll(getFriends(userId));
        usersNotFriends.remove(userDao.getUser(userId));

        return usersNotFriends;
    }

    @Override
    public List<User> getFriends(int userId) {

        TypedQuery<User> query = entityManager.createQuery("select f from User u join u.friends f where u.id = :userId ", User.class);
        query.setParameter("userId",userId);

        return query.getResultList();
    }

    @Override
    public void addFriend(int userId, int friendId) {
        User user = userDao.getUser(userId);
        User friend = userDao.getUser(friendId);

        user.getFriends().add(friend);
        user.getFriendsWith().add(friend);
    }

    @Override
    public void removeFriend(int userId, int friendId) {
        User user = userDao.getUser(userId);
        User friend = userDao.getUser(friendId);

        user.getFriends().remove(friend);
        user.getFriendsWith().remove(friend);
    }

}
