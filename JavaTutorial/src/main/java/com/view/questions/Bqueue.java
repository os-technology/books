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
            //添加数据至最大限制时，进入wait状态
            while (arrays.size() == limit) {
                this.wait();
            }
            //如果没有超过最大限制，可以随时进行唤醒
            this.notifyAll();
            arrays.add(val);
        }
    }

    public Object remove() throws InterruptedException {
        synchronized (this) {
            //移除到数据为空时，进入等待状态
            while (arrays.size() == 0) {
                this.wait();
            }
            //如果没有全部移除，随时可以进行唤醒
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
