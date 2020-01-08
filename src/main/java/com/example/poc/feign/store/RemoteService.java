package com.example.poc.feign.store;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qinfeng
 * @date 2020/1/8
 */
@FeignClient(name = "remoteService", url = "http://127.0.0.1:8080")
public interface RemoteService {


    @GetMapping("/remote")
    String end();
}
