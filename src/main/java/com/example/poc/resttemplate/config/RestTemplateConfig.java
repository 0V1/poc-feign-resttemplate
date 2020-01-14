package com.example.poc.resttemplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Configuration
public class RestTemplateConfig {

    @Autowired
    private LogInterceptor logInterceptor;

    @Autowired
    private ResponseInterceptor responseInterceptor;

    @Bean(name = "myRestTemplate")
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .additionalInterceptors(Arrays.asList(responseInterceptor, logInterceptor))
                .errorHandler(new HttpErrorHandler())
                .build();
        return restTemplate;
    }
}
