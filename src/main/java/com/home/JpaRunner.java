package com.home;

import com.home.entities.*;
import com.home.service.EmployeeService;
import com.home.utils.PersistenceUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class JpaRunner {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        EntityManager em = PersistenceUtils.getEntityManager();

        /* Add new department */

        Address deptAddress = new Address("Philadelphia", "PA", "Main street");

        Department dept = new Department();
        dept.setName("IT");
        dept.setAddress(deptAddress);

        em.getTransaction().begin();

        long departmentId = service.addDepartment(dept, em);
        System.out.println("New department id: " + departmentId);
        System.out.println("New department: " + service.findDepartmentById(departmentId ,em));

        em.getTransaction().commit();

        /* Add new employee */

        Address employeeAddress = new Address("Boston", "MA", "Main street");

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAddress(employeeAddress);
        employee.setSalary(5500);
        employee.setDob(LocalDate.of(1987, 4, 16));

        em.getTransaction().begin();

        long employeeId = service.addEmployee(employee, em);

        service.assignEmployeeToDepartment(employeeId, departmentId, em);

        System.out.println("New employee id: " + employeeId);
        System.out.println("New employee: " + service.findEmployeeById(employeeId, em));

        em.getTransaction().commit();

        /* Move employee to a new department */

        Address newDeptAddress = new Address("Virginia Beach", "VA", "Atlantic avenue");

        Department newDept = new Department();
        newDept.setName("Support");
        newDept.setAddress(newDeptAddress);

        em.getTransaction().begin();
        long newDepartmentId = service.addDepartment(newDept, em);

        service.moveEmployeeToDepartment(employeeId, newDepartmentId, em);

        System.out.println("Employee moved to a department with id " + newDepartmentId);
        System.out.println("Employee is: " + service.findEmployeeById(employeeId, em));

        em.getTransaction().commit();

        /* Add phones to employee */

        em.getTransaction().begin();
        employee = service.findEmployeeById(employeeId, em);

        Phone home = new Phone();
        home.setPhoneType(PhoneType.HOME);
        home.setPhoneNumber("+666");
        home.setEmployee(employee);

        Phone mobile = new Phone();
        mobile.setPhoneType(PhoneType.MOBILE);
        mobile.setPhoneNumber("+333");
        mobile.setEmployee(employee);

        employee.getPhones().put(home.getPhoneType(), home);
        employee.getPhones().put(mobile.getPhoneType(), mobile);

        em.getTransaction().commit();

        employee = service.findEmployeeById(employeeId, em);

        System.out.println("Employee id: " + employee.getId());
        System.out.println("Employee home phone number: " + employee.getPhones().get(PhoneType.HOME));
        System.out.println("Employee mobile phone number: " + employee.getPhones().get(PhoneType.MOBILE));

        /* List all departments */

        System.out.println("List all departments");
        for (Department department: service.findAllDepartments(em)) {
            System.out.println(department);
        }

        em.close();
        PersistenceUtils.destroyEntityManagerFactory();
    }
}
