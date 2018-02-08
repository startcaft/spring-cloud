package com.startcaft.springcloud;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/8 21:34
 */
public class MyHttpRequest implements HttpRequest {

    private HttpRequest sourceRequest;

    public MyHttpRequest(HttpRequest sourceRequest) {
        this.sourceRequest = sourceRequest;
    }

    @Override
    public HttpMethod getMethod() {
        return sourceRequest.getMethod();
    }

    @Override
    public URI getURI() {
        try {
            // Spring 在处理时，也是一样的处理，只不过是用 Ribbon API 来处理的。
            URI uri = new URI("http://localhost:8080/hello");
            return uri;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return sourceRequest.getURI();
    }

    @Override
    public HttpHeaders getHeaders() {
        return sourceRequest.getHeaders();
    }
}
