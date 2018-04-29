package com.home.service;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

public class EmployeeServiceTest {
    private EmployeeService employeeService = new EmployeeService();

    @Test
    public void getEntityManagerTest() {
        EntityManager entityManager = employeeService.getEntityManager();

        Assert.assertNotNull(entityManager);
    }
}
