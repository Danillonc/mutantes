package br.com.labdna.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = BaseNitrogenadaValidator.class)
public @interface BaseNitrogenadaValida {

	String message() default "{adult}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
	
}