package org.facebookjpa.persistance.dao;


import org.facebookjpa.persistance.entity.User;
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
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {

    }

    @Override
    public User loginUser(String loginEmail, String loginPassword) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User AS u WHERE u.email=:email AND u.password=:password", User.class);

        query.setParameter("email", loginEmail);
        query.setParameter("password", loginPassword);

        return getSingleResultOrNull(query);
    }

    @Override
    public void insertUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User updatedUserInfo) {
        User user = entityManager.find(User.class, updatedUserInfo.getId());
        user.update(updatedUserInfo);
    }

    @Override
    public void deactivateUser(User user) {
        user.setActive(false);
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("SELECT u FROM User AS u", User.class).getResultList();
    }

    @Override
    public boolean userExists(int userId) {
        return getUser(userId) != null;
    }

    @Override
    public User getUser(int userId) {

        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User AS u WHERE u.id=:id", User.class);
        query.setParameter("id", userId);

        return getSingleResultOrNull(query);
    }

    private User getSingleResultOrNull(TypedQuery<User> query) {
        query.setMaxResults(1);
        List<User> list = query.getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}