package com.example.demo.base.core.constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author wen
 * @Date 2018/11/24 17:36
 * @Description
 **/
public class NotEqualValidator implements ConstraintValidator<NotEqual, String> {

    private String value;

    @Override
    public void initialize(NotEqual constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !s.equals(value);
    }
}

