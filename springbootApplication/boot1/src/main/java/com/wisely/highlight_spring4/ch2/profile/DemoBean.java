package com.wisely.highlight_spring4.ch2.profile;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: DemoBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15下午5:20
 */

public class DemoBean {

    private String content;

    public DemoBean(String content) {
        super();
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public DemoBean setContent(String content) {
        this.content = content;
        return this;
    }
}
