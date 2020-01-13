package com.example.poc.resttemplate.config;

import com.example.poc.resttemplate.exception.RestTemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler
    public String ApiExceptionHandler(RestTemplateException e) {
        log.error("api call error:{}", e.getMessage());
        return e.getMessage();
    }


}
