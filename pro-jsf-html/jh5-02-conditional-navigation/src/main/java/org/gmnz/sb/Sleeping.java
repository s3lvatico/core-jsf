package org.gmnz.sb.cdi;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class Sleeping implements Serializable {


    private static final long serialVersionUID = -8714254071916293521L;

    private Integer hours;

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
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
