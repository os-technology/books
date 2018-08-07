package com.spring.source.code.beans.ch2;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author code
 * @Title: MyTestBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/14下午9:17
 */
public class MyTestBeanFactoryBean implements FactoryBean {

    private String str;
    private BeanAttr beanAttr;

    public String getStr() {
        return str;
    }

    public MyTestBeanFactoryBean setStr(String str) {
        this.str = str;
        return this;
    }

    public BeanAttr getBeanAttr() {
        return beanAttr;
    }

    public MyTestBeanFactoryBean setBeanAttr(BeanAttr beanAttr) {
        this.beanAttr = beanAttr;
        return this;
    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
