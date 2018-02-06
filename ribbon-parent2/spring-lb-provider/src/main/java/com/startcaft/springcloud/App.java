package com.startcaft.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/6 22:16
 */
@SpringBootApplication
@EnableEurekaClient
public class App {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();

        new SpringApplicationBuilder(App.class).properties("server.port=" + port).run(args);
    }
}
