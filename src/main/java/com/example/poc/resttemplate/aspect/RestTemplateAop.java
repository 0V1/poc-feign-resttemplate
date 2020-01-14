package com.example.poc.resttemplate.aspect;

import com.example.poc.resttemplate.exception.RestTemplateException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @author qinfeng
 * @date 2020/1/13
 */
@Slf4j
@Aspect
@Component
public class RestTemplateAop {

    @Pointcut(value = "execution(public * org.springframework.web.client.RestTemplate.getFor*(*,*,Object...))")
    public void getForPointcut() {

    }

    @Pointcut(value = "execution(public * org.springframework.web.client.RestTemplate.postFor*(*,*,*,Object...))")
    public void postForPointcut() {

    }

    @Around(value = "getForPointcut() || postForPointcut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        log.info("===================RestTemplateAop.log=================");
        return pjp.proceed();
    }

}
