package com.spring.source.code.beans.ch3.alias_bean;

import com.spring.source.code.beans.ch2.BeanAttr;

/**
 * alias 标签进行解析
 * @author yuijnshui
 * @Title: MyTestBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/14下午9:17
 */
public class AliasBean {

    private String str;

    public String getStr() {
        return str;
    }

    public AliasBean setStr(String str) {
        this.str = str;
        return this;
    }

}
