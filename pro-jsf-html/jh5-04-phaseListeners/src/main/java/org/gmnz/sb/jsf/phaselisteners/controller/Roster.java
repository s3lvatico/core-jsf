package org.gmnz.sb.jsf.phaselisteners.controller;


import org.gmnz.sb.jsf.phaselisteners.model.Address;
import org.gmnz.sb.jsf.phaselisteners.model.Profession;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.event.ComponentSystemEvent;
import java.io.Serializable;


@ManagedBean
@RequestScoped
public class Roster implements Serializable {

	private static final long serialVersionUID = 4565522402435506436L;

	private String name;
	private Address address; // = new Address()
	private Profession profession; // = new Profession()
	private String email = "--none set--";


	private String strProf;



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



	public String getStrProf() {
		return strProf;
	}



	public void setStrProf(String strProf) {
		this.strProf = strProf;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String register() {
		System.out.println("register() method invoked - summary of entered data:");
		System.out.format("name       : <%s>%n", name);
		System.out.format("address    : <%s>%n", address);
		System.out.format("profession : <%s>%n", profession);
		System.out.format("email      : <%s>%n", email);
		return null;
	}



	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct() invoked for " + getClass().getName());
		System.out.printf("Current bean status: name <%s> | address <%s> | Profession <%s> | email <%s>%n", name,
				  address, profession, email);
	}
}
