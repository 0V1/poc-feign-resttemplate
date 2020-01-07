package com.example.poc.resttemplate.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Configuration
public class RestTemplateConfig {

    @Bean(name = "myRestTemplate")
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder){
        RestTemplate restTemplate = restTemplateBuilder.additionalInterceptors(new LogInterceptor())
                .additionalInterceptors(new ResponseInterceptor())
                .errorHandler(new HttpErrorHandler())
                .build();
        return restTemplate;
    }
}
