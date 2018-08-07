package com.spring.source.code.beans.ch3.annotation_definition;

/**
 * 自定义注解使用类
 *
 * @author code
 * @Title: AnnotationDefinitionBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/8/2上午10:04
 */
public class AnnotationDefinitionBean {

    private String name;

    private String define;

    public String getName() {
        return name;
    }

    public AnnotationDefinitionBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getDefine() {
        return define;
    }

    public AnnotationDefinitionBean setDefine(String define) {
        this.define = define;
        return this;
    }
}
