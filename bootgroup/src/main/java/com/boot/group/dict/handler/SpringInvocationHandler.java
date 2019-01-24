package com.boot.group.dict.handler;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author code
 * @Title: SpringInvocationHandler
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/24下午2:04
 */
public class SpringInvocationHandler implements MethodInterceptor {

    private Object target;

    public SpringInvocationHandler(Object target){
        this.target = target;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        if (method.getName().startsWith("test")) {
            System.out.println("我被cglib代理了");
        }
        Object invoke = method.invoke(target, args);

        return invoke;
    }


    //定义获取代理对象方法
    public Object getCglibProxy(Object objectTarget){
        //为目标对象target赋值
//        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);// 设置回调
        Object result = enhancer.create();//创建并返回代理对象
        return result;
    }

    public Object getCglibProxy(){
        return getCglibProxy(target);
    }
}
