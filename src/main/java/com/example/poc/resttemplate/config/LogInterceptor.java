package com.example.poc.resttemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Slf4j
public class LogInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("=========>goto LogInterceptor:<============");
        log.info("request:{}", request);
        log.info("body:{}", body);
        return execution.execute(request, body);
    }
}

