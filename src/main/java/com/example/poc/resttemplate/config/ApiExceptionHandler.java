package com.example.poc.resttemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler
    public String ApiExceptionHandler(Exception e) {
        log.error("api call error:{}", e);
        return "error";
    }


}
