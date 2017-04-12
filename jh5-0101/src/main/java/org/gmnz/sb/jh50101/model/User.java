package org.gmnz.sb.jh50101.model;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/*
Ho inserito informazioni aggiuntive sulla particolare istanza legata alla sessione perché ho notato che quando l'applicazione si avvia e viene richiesta la prima pagina, viene creata più di una istanza di questo bean gestito.

In particolare, con Tomcat 8.5 osservo che vengono create 3 istanze distinte del bean, ma naturalmente soltanto una viene utilizzata per servire la richiesta, e verosimilmente solo una viene legata alla sessione.
 */

@ManagedBean
@SessionScoped
public class User implements Serializable {


    private static final long serialVersionUID = -1488800986294740922L;

    private String name;
    private String password;

    public User() {
        System.out.println("constructor invoked");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.format("postConstruct() method invoked | instance %d%n", hashCode());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.format("preDestroy() method invoked | instance %d%n", hashCode());
    }


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


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", hashCode=").append(hashCode());
        sb.append('}');
        return sb.toString();
    }
}
