package com.wisely.highlight_spring4.ch3.c4_conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ConditionMain
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17下午3:27
 */

public class ConditionMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService listService = context.getBean(ListService.class);

        listService.showListCmd();
        System.out.println(context.getEnvironment().getProperty("os.name")+"系统下的命令为："+listService.showListCmd());
        context.close();
    }
}
