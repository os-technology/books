package com.wisely.highlight_spring4.ch3.c3_taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SchedulerTaskService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17上午9:45
 */
@Service
public class SchedulerTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)//通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行。
    public void exeScheduler(){
        System.out.println("SchedulerTaskService is ok - "+dateFormat.format(new Date()));
    }

    //使用cron属性可按照指定时间执行， 本例指的
    //是每天9点56分执行； cron是UNIX和类
    //UNIX（ Linux） 系统下的定时任务
    @Scheduled(cron = "0 56 9 * * ?")
    public void exeCron(){
        System.out.println("指定时间执行："+dateFormat.format(new Date()));
    }
}
