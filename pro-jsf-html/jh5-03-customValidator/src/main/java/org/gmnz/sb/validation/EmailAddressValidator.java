package org.gmnz.sb.validation;


import org.gmnz.sb.validation.EmailAddress;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailAddressValidator implements ConstraintValidator<EmailAddress, String> {

	private static final String EMAIL_REGEX = "(.+@.+\\.[a-zA-Z]+)?";
	private Pattern pattern;
	private Matcher matcher;



	@Override
	public void initialize(EmailAddress emailAddress) {
		pattern = Pattern.compile(EMAIL_REGEX);
	}



	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		matcher = pattern.matcher(s);

		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
}
