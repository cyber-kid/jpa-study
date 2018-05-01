package com.home.service;

import com.home.utils.PersistenceUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

public class EmployeeServiceTest {
    @Test
    public void getEntityManagerTest() {
        EntityManager entityManager = PersistenceUtils.getEntityManager();

        Assert.assertNotNull(entityManager);
    }
}
