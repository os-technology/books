package com.wisely.highlight_spring4.ch3.c7_fortest;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: TestBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/18上午10:12
 */

public class TestBean {

    public TestBean(String content) {
        super();
        this.content = content;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public TestBean setContent(String content) {
        this.content = content;
        return this;
    }
}
