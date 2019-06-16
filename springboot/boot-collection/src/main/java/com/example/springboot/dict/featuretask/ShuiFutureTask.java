package com.example.springboot.dict.featuretask;


import java.util.concurrent.*;

/**自定义futureTask
 *
 * 主要两步内容
 * 1. 提供用于执行callable内容中call方法的方法
 * 2. 提供阻塞，用于取值
 * @author code
 * @Title: ShuiFutureTask
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/166:19 PM
 */
public class ShuiFutureTask<V> implements Runnable, Future<V> {


    Callable<V> callable;

    public ShuiFutureTask(Callable<V> callable){
        this.callable = callable;
    }

    @Override
    public void run() {

        try {
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public V get() throws InterruptedException, ExecutionException {
        return null;
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
