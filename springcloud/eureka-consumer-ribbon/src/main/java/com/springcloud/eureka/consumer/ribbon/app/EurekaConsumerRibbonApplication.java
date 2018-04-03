package com.springcloud.eureka.consumer.ribbon.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: EurekaConsumerRibbonApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/2下午4:21
 */
@EnableDiscoveryClient//用来将当前应用加入到服务治理体系中。
@SpringBootApplication
@ComponentScan(basePackages = "com.springcloud.eureka.consumer.ribbon")
public class EurekaConsumerRibbonApplication {
    /**
     * 初始化RestTemplate，用来真正发起REST请求。
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(
                EurekaConsumerRibbonApplication.class)
                .web(true).run(args);
    }
}
