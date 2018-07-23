package com.spring.source.code.beans.ch2.lookup_method;

/**
 * @author yuijnshui
 * @Title: GetBeanTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/23下午4:24
 */
public abstract class GetBeanTest {

    public void showMe(){
        this.getBean().showMe();
    }

    public abstract SpringUser getBean();
}
