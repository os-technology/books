package com.thread.tutorial.start.github.one;

/**
 * https://blog.csdn.net/qq_34337272/article/details/79640870
 *
 * @author code
 * @Title: MyThread
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/2/21下午6:31
 */
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    public MyThread() {
        super();

    }

    @Override
    public void run() {
        super.run();

        while (count > 0) {
            count--;
            System.out.println("线程" + MyThread.currentThread().getName() + ":count=" + count);
        }
    }

    public static void main(String[] args) {
//        noSharedData();
        sharedData();
    }

    /**
     * 不共享数据的情况
     */
    private static void noSharedData() {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");

        a.start();
        b.start();
        c.start();
    }

    private static void sharedData() {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        a.start();
        b.start();
        c.start();
        //可能的执行结果(线程会一直执行到符合条件为止)
        //线程B:count=3
        //线程A:count=3
        //线程C:count=2
        //线程A:count=0
        //线程B:count=1
    }
}
