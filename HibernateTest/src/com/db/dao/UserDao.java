package com.db.dao;

import com.db.models.User;
import com.db.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class UserDao {

    private JPAUtil util = new JPAUtil();

    public void add(User user) {
        EntityManager manager = util.getEntityManager();

        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();

        manager.close();
    }

    public Collection<User> fetchAllUsers() {
        EntityManager manager = util.getEntityManager();

        manager.getTransaction().begin();

        Query query = manager.createQuery("select u from User u", User.class);
        List<User> users = query.getResultList();
        manager.getTransaction().commit();

        return users;
    }

    public User fetchById(Integer id) {
        EntityManager manager = util.getEntityManager();

        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.getTransaction().commit();

        return user;
    }

}
