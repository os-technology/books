package com.wisely.highlight_spring4.ch3.c3_taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 3.3 从Spring 3.1开始， 计划任务在Spring中的实现变得异常
 * 的简单。 首先通过在配置类注解`@EnableScheduling`来开启对
 * 计划任务的支持， 然后在要执行计划任务的方法上注解@Scheduled，
 * 声明这是一个计划任务。
 * Spring通过@Scheduled支持多种类型的计划任
 * 务， 包含cron、 fixDelay、 fixRate等
 *
 * @author yuijnshui@lxfintech.com
 * @Title: SchedulerMain
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17上午9:47
 */

public class SchedulerMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfig.class);
        SchedulerTaskService schedulerTaskService = context.getBean(SchedulerTaskService.class);

    }
}
