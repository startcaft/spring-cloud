package com.startcaft.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/router")
    public String router(){
        String result =
                this.restTemplate.getForObject("http://POLICESTATION1/police/get",String.class);
        return result;
    }
}
