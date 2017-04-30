package org.gmnz.sb.jsf.phaselisteners.model;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -3490372689973209412L;

    private String name;
    private Address address;
    private Profession profession;
    private String email;

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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
