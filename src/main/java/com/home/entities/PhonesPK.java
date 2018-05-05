package com.home.entities;

import java.io.Serializable;
import java.util.Objects;

public class PhonesPK implements Serializable {
    private PhoneType phoneType;
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhonesPK phonesPK = (PhonesPK) o;
        return phoneType == phonesPK.phoneType &&
                Objects.equals(employee, phonesPK.employee);
    }

    @Override
    public int hashCode() {

        return Objects.hash(phoneType, employee);
    }
}
