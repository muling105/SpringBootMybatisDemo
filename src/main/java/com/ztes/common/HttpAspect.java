package com.ztes.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP切面
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.ztes.controller.UserController.*(..))")
    public void log(){}


    @Before("log()")
    public void before(JoinPoint joinPoint){
        logger.info("-----------------before-------------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //URL
        logger.info("URL = {}", request.getRequestURI());

        //方法
        logger.info("Method = {}", request.getMethod());

        //IP
        logger.info("IP = {}", request.getRemoteAddr());

        //类名 + 方法
        logger.info("Class-Method = {}", joinPoint.getSignature().getDeclaringTypeName() + "."
                    + joinPoint.getSignature().getName());

        //参数
        logger.info("args = {}", joinPoint.getArgs());
    }

    @After("log()")
    public void after(){
        logger.info("+++++++++++++++++++after+++++++++++++++++++++");
    }

    @AfterReturning(pointcut = "log()", returning = "obj")
    public void afterRuning(Object obj){
        logger.info("response = {}", obj);//方法运行后返回的参数
    }

}
