package org.facebookjpa.persistance.dao;

import org.facebookjpa.persistance.entity.User;

import java.util.List;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public interface UserDao {

    User loginUser(String email, String password);

    void insertUser(User user);

    void updateUser(User user);

    void deactivateUser(User user);

    List<User> getAllUsers();

    boolean userExists(int userId);

    User getUser(int userId);

    void removeUser(User user);

}
