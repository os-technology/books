package com.springcloud.eureka.client.consul.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * http://blog.didispace.com/spring-cloud-starter-dalston-1/#Spring-Cloud-Consul
 *
 * @author yuijnshui@lxfintech.com
 * @Title: ConsulApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/20下午5:45
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.springcloud.eureka.client.consul")
//参考链接：https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-structuring-your-code
public class ConsulClientApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(
                ConsulClientApplication.class)
                .web(true).run(args);
    }
}
