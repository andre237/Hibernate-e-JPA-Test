package com.db.test;

import com.db.dao.UserDao;
import com.db.models.User;
import com.db.util.JPAUtil;
import java.util.Collection;

public class PersistTest {

    public static void main(String[] args) {

        UserDao dao = new UserDao();
        JPAUtil util = new JPAUtil();

        Collection<User> users = dao.fetchAllUsers();

        for (User u : users) {
            System.out.println(u.toString());
        }

        util.closeConnection();

    }

}
