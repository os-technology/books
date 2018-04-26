package com.springcloud.feign.upload.client.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: EurekaFeignUploadServerApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/9上午7:37
 */
@EnableFeignClients(basePackages = "com.springcloud.feign.upload.client")
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.springcloud.feign.upload.client")
public class EurekaFeignUploadClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignUploadClientApplication.class);
    }
}
