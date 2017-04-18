package com.jsfprohtml5.firstapplication.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User implements Serializable {
    
    private String name;
    private String password;
    private Profession profession;
    
    private List<String> favoriteSports;
    private Map<String, String> spokenLanguages;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<String> getFavoriteSport() {
        return favoriteSports;
    }

    public void setFavoriteSports(List<String> favoriteSports) {
        this.favoriteSports = favoriteSports;
    }    
    
    public Map<String, String> getSpokenLanguages() {      
        return spokenLanguages;
    }

    public void setSpokenLanguages(Map<String, String> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }    
    
    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    
    public String login() {       
        return "welcome";
    }
    
    @PostConstruct
    private void initialize() {
        System.out.println("Bean is initialized with the following user name: " + name);       
    }
    
    @PreDestroy
    private void cleanUp() {
        System.out.println("You can do the cleanup here");
    }
}