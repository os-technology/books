package com.springcloud.eureka.consumer.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ClientApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/16下午5:47
 */
//参考链接：http://blog.didispace.com/spring-cloud-starter-dalston-2-1/

@EnableDiscoveryClient//用来将当前应用加入到服务治理体系中。
@SpringBootApplication
@ComponentScan(basePackages = "com.springcloud.eureka.consumer")
public class EurekaConsumerApplication {

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
                EurekaConsumerApplication.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}
