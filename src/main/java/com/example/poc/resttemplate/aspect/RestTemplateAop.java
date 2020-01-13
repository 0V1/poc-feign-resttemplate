package com.example.poc.resttemplate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qinfeng
 * @date 2020/1/13
 */
@Aspect
@Component
public class RestTemplateAop {

    @Pointcut(value = "execution(public * org.springframework.web.client.RestTemplate.getFor*(String,Class,Object,..))")
    public void getForPointcut() {

    }

    @Pointcut(value = "execution(public * org.springframework.web.client.RestTemplate.postFor*(String,Object,Class,Object,..))")
    public void postForPointcut() {

    }

    @Around(value = "getForPointcut() || postForPointcut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {

        return pjp.proceed();
    }

}
