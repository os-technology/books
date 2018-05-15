package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ProfileConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15下午5:23
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")//Profile为dev时实例化devDemoBean。
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod")//Profile为prod时实例化prodDemoBean
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }

}
