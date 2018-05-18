package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationEventPublisher;
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

        //采用两种不同的实现方式进行消息发布
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("发布事件1");
        DemoPublisher2 demoPublisher2 = context.getBean(DemoPublisher2.class);
        demoPublisher2.publish("发布事件2");
        context.close();
    }
}
