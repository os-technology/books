package com.view.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 阻塞队列
 * 此种写法会导致无限等待问题。输出示例参考：
 * Thread-0 set -0
 * Thread-0 set -1
 * Thread-0 set -2
 * Thread-1 pop -set value -0
 * Thread-1 pop -set value -1
 * Thread-1 pop -set value -2
 * Thread-1 pop -set value -3
 * Thread-0 set -3
 * Thread-0 set -4
 * Thread-0 set -5
 * Thread-0 set -6
 *
 * @author code
 * @Title: Bqueue
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/81:46 PM
 */
public class Bqueue1 {
    private List arrays = new ArrayList();
    private int limit;

    public Bqueue1(int limit) {
        this.limit = limit;
    }

    public void add(String val) throws InterruptedException {
        synchronized (this) {
            while (arrays.size() == limit) {
                this.wait();
            }
            arrays.add(val);
        }
    }

    public Object remove() throws InterruptedException {
        synchronized (this) {
            while (arrays.size() == 0) {
                this.wait();
            }
            if (arrays.size() > 0) {
                this.notifyAll();
            }
            return arrays.remove(0);
        }
    }

    public static void main(String[] args) {
        Bqueue1 bqueue = new Bqueue1(3);
        for (int i = 0; i < 1; i++) {
            exeThread(bqueue);
        }
    }

    private static void exeThread(Bqueue1 bqueue) {
        new Thread(() -> {
            for (int i = 0; i < 12; i++) {
                try {
                    bqueue.add("set value -" + i);
                    System.out.println(Thread.currentThread().getName() + " set -" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 12; i++) {

                try {
                    System.out.println(Thread.currentThread().getName() + " pop -" + bqueue.remove());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
