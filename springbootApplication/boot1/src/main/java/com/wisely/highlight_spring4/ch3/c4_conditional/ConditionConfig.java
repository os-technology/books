package com.wisely.highlight_spring4.ch3.c4_conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ConditionConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17下午3:24
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(MacCondition.class)//通过 @Conditional 注解，符合mac条件则实例化 MacListService
    public ListService macListService() {
        return new MacListService();
    }

    @Bean
    @Conditional(WindowCondition.class)//通过 @Conditional 注解，符合Windows条件则实例化 WindowsListService
    public ListService winListService() {
        return new WindowsListService();
    }
}