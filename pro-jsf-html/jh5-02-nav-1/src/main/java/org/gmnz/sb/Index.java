package org.gmnz.sb;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class Index implements Serializable {

	private static final long serialVersionUID = -8072511246532140306L;



	public String goWithForward() {
		return "askedForForward";
	}



	public String goWithRedirect() {
		return "askedForRedirect";
	}
}
