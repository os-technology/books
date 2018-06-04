package org.sys.thread;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: NumAndAlphaThread
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/2下午2:01
 */

public class NumAndAlphaThread extends Thread {
    private static Object lock = new Object();
    static boolean flag = true;
    private static NumAndAlphaThread th1 = null;
    private static NumAndAlphaThread th2 = null;

    private static NumAndAlphaThread printAlpha() {
        return new NumAndAlphaThread() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 65; i < 91; i++) {
                        if (!flag) {
                            System.out.println(" " + (char) i + " ");
                            flag = true;
                            lock.notify();

                            if (i < 91) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
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
                        System.out.print(i);
                        if (flag && i % 2 == 0) {
                            lock.notify();
                            flag = false;
                            if (i < 53) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    private void result() {//先启动哪个线程也有关系
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
