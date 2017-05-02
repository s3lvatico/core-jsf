package org.gmnz.sb.jsf.phaselisteners.converter;


import org.gmnz.sb.jsf.phaselisteners.model.Profession;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


public class ProfessionConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
		String[] tok = s.split("\\|");
		if (tok.length == 2) {
			return new Profession(tok[0], tok[1]);
		}
		String summary = "Wrong profession format";
		String description = "should be <role>|<industry>";
		FacesMessage errMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, description);
		throw new ConverterException(errMsg);
	}



	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
		Profession p = (Profession) o;
		return String.format("%s|%s", p.getRole(), p.getIndustry());
	}
}
