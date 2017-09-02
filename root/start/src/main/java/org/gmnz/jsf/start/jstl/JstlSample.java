package org.gmnz.jsf.start.jstl;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * creato da simone in data 02/09/2017.
 */
@ApplicationScoped
@ManagedBean
public class JstlSample {

	private String escapableData = "<><>><<<!-- bubuke ùàò";

	public String getEscapableData() {
		return escapableData;
	}

}
