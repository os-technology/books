package com.notes.boot.dict.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author code
 * @Title: LisonCompany
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/47:51 PM
 */
public class LisonCompany implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object factory;

    public Object getFactory() {
        return factory;
    }

    public LisonCompany setFactory(Object factory) {
        this.factory = factory;
        return this;
    }

    //通过动态代理对象对方法进行增强
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSthBefore();
        Object result = method.invoke(factory, args);
        doSthEnd();
        return result;
    }

    private void doSthEnd() {
        System.out.println("根据您的需求，进行相应的市场调研和需求确认");
    }

    private void doSthBefore() {
        System.out.println("精美包装一条龙服务");
    }

    //通过proxy获取动态代理的对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), this);
    }
}
