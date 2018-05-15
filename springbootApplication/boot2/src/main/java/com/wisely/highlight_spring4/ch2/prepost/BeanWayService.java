package com.wisely.highlight_spring4.ch2.prepost;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: BeanWayService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15上午11:13
 */

public class BeanWayService {

    public void init(){
        System.out.println("BeanWayService - @Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("BeanWayService-初始化构造函数");
    }

    public void executeDestroy(){
        System.out.println("BeanWayService - @Bean-destroy-method");
    }

}
