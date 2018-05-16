package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: EventMain
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/16上午8:03
 */

public class EventMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventConfig.class);
        context.refresh();

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("发布事件1");

        context.close();
    }
}
