package org.facebookjpa.services;

import org.facebookjpa.persistance.dao.FriendDao;
import org.facebookjpa.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendDao friendDao;

    public FriendServiceImpl() {

    }

    public List<User> getUsersNotFriend(int userId) {

       return friendDao.getUsersNotFriend(userId);
    }

    @Override
    public List<User> getFriends(int userId) {

      return friendDao.getFriends(userId);
    }

    @Override
    public void addFriend(int userId, int friendId) {

      friendDao.addFriend(userId,friendId);
    }

    @Override
    public void removeFriend(int userId,int friendId) {

      friendDao.removeFriend(userId,friendId);
    }

}
