package com.startcaft.springcloud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaServer
public class App {
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        String profile = scanner.nextLine();

        new SpringApplicationBuilder(App.class).profiles(profile).run(args);
    }
}
