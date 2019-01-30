package com.spring.boot.thymeleaf.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author code
 * @Title: ThymeleafApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/18下午2:22
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.spring.boot.thymeleaf")
public class ThymeleafApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ThymeleafApplication.class,args);

        new SpringApplicationBuilder(ThymeleafApplication.class)
                .web(true).run(args);
    }
}
