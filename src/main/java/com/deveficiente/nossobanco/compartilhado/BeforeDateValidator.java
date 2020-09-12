package com.deveficiente.nossobanco.compartilhado;

import org.aspectj.lang.annotation.Before;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class BeforeDateValidator implements ConstraintValidator<BeforeDate, Object> {

    @Override
    public void initialize(Annotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}
