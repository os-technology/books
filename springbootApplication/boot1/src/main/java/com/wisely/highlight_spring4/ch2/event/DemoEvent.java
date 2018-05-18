package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 *
 * @author yuijnshui@lxfintech.com
 * @Title: DemoEvent
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15下午9:42
 */

public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String msg;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public DemoEvent setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
