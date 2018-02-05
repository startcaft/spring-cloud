package com.startcaft.springcloud;


import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pikai
 */
public class App {
    public static void main( String[] args ) throws Exception {
//        ConfigurationManager.getConfigInstance().setProperty(
//                "myClient.ribbon.listOfServers", "www.linkedin.com:80,www.google.com:80");
//        RestClient client = (RestClient) ClientFactory.getNamedClient("myClient");
//        HttpRequest request = HttpRequest.newBuilder().setUri(new URI("/person")).build();
//        for (int i = 0; i < 10; i++)  {
//            HttpResponse response = client.executeWithLoadBalancer(request);
//            String json = response.getEntity(String.class);
//            System.out.println(json);
//        }

        // Ribbon 负载均衡的基本机制
        BaseLoadBalancer loadBalancer = new BaseLoadBalancer();

        // 设置服务器列表
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server("http://localhost",8080));
        serverList.add(new Server("http://localhost",8081));
        loadBalancer.addServers(serverList);

        // 负载均衡策略
        IRule rule = new RoundRobinRule();
        loadBalancer.setRule(rule);

        for (int i=0;i<20;i++){
            Server currentServer = loadBalancer.chooseServer();
            System.out.println(currentServer.getHost() + ":" + currentServer.getPort());
        }
    }
}
