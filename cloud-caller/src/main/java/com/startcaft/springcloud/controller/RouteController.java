package com.startcaft.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class RouteController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/router")
    public String router(){
        String result = this.restTemplate.getForObject("http://cloud-police-station/police/get/"
                    + new Random().nextInt(),String.class);
        return result;
    }
}
