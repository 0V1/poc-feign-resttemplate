package com.example.poc.feign.api;

import com.example.poc.feign.store.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@RestController
public class TestFeignApi {

    private RemoteService remoteService;

    @Autowired
    public TestFeignApi(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @GetMapping("/feign/start")
    public String start() {
        return remoteService.end();
    }

    @GetMapping("/remote")
    public String end() {
        return "end";
    }

}
