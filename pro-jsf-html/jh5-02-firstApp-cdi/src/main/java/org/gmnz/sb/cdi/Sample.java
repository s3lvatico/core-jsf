package org.gmnz.sb.cdi;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class Sample implements Serializable {

	public String getName() {
		return "the sample CDI bean";
	}



	public void setName(String name) {
		// does nothing
	}



	public void postConstruct() {
		System.out.println("postConstruct() method invoked");
	}

}
