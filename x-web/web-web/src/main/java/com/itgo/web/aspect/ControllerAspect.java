package com.itgo.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by xb
 * The file is [ ControllerAspect] on [ x-file-system ] project
 * The file path is com.itgo.web.aspect.ControllerAspect
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/9 19:39
 * @description
 */
@Aspect
@Component
public class ControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);


    @Pointcut("execution(* com.itgo.web.controller..*.*(..))")
    public void excudeService() {}

    @Before("excudeService()")
    public void doBefore(JoinPoint joinPoint){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        logger.info("执行切面，请求的URL是:"+request.getRequestURI());
    }
}
