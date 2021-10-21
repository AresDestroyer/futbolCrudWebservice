package com.babel.eduardo.validador;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DtoValidator.class)
@Documented
public @interface CheckDto {

    String message() default "Hay datos incorrectos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}