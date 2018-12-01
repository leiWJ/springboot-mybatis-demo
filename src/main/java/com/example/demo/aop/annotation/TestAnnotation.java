package com.example.demo.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author wen
 * @Date 2018/11/13 11:20
 * @Description: 定义注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestAnnotation {
    String value() default "";
}
