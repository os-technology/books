package com.notes.boot.dict.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义ThreadLocal类
 *
 * @author code
 * @Title: MyThreadLocal
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/243:02 PM
 */
public class MyThreadLocal<T> {
    //存放变量副本的map容器以Thread为键，变量副本为value
    private Map<Thread, T> threadMap = new HashMap<>();

    /**
     * 会存在线程安全问题，所以可以加锁(synchronized),或者使用ConcurrentHashMap方式进行处理
     * 带来的问题：
     * 1. synchronized会导致并发的性能问题，多线程同时访问的情况下，会出现阻塞
     *
     * @return
     */
    public synchronized T get() {
        return threadMap.get(Thread.currentThread());
    }

    /**
     * 会存在线程安全问题，所以可以加锁(synchronized),或者使用ConcurrentHashMap方式进行处理
     *
     * @param t
     */
    public synchronized void set(T t) {
        threadMap.put(Thread.currentThread(), t);
    }
}
