package com.home.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtils {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void destroyEntityManagerFactory() {
        factory.close();
    }
}
