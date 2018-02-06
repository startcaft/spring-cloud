package com.startcaft.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/6 22:32
 */
@RestController
public class RouterController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "router",method = RequestMethod.GET)
    public String router(){
        String result = this.restTemplate.getForObject("http://server-lb-provider/get/"
                + new Random().nextInt(),String.class);
        return result;
    }

}
