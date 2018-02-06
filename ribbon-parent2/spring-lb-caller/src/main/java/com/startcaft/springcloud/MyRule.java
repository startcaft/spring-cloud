package com.startcaft.springcloud;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.sun.org.apache.bcel.internal.generic.ILOAD;

import java.util.List;
import java.util.Random;

/**
 * @Author: pikai
 * @Description: 自定义的负载均衡策略
 * @Date: Created in 2018/2/6 22:47
 */
public class MyRule implements IRule {

    private ILoadBalancer lb;


    @Override
    public Server choose(Object o) {
        System.out.println("这是自定义的负载均衡策略");
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        List<Server> serverList = lb.getAllServers();
        if(randomNumber > 7){
            Server server = this.getServerByPort(serverList,8888);
            return server;
        }
        return this.getServerByPort(serverList,9999);
    }

    private Server getServerByPort(List<Server> serverList, int port) {
        for(Server s :serverList){
            if(s.getPort() == port){
                return s;
            }
        }
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.lb = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.lb;
    }
}
