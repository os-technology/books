package com.springcloud.eureka.server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SpringcloudApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/12下午3:54
 */



@SpringBootApplication
@EnableEurekaServer
public class SpringcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplication.class, args);
    }

//    public static void main(String[] args) {
//        new SpringApplicationBuilder(SpringcloudApplication.class)
//                .web(true).run(args);
//    }
}

