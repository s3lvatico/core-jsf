package org.gmnz.sb.jh50101.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class SessionFlag implements Serializable {

    private static final long serialVersionUID = 7344449123042712538L;

    private String sessionIndicator;

    public String getSessionIndicator() {
        return sessionIndicator;
    }

    public void setSessionIndicator(String sessionIndicator) {
        this.sessionIndicator = sessionIndicator;
    }
}
