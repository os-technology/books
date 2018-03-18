package com.springcloud.eureka.client.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ClientApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/16下午5:47
 */
@EnableDiscoveryClient
@ComponentScan(basePackages="com.springcloud.eureka.client")
//需要制定对应的BasePackages位置，否则无法正常找到服务
//参考链接：https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-structuring-your-code
@SpringBootApplication//(scanBasePackages = "com.springcloud.eureka.client")
public class ClientApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(
                ClientApplication.class)
                .web(true).run(args);
    }
}
