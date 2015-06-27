package org.facebookjpa.services;



import org.facebookjpa.persistance.dao.UserDao;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {

    }

    @Override
    public User loginUser(String loginEmail, String loginPassword) {
        return userDao.loginUser(loginEmail, loginPassword);
    }

    @Override
    public void insertUser(User user) {
       userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user){
         userDao.updateUser(user);
    }

    @Override
    public void deactivateUser(User user) {
        userDao.deactivateUser(user);
    }

    @Override
    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean userExists(int userId) {
        return userDao.userExists(userId);
    }

    @Override
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }


}
