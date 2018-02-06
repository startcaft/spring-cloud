package com.startcaft.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/6 22:29
 */
@SpringBootApplication
@EnableEurekaClient
public class App {

    public static void main(String[] args){

        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
