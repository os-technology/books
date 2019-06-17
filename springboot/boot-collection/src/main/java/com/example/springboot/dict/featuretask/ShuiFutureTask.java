package com.example.springboot.dict.featuretask;


import java.util.concurrent.*;

/**
 * 自定义futureTask
 * <p>
 * 主要两步内容
 * 1. 提供用于执行callable内容中call方法的方法
 * 2. 提供阻塞，用于取值
 *
 * @author code
 * @Title: ShuiFutureTask
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/166:19 PM
 */
public class ShuiFutureTask<V> implements Runnable, Future<V> {


    Callable<V> callable;
    V result = null;

    public ShuiFutureTask(Callable<V> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {

        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果result获得值，那么就唤醒等待的线程，进入执行状态。此时，执行get(),就会获得结果值信息
        synchronized (this) {
            this.notifyAll();
        }
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        //result不为空，说明 callable.call() 调用完成，直接返回结果即可
        if (result != null) {
            return result;
        }
        System.out.println("尚未执行完成。。。进入等待状态");
        //此时，说明result没有值，callable.call() 尚未执行完成，那么就需要将此方法置为等待状态，保证r
        //callable.call() 可以执行完成
        synchronized (this) {
            this.wait();
        }
        return result;
    }


    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }


    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
