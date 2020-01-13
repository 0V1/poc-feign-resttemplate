package com.example.poc.resttemplate.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Slf4j
@RestController
public class TestApi {

    private RestTemplate restTemplate;

    @Autowired
    public TestApi(RestTemplate myRestTemplate) {
        this.restTemplate = myRestTemplate;
    }

    @GetMapping("/start")
    public String start() {
        // 此处的uriVariables 只有url 包含参数类型的则会组合进去，如果不是，则uriVariables将被舍弃，可以利用这一特点，进行切面处理
        String templateForObject = restTemplate.getForObject("http://127.0.0.1:8080/end", String.class,"test");
        log.info("{}", templateForObject);
        return templateForObject;
    }

    @GetMapping("/end")
    public String end() throws Exception {
        throw new RuntimeException("mock exception");
//        return "end";
    }

}
