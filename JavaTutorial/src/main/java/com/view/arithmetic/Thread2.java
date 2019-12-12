package com.view.arithmetic;

/**
 * @author code
 * @Title: Thread2
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/129:54 AM
 */
public class Thread2 {
    private static boolean ok = true;//先定一个局变量
    private static Object lock = new Object();//lock锁

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

        t2.start();
        t1.start();
    }

}
