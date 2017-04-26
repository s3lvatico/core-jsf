package com.jsfprohtml5.subscriber.model;

import com.jsfprohtml5.subscriber.bean.validation.groups.EmailGroup;
import com.jsfprohtml5.subscriber.bean.validation.groups.LengthGroup;
import com.jsfprohtml5.subscriber.bean.validation.custom.EmailAddress;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Size;

@ManagedBean
@RequestScoped
public class Person implements Serializable {
    
    @Size(min = 4, max = 30, groups = LengthGroup.class)
    private String name;
    
    @Size(min = 12, max = 120, groups=LengthGroup.class)    
    private String address;
     
    @Size(min = 5, max = 30, groups = LengthGroup.class)    
    @EmailAddress(groups = EmailGroup.class)
    private String email;
    
    public Person() {
    }
    
    public String subscribe() {
        return null;
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
}
