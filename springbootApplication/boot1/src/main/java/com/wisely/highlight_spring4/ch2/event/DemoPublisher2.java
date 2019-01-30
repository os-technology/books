package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoPublisher2
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/16上午8:31
 */

@Component
public class DemoPublisher2 implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;

    }
    public void publish(String msg) {
        applicationEventPublisher.publishEvent(new DemoEvent(this,msg));
    }
}
