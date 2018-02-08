package com.startcaft.springcloud;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/8 15:49
 */
@Configuration
public class MyConfig {

    /**
     * 使用 @MyLoadBalanced 注解修饰的所有 RestTemplate 的类的Bean，都会加载到 tpls 集合中。
     */
    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> tpls = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton lbInitializing(){
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for(RestTemplate tp : tpls){
                    List<ClientHttpRequestInterceptor> interceptors = tp.getInterceptors();

                    interceptors.add(new MyInterceptor());

                    tp.setInterceptors(interceptors);
                }
            }
        };
    }
}
