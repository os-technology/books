package com.springcloud;

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
//@EnableDiscoveryClient
////如果不指定scanBasePackages位置，则无法正常找到服务
////参考链接：https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-structuring-your-code
//@ComponentScan
////此处可以不需要指定scanBasePackages位置即可正常访问controller层。scanBasePackages不能为空字符串
//@SpringBootApplication
public class ClientApplication1 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(
                ClientApplication1.class)
                .web(true).run(args);
    }
}
