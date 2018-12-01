package com.example.demo.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.aop.annotation.TestAnnotation;
import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Author wen
 * @Date 2018/11/15 14:06
 * @Description 切面处理类
 **/
@Order(2)
@Aspect   //定义一个切面
@Configuration
public class TestAspect {

    // 定义切点Pointcut
    //第一个注解：表示扫描的包或类， 第一个*可以写具体的类，第二个*是方法，括号里是传参
    //第二个注解表示定义的注解，  哪个方法需要切面，就在方法上加上 @TestAnnotation
    @Pointcut("execution(public * com.example.demo.controller.*.*(..)) && @annotation(com.example.demo.aop.annotation.TestAnnotation)")
    public void executeService() {
    }


    //执行方法之前，进入切面
    @Before(value = "executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
    }

    //在进去方法的同时，进入切面
    @Around("executeService()")
    public Object doAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletResponse response = sra.getResponse();
        HttpServletRequest request = sra.getRequest();
        String uri = request.getRequestURI();
        Object result = pjp.proceed();


        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
        if (testAnnotation != null) {
            //注解上的描述

        }
        //请求的方法名
        String className = pjp.getTarget().getClass().getName();
        String methodName = signature.getName();
        return result;
    }

    //在执行完方法后，进入切面，并返回方法的结果值，returning定义的参数必须和Object后的形参一致
    @AfterReturning(value = "executeService()", returning = "result")
    public void doAfterAdvice(JoinPoint joinPoint, Object result) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletResponse response = sra.getResponse();
        if (response.getStatus() == 200) {
            HttpServletRequest request = sra.getRequest();
            String uri = request.getRequestURI();
            HttpSession session = request.getSession(true);
            Gson gson = new Gson();
            JSONObject jsonObject = JSON.parseObject(gson.toJson(result));
        }
    }
}
