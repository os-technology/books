package com.view.arithmetic;

/**
 * 线程交替输出  1a 2b 3c 4d ..... 26z
 * @author code
 * @Title: Thread2
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/129:54 AM
 */
public class Thread2 {
    private static boolean ok = true;//先定一个全局变量
    private static volatile Object lock = new Object();//lock锁

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 26; i++) {
                    while (!ok) {
                        try {

                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                    System.out.print(i + "");
                    ok = false;
                    lock.notify();
                }

            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {//调用lock共享一个同步锁
                for (char j = 'A'; j <= 'Z'; j++) {
                    while (ok) {
                        try {

                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                    System.out.print(j + " ");
                    ok = true;
                    lock.notify();
                }

            }

        });

        t1.start();
        t2.start();
    }

}
