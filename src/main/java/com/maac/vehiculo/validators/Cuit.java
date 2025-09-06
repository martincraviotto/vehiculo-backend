package com.maac.vehiculo.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CUITValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface  Cuit {
    String message() default "Numero de Cuit Invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
