package org.gmnz.sb.jsf.ch0101;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "user")
@SessionScoped
public class UserBackBean implements Serializable {

    private String name = "";
    private String password = "";


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

    public String getGreeting() {
        if (name.isEmpty() || password.isEmpty()) return "";
        else return "hello, " + name + "!";
    }
}
