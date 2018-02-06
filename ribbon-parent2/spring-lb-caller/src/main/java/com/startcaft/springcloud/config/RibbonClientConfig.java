package com.startcaft.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/6 23:01
 */
@RibbonClient(name="server-lb-provider",configuration = RibbonConfig.class)
public class RibbonClientConfig {
}
