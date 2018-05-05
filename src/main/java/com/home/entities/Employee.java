package com.home.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @TableGenerator(name = "empIdGen",
            table="ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VAL",
            pkColumnValue = "empIdGen",
            allocationSize = 1)
    @GeneratedValue(generator = "empIdGen")
    private long id;

    @Column(name = "EMP_NAME")
    private String name;

    @Embedded
    private Address address;

    @ManyToOne
    private Department department;

    private LocalDate dob;

    private int salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @MapKey(name = "phoneType")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<PhoneType, Phone> phones = new HashMap<>();
//    private List<Phone> phones = new ArrayList<>();

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Map<PhoneType, Phone> getPhones() {
        return phones;
    }

    public void setPhones(Map<PhoneType, Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", department=" + department +
                ", dob=" + dob +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
