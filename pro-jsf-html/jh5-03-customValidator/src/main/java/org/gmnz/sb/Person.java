package org.gmnz.sb;


import org.gmnz.sb.validation.EmailAddress;
import org.gmnz.sb.validation.EmailGroup;
import org.gmnz.sb.validation.LengthGroup;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Size;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class Person implements Serializable {


	private static final long serialVersionUID = -3264658081105236204L;

	@Size(min = 3, max = 30, groups = LengthGroup.class) // manca l'informazione su groups
	private String name;

	@Size(min = 10, max = 100, groups = LengthGroup.class) // manca l'informazione su groups
	private String address;

	@Size(min = 5, max = 50, groups = LengthGroup.class)
	@EmailAddress(groups = EmailGroup.class)
	private String email;



	public Person() {
	}



	public Person(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String subscribe() {
		return null;
	}



	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct() method invoked");
	}



	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy()");
	}

}
