package org.gmnz.jsf.start.scopes;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class ScControllerR implements Serializable {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String submitData() {
		return "scopeComparison1-2";
	}
}
