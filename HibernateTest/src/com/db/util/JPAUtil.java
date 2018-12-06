package com.db.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("context");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void closeConnection() {
        emf.close();
    }

}
