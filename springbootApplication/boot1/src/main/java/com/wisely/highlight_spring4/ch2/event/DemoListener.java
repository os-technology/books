package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 *
 * @author yuijnshui@lxfintech.com
 * @Title: DemoListener
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15下午9:46
 */

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {

        String msg = event.getMsg();
        System.out.println("我(bean-demoListener)接收了bean-demoPublisher发布的消息：" + msg);
    }
}
