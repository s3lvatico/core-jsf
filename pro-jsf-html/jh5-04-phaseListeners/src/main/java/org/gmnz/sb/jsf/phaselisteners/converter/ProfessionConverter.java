package org.gmnz.sb.jsf.phaselisteners.converter;


import org.gmnz.sb.jsf.phaselisteners.model.Profession;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


/*
Profession rappresentato come stringa:
{nome_ruolo}|{nome_industria}
 */




public class ProfessionConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
		String[] tok = s.split("\\|");
		if (tok.length == 2) {
			return new Profession(tok[0], tok[1]);
		}
		FacesMessage errMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong profession format", "should be " +
				  "<role>|<industry>");

		throw new ConverterException(errMsg);
	}



	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
		Profession p = (Profession) o;
		return String.format("%s|%s", p.getRole(), p.getIndustry());
	}
}
