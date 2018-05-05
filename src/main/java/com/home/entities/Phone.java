package com.home.entities;

import javax.persistence.*;

@Entity
@Table(name = "PHONES")
@IdClass(PhonesPK.class)
public class Phone {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "PHONE_TYPE")
    private PhoneType phoneType;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Id
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Employee employee;

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneType=" + phoneType +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
