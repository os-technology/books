package com.code.junit.mock.boot.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@MapperScan("com.code.junit.mock.boot.dict.dao")//扫描的是mapper.xml中namespace指向值的包位置
@ComponentScan("com.code.junit.mock.boot")
public class JunitMockApplication {

    public static void main(String[] args) {
//        SpringApplication.run(JunitMockApplication.class,args);
        new SpringApplicationBuilder(JunitMockApplication.class).web(true).run(args);
    }
}
