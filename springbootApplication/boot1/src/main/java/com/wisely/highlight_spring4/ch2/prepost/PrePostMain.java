package com.wisely.highlight_spring4.ch2.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: PrePostMain
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15上午11:47
 */

public class PrePostMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);

        JSR250WayService jsr250 = context.getBean(JSR250WayService.class);
        context.close();
    }

}
