package com.example.spring.validation.demo.dto.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SignUpDtoCheckValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SignUpDtoCheck {

    String message() default "SignUpDtoCheck is invalid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
