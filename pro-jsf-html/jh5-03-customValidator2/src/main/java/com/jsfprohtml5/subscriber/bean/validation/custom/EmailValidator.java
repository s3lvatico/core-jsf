package com.jsfprohtml5.subscriber.bean.validation.custom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailAddress, String> {
    private static final String EMAIL_REGEX = "(.+@.+\\.[a-zA-Z]+)?";
 
    private Pattern pattern;
    private Matcher matcher;  
    
    @Override
    public void initialize(EmailAddress constraintAnnotation) {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {        
        matcher = pattern.matcher(value);
        
        if (! matcher.matches()) {
            return false;
        }
        
        return true;
    }
}
