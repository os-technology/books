package com.notes.boot.dict.threadlocal;

/**
 * 演示自定义 MyThreadLocal 的使用
 *
 * @author code
 * @Title: UseThreadLocal
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/222:59 PM
 */
public class MyThreadLocalUse {
    static MyThreadLocal<Integer> threadLocal = new MyThreadLocal<>();

    /**
     * 启动三个线程
     */
    public void startThreadArray() {
        Thread[] runs = new Thread[3];

        for (int i = 0; i < 3; i++) {
            runs[i] = new Thread(new TestThead(i));
        }
        for (int i = 0; i < 3; i++) {
            runs[i].start();
        }
    }

    /**
     * 类说明：打印出赋予的id值，应该是0，1，2
     */
    public static class TestThead implements Runnable {

        int id;

        public TestThead(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            threadLocal.set(id);
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyThreadLocalUse local  = new MyThreadLocalUse();

        local.startThreadArray();
    }
}
