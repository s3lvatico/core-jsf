package org.gmnz.sb;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class PageController implements Serializable {

	private static final long serialVersionUID = -7625645837905757299L;

	private Location location;



	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}



	public String proceed() {
		return null;
	}
}
