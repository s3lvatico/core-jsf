package org.gmnz.sb;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/*
Usa le annotazioni coerenti con la tecnologia che scegli (JSF o CDI)
 */

//@Named
//@RequestScoped
@ManagedBean
@SessionScoped
public class Sample implements Serializable {

	private static final long serialVersionUID = 5289555565473556992L;



	public String getName() {
		return "the sample bean";
	}



	public void setName(String name) {
		// does nothing
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
