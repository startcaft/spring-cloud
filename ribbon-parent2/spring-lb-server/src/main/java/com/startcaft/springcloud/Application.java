package com.startcaft.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/6 22:07
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
