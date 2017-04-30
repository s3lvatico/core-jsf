package org.gmnz.sb.jsf.phaselisteners.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.xml.bind.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("roster.emailValidator")
public class EmailValidator implements Validator {

    private static final String regexPattern = "(.+@.+\\.[a-zA-Z]+)?";
    private Pattern pattern;
    private Matcher matcher;

    public EmailValidator() {
        pattern = Pattern.compile(regexPattern);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        matcher = pattern.matcher(o.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "wrong email format", "use a valid email, like \"john@example.com\"");
            throw new ValidatorException(msg);
        }
    }
}
