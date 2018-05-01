package com.home.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    @Id
    @TableGenerator(name = "deptIdGen",
            table="ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VAL",
            pkColumnValue = "deptIdGen",
            allocationSize = 1)
    @GeneratedValue(generator = "deptIdGen")
    private long id;

    @Column(name = "DEPT_NAME")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
