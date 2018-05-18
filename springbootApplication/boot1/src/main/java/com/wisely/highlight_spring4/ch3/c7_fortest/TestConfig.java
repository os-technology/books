package com.wisely.highlight_spring4.ch3.c7_fortest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: TestConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/18上午10:40
 */
@Configuration
public class TestConfig {

    @Bean
    @Profile("dev")
    public TestBean getDevTetBean(){
        return new TestBean("from dev profile");
    }

    @Bean
    @Profile("prod")
    public TestBean getProdTetBean(){
        return new TestBean("from prod profile");
    }
}
