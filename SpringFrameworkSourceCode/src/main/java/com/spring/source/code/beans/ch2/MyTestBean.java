package com.spring.source.code.beans.ch2;

/**
 * @author yuijnshui
 * @Title: MyTestBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/14下午9:17
 */
public class MyTestBean {

    private String str;
    private BeanAttr beanAttr;

    public String getStr() {
        return str;
    }

    public MyTestBean setStr(String str) {
        this.str = str;
        return this;
    }

    public BeanAttr getBeanAttr() {
        return beanAttr;
    }

    public MyTestBean setBeanAttr(BeanAttr beanAttr) {
        this.beanAttr = beanAttr;
        return this;
    }
}
