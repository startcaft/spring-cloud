package com.startcaft.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientServerCallerSomeoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientServerCallerSomeoneApplication.class, args);
	}
}
