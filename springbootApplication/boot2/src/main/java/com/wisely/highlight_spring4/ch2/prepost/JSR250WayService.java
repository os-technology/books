package com.wisely.highlight_spring4.ch2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: JSR250WayService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15上午11:16
 */

public class JSR250WayService {

    @PostConstruct //在构造函数执行完之后执行
    public void init() {
        System.out.println("JSR250-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("初始化构造函数 - JSR250WayService");
    }

    @PreDestroy //在Bean销毁之前执行
    public void destroy() {
        System.out.println("JSR250-destroy-method");
    }
}
