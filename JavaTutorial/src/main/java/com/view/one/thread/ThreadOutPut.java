package com.view.one.thread;

/**
 * 1-100，两个线程交替按顺序输出
 *
 * @author code
 * @Title: ThreadOutPut
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/119:35 PM
 */
public class ThreadOutPut extends Thread {

    private volatile boolean flag = false;
    public static Object obj = new Object();

    ThreadOutPut unNumber() {
        return new ThreadOutPut() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("unNumber-" + Thread.currentThread().getId());
                    for (int i = 1; i < 100; i += 2) {

                        while (flag) {//1.  false,跳出循环，直接打印
                            try {
                                System.out.println("奇数 - "+Thread.currentThread().getId());
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i);
                        obj.notifyAll();
                        flag = true;//2.  本次打印完成后，更改flag标志位。此时，本线程再次循环，则进入wait状态。
                    }
                }
            }
        };
    }

    ThreadOutPut evenNumber() {
        return new ThreadOutPut() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("evenNumber-" + Thread.currentThread().getId());
                    for (int i = 2; i < 101; i += 2) {
                        //3. 初始时，由于flag=false，此线程为wait状态。
                        // 当flag=true，执行了notifyall之后，while循环重新继续，此时，!flag=false，跳过循环
                        while (!flag) {
                            try {
                                System.out.println("偶数 - "+Thread.currentThread().getId());
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        obj.notifyAll();
                        System.out.println(i);
                        flag = false;
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        ThreadOutPut t1 = new ThreadOutPut();

        t1.evenNumber().start();
        t1.unNumber().start();
    }
}
