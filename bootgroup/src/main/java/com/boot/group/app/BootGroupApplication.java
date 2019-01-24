package com.boot.group.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author code
 * @Title: BootGroupApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/29上午11:37
 */
@SpringBootApplication
@ComponentScan("com.boot.group")
@EnableJpaRepositories("com.boot.group.dict.dao")
@ImportResource({"classpath:application-bean.xml","classpath:spring-mvc.xml"})
public class BootGroupApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BootGroupApplication.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}
