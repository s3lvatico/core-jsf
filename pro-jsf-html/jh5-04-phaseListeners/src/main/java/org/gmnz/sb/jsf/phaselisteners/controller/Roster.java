package org.gmnz.sb.jsf.phaselisteners.controller;

import org.gmnz.sb.jsf.phaselisteners.model.Address;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class Roster implements Serializable {

    private static final long serialVersionUID = 4565522402435506436L;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;
}
