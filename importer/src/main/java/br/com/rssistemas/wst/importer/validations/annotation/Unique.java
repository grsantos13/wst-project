package br.com.rssistemas.wst.importer.validations.annotation;

import br.com.rssistemas.wst.importer.validations.validator.UniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String message() default "{br.com.rssistemas.wstmain.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();
    Class<?> domainClass();

}
