package org.gmnz.sb.jsf.phaselisteners.model;


public class Profession {


    private String role;
    private String industry;

    public Profession(String role, String industry) {
        this.role = role;
        this.industry = industry;
    }

    public Profession() {
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
}
