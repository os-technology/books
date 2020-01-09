package org.sys.thread;

/**
 * 写两个线程，一个线程打印1-52，另一个线程打印字母A-Z。打印顺序为12A34B56C....5152Z。要求用线程通信。
 *
 * @author code
 * @Title: PrintThread
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/1/98:38 PM
 */
public class PrintThread {

    private static volatile boolean flag = false;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {

            synchronized (lock) {
                for (char i = 'A'; i <= 'Z'; i++) {
                    while (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.print(i + " ");
                    flag = false;
                    lock.notifyAll();
                }
            }
        });


        Thread th2 = new Thread(() -> {

            synchronized (lock) {
                for (int i = 1; i < 53; i++) {
                    while (flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.print(i);
                    if (i % 2 == 0) {
                        flag = true;
                        lock.notifyAll();
                    }
                }
            }
        });

        th1.start();
        th2.start();
    }

}
