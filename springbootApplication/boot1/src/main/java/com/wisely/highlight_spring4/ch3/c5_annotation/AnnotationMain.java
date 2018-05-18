package com.wisely.highlight_spring4.ch3.c5_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: AnnotationMain
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/17下午5:07
 */

public class AnnotationMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        DemoService demoService = context.getBean(DemoService.class);

        demoService.outputResult();

        context.close();
    }
}
