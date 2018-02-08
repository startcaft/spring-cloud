package com.startcaft.springcloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/8 15:59
 */
@RestController
@Configuration
public class MyController {

    @Bean
    @MyLoadBalanced
    RestTemplate templateA(){
        return new RestTemplate();
    }

    @GetMapping("/call")
    public String call(){
        RestTemplate tp = templateA();
        String json = tp.getForObject("http://hello-service/call",String.class);
        return json;
    }

    @GetMapping("/hello")
    public String hello(){
        return "new hello";
    }
}
