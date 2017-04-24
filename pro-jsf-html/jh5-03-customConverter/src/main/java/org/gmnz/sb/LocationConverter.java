package org.gmnz.sb;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/*

1) codifica la classe converter

2) dichiarala nel faces-config.xml

 */

public class LocationConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
		if (s == null || s.trim().isEmpty()) return null;

		String[] locationParts = s.split(",");
		if (locationParts.length != 3 || locationParts[0].isEmpty() || locationParts[1].isEmpty() || locationParts[2]
				  .isEmpty()) {
			FacesMessage msg = new FacesMessage("Invalid location format", "Location format is (address, city, " +
					  "country)");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
		String address = locationParts[0];
		String city = locationParts[1];
		String country = locationParts[2];
		Location l = new Location(address, city, country);
		return l;
	}



	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
		Location l = (Location) o;
		return String.format("%s,%s,%s", l.getAddress(), l.getCity(), l.getCountry());
	}
}
