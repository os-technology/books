package com.code.junit.mock.boot.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author code
 * @Title: JunitMockApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:53
 */
@SpringBootApplication
//开启事务用的注解
//@EnableTransactionManagement
//@MapperScan("com.code.junit.mock.boot.dict.dao")//扫描的是mapper.xml中namespace指向值的包位置
@ComponentScan("com.code.junit.mock.boot")
@ImportResource({"classpath:spring-mvc.xml",
        "classpath:application-bean.xml"})
public class JunitMockApplication {

    public static void main(String[] args) {
//        SpringApplication.run(JunitMockApplication.class,args);
//新版web判断写法
        new SpringApplicationBuilder(JunitMockApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
