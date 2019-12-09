package com.view.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 阻塞队列，个人认为正确的写法
 *
 * @author code
 * @Title: Bqueue
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/81:46 PM
 */
public class Bqueue {
    private List arrays = new ArrayList();
    private int limit;

    public Bqueue(int limit) {
        this.limit = limit;
    }

    public void add(String val) throws InterruptedException {
        synchronized (this) {
            while (arrays.size() == limit) {
                this.wait();
            }
            notifyAll();
            arrays.add(val);
        }
    }

    public Object remove() throws InterruptedException {
        synchronized (this) {
            while (arrays.size() == 0) {
                this.wait();
            }
            this.notifyAll();
            return arrays.remove(0);
        }
    }

    public static void main(String[] args) {
        Bqueue bqueue = new Bqueue(3);
        for (int i = 0; i < 1; i++) {
            exeThread(bqueue);
        }
    }

    private static void exeThread(Bqueue bqueue) {
        new Thread(() -> {
            for (int i = 0; i < 12; i++) {
                try {
                    bqueue.add("" + i);
                    System.out.println(Thread.currentThread().getName() + " add - " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 12; i++) {

                try {
                    System.out.println(Thread.currentThread().getName() + " pop ----" + bqueue.remove());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
