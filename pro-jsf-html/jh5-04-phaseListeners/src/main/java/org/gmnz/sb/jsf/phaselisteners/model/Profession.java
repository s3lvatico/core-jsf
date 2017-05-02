package org.gmnz.sb.jsf.phaselisteners.model;


public class Profession {


	private String role = "none";
	private String industry = "---";



	public Profession(String role, String industry) {
		this.role = role;
		this.industry = industry;
	}



	public Profession() {
		System.out.println("new Profession object created: " + toString());
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getIndustry() {
		return industry;
	}



	public void setIndustry(String industry) {
		this.industry = industry;
	}



	@Override
	public String toString() {
		return "Profession{" +
				  "role='" + role + '\'' +
				  ", industry='" + industry + '\'' +
				  '}';
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Profession that = (Profession) o;

		if (!role.equals(that.role)) return false;
		return industry.equals(that.industry);
	}



	@Override
	public int hashCode() {
		int result = role.hashCode();
		result = 31 * result + industry.hashCode();
		return result;
	}
}
