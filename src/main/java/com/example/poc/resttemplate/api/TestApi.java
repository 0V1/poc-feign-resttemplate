package com.example.poc.resttemplate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@RestController
public class TestApi {

    private RestTemplate restTemplate;

    @Autowired
    public TestApi(RestTemplate myRestTemplate) {
        this.restTemplate = myRestTemplate;
    }

    @GetMapping("/start")
    public String start() {
        return restTemplate.getForObject("http://127.0.0.1:8080/end", String.class);
    }

    @GetMapping("/end")
    public String end() throws Exception {
//        throw new Exception("mock exception");
        return "end";
    }

}
