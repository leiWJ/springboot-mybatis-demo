package com.example.demo.base.core.constants;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/*自定义校验*/
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEqualValidator.class)
public @interface NotEqual {
    String message() default "不能与给定的值相等";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}

