package org.gmnz.sb.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = EmailAddressValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EmailAddress {

	String message() default "non va bene"; // va cambiato con un messaggio di risorsa
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
