package com.example.poc.resttemplate.config;

import com.example.poc.resttemplate.exception.RestTemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Slf4j
@Order(2)
@Component
public class LogInterceptor implements ClientHttpRequestInterceptor {


    /**
     * Retryable
     * value: 遇到指定异常触发retry
     * maxAttempts: 最大retry次数
     * backoff: 延迟
     * delay: 延迟时间
     * multiplier: 延迟时间变化系数   第一次retry间隔2s  第二次间隔2s*1.5=3s  第三次间隔3s*1.5=4.5s
     *
     * @param request
     * @param body
     * @param execution
     * @return
     * @throws IOException
     */
    @Retryable(value = RestTemplateException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("=========>goto LogInterceptor:<============");
        log.info("request:{}", request);
        log.info("body:{}", body);
        ClientHttpResponse clientHttpResponse = execution.execute(request, body);
        if (clientHttpResponse.getStatusCode().is4xxClientError()) {
            throw new RestTemplateException("4xx");
        }
        log.info("response.headers:{}", clientHttpResponse.getHeaders());
        log.info("response.body:{}", clientHttpResponse.getBody());
        return clientHttpResponse;
    }
}

