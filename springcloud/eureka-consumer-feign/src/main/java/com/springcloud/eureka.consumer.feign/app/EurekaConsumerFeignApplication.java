package com.springcloud.eureka.consumer.feign.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ClientApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/16下午5:47
 */
//参考链接：http://blog.didispace.com/spring-cloud-starter-dalston-2-1/
//通过@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能
@EnableFeignClients(basePackages = "com.springcloud.eureka.consumer.feign")
@EnableDiscoveryClient//用来将当前应用加入到服务治理体系中。
@SpringBootApplication
@ComponentScan(basePackages = "com.springcloud.eureka.consumer")
public class EurekaConsumerFeignApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(
                EurekaConsumerFeignApplication.class)
                .web(true).run(args);
    }
}
