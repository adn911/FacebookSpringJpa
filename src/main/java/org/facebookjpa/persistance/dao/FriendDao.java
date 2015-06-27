package org.facebookjpa.persistance.dao;

import org.facebookjpa.persistance.entity.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface FriendDao {

    List<User> getFriends(int userId);

    List<User> getUsersNotFriend(int userId);

    void addFriend(int userId, int friendId);

    void removeFriend(int userId, int friendId);

}
