package com.springcloud.eureka.server.app;

import org.springframework.boot.WebApplicationType;
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
public class EurekaServerApplication {
//搭建资料参考：http://blog.didispace.com/spring-cloud-starter-dalston-1/


    public static void main(String[] args) {
//        SpringApplication.run(EurekaServerApplication.class, args);
        new SpringApplicationBuilder(EurekaServerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}

