package com.example.poc.resttemplate.exception;

import org.springframework.web.client.RestClientException;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
public class RestTemplateException extends RestClientException {


    public RestTemplateException(String message) {
        super(message);
    }

}
