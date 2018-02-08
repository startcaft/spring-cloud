package com.startcaft.springcloud;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/8 16:09
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("这里是自定义拦截器");
        System.out.println("\t旧的请求:" + httpRequest.getURI());

        HttpRequest newRequest = new MyHttpRequest(httpRequest);
        System.out.println("\t新的请求:" + newRequest.getURI());

        return clientHttpRequestExecution.execute(newRequest,bytes);
    }
}
