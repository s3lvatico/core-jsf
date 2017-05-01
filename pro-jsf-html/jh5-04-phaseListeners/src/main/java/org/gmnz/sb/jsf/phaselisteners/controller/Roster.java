package org.gmnz.sb.jsf.phaselisteners.controller;

import org.gmnz.sb.jsf.phaselisteners.model.Address;
import org.gmnz.sb.jsf.phaselisteners.model.Profession;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class Roster implements Serializable {

    private static final long serialVersionUID = 4565522402435506436L;

    private String name;
    private Address address;
    private Profession profession;
    private String email = "--none set--";

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String register() {
        System.out.println("register() method invoked");
        System.out.println(getAddress());
        return null;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct() invoked for " + getClass().getName());
    }
}
