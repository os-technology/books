package com.springcloud.eureka.upload.server.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: EurekaFeignUploadServerApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/9上午7:42
 */

@EnableFeignClients(basePackages = "com.springcloud.eureka.upload.server")
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.springcloud.eureka.upload.server")
public class EurekaFeignUploadServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaFeignUploadServerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
