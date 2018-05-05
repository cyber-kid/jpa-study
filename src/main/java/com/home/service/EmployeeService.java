package com.home.service;

import com.home.entities.Department;
import com.home.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

public class EmployeeService {
    public long addDepartment(Department department, EntityManager entityManager) {
        entityManager.persist(department);
        return department.getId();
    }

    public long addEmployee(Employee employee, EntityManager entityManager) {
        entityManager.persist(employee);
        return employee.getId();
    }

    public Employee findEmployeeById(long id, EntityManager entityManager) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees(EntityManager entityManager) {
        String sql = "select e from Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(sql, Employee.class);

        return query.getResultList();
    }

    public List<Department> findAllDepartments(EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Department> criteriaQuery = cb.createQuery(Department.class);
        Root<Department> dept = criteriaQuery.from(Department.class);
        criteriaQuery.select(dept);

        TypedQuery<Department> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Department findDepartmentById(long id, EntityManager entityManager) {
        return entityManager.find(Department.class, id);
    }

    public void assignEmployeeToDepartment(long employeeId, long departmentId, EntityManager entityManager) {
        Department department = findDepartmentById(departmentId, entityManager);
        Employee employee = findEmployeeById(employeeId, entityManager);

        employee.setDepartment(department);

        department.getEmployees().add(employee);
    }

    public void moveEmployeeToDepartment(long employeeId, long departmentId, EntityManager entityManager) {
        Employee employee = findEmployeeById(employeeId, entityManager);

        List<Employee> departmentEmployees = employee.getDepartment().getEmployees();
        Iterator<Employee> iterator = departmentEmployees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.equals(employee)) {
                iterator.remove();
                break;
            }
        }

        Department department = findDepartmentById(departmentId, entityManager);

        department.getEmployees().add(employee);
        employee.setDepartment(department);
    }

    public void clearAllTables(EntityManager entityManager) {
        String deletePhones = "delete from Phone";
        String deleteEmployees = "delete from Employee";
        String deleteDepartments = "delete from Department";

        Query query = entityManager.createQuery(deletePhones);
        query.executeUpdate();

        query = entityManager.createQuery(deleteEmployees);
        query.executeUpdate();

        query = entityManager.createQuery(deleteDepartments);
        query.executeUpdate();
    }
}
