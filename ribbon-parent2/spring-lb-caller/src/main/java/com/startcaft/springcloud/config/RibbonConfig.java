package com.startcaft.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.startcaft.springcloud.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/6 22:59
 */
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        MyRule myRule = new MyRule();
        return myRule;
    }
}
