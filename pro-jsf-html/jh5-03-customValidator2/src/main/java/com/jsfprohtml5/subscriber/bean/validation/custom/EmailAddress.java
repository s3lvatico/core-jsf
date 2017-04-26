package com.jsfprohtml5.subscriber.bean.validation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = EmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EmailAddress {
    String message() default "{email.invalid}";
    
    Class<?>[] groups() default {}; 
    
    Class<? extends Payload>[] payload() default {};    
}
