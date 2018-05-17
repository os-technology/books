package com.wisely.highlight_spring4.ch3.c3_taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SchedulerConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17上午9:47
 */
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch3.c3_taskscheduler")
@EnableScheduling//开启对计划任务的支持
public class SchedulerConfig {

}
