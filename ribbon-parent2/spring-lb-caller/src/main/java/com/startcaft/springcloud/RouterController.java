package com.startcaft.springcloud;

import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Service;
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


    @Autowired
    private LoadBalancerClient client;

    @RequestMapping("/lb")
    public ServiceInstance lb(){
        ServiceInstance serviceInstance = client.choose("server-lb-provider");
        return serviceInstance;
    }

    @Autowired
    private SpringClientFactory factory;

    @RequestMapping("/factory")
    public String factory(){
        // 获取默认的 负载均衡器
        ZoneAwareLoadBalancer loadBalancer = (ZoneAwareLoadBalancer) factory.getLoadBalancer("server-lb-provider");
        return "默认策略:" +  loadBalancer.getRule().getClass().getName();
    }
}
