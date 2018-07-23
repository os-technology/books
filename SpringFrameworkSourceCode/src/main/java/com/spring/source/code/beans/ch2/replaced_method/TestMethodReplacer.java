package com.spring.source.code.beans.ch2.replaced_method;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author yuijnshui
 * @Title: TestMethodReplacer
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/23下午6:05
 */
public class TestMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("TestMethodReplacer class：替换原有方法");
        return args[0]+" is ok";
    }
}
