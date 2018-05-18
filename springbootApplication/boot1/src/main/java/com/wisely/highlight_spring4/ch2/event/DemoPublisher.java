package com.wisely.highlight_spring4.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 * @author yuijnshui@lxfintech.com
 * @Title: DemoPublisher
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15下午9:54
 */

@Component
public class DemoPublisher {

    @Autowired
    ApplicationContext applicationContext;//注入applicationContext用来发布事件

    public void publish(String msg) {
        //使用applicationContext的publishEvent方法来发布
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
