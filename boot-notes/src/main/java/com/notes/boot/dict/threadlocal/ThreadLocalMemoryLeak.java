package com.notes.boot.dict.threadlocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author code
 * @Title: ThreadLocalMemoryLeak
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/245:52 PM
 */
public class ThreadLocalMemoryLeak<T> {
    private static final int TASK_LOOP_SIZE = 100;
    /**
     * 线程池
     */
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());


    static class LocalVariable {
        private byte[] a = new byte[1024 * 1024 * 5];//5M大小的数组
    }

    ThreadLocal<LocalVariable> localVariable;

    public static void main(String[] args) {
        for (int i = 0; i < TASK_LOOP_SIZE; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //创建5M 大小的内存占用
//                    LocalVariable localVariable = new LocalVariable();
//                     //通过ThreadLocal方式创建5M大小的内存占用
                    ThreadLocalMemoryLeak oom = new ThreadLocalMemoryLeak();
                    oom.localVariable = new ThreadLocal<>();
                    oom.localVariable.set(new LocalVariable());
//                  //当ThreadLocal实例不再使用，可以通过remove方法进行移除，以保证内存不会泄露
                    oom.localVariable.remove();

                    System.out.println("use local variable");
                }
            });
        }
    }
}
