package br.com.rssistemas.wst.user.validations.annotation;


import br.com.rssistemas.wst.user.validations.validator.ExistsResourceValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = ExistsResourceValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsResource {

    String message() default "{br.com.rssistemas.wstmain.existsResource}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();
    Class<?> domainClass();
}