package com.example.poc.resttemplate.config;

import com.example.poc.resttemplate.exception.RestTemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @author qinfeng
 * @date 2020/1/7
 */
@Slf4j
public class HttpErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return true;
    }

//    @Override
//    public boolean hasError(ClientHttpResponse response) throws IOException {
//        int rawStatusCode = response.getRawStatusCode();
//        HttpStatus statusCode = HttpStatus.resolve(rawStatusCode);
//        return (statusCode != null ? hasError(statusCode) : hasError(rawStatusCode));
//    }

    protected boolean hasError(HttpStatus statusCode) {
        return statusCode.isError();
    }

    protected boolean hasError(int unknownStatusCode) {
        HttpStatus.Series series = HttpStatus.Series.resolve(unknownStatusCode);
        return (series == HttpStatus.Series.CLIENT_ERROR || series == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.error("=============>handleError:{}<=============", response);
        if(response.getStatusCode().is4xxClientError()){
            throw new RestTemplateException("400啦！！！");
        }else if (response.getStatusCode().is5xxServerError()){
            throw new RestTemplateException("500啦！！！");
        }
    }
}
