package org.sys.thread;

/**
 * 1.写两个线程，一个线程打印1-52，另一个线程打印字母A-Z。打印顺序为12A34B56C....5152Z。要求用线程通信。
 *
 * @author yuijnshui@lxfintech.com
 * @Title: NumAndAlphaThread
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/2下午2:01
 */

public class NumAndAlphaThread extends Thread {
    private static Object lock = new Object();
    static volatile boolean flag = true;
    private static NumAndAlphaThread th1 = null;
    private static NumAndAlphaThread th2 = null;

    private static NumAndAlphaThread printAlpha() {
        return new NumAndAlphaThread() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 'A'; i <= 'Z'; i++) {
                        while (flag) {
                            try {
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();

                            }

                        }
                        System.out.print((char) i + " ");
                        flag = true;
                        lock.notify();
                    }
                }
            }
        };
    }


    private static NumAndAlphaThread printNum() {
        return new NumAndAlphaThread() {

            @Override
            public void run() {
                synchronized (lock) {

                    for (int i = 1; i < 53; i++) {

                        while (!flag) {
                            try {
                                lock.wait();
                            } catch (Exception e) {
                                e.printStackTrace();

                            }

                        }
                        System.out.print(i);
                        if (flag && i % 2 == 0) {
                            flag = false;
                            lock.notify();
                        }


                    }
                }
            }
        };
    }

    private void result() {
        th2 = printNum();
        th1 = printAlpha();


        th2.start();
        th1.start();

    }

    public static void main(String[] args) {

        NumAndAlphaThread th = new NumAndAlphaThread();
        th.result();
    }
}
