package com.spring.source.code.beans.ch2.constructor_arg;

import com.log.LogPortal;

/**
 * @author yuijnshui
 * @Title: ConstructorBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/24下午4:32
 */
public class ConstructorBean {

    public ConstructorBean(String value,String index){
        LogPortal.info("ConstructorBean日志测试",value);
        System.out.println("xml获取的值："+value+"  "+index);
    }

    public ConstructorBean(String value){
        System.out.println("xml获取的单参数值："+value);
    }
}
