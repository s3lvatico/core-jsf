package org.gmnz.sb.jsf.phaselisteners.model;


import java.io.Serializable;


public class Address implements Serializable {

	private static final long serialVersionUID = -5142680401898961936L;

	private String street;      // via Parco, 2/B
	private String town;        // San Mariano
	private String postalCode;  // 06073
	private String city;        // Corciano



	public Address() {
		street = "none set";
		town = "none set";
		postalCode = "none set";
		city = "none set";
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getTown() {
		return town;
	}



	public void setTown(String town) {
		this.town = town;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	@Override
	public String toString() {
		return "Address{" +
				  "street='" + street + '\'' +
				  ", town='" + town + '\'' +
				  ", postalCode='" + postalCode + '\'' +
				  ", city='" + city + '\'' +
				  '}';
	}
}
