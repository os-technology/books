package com.view.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * 编程简单实现一个阻塞队列
 * https://blog.csdn.net/x_i_y_u_e/article/details/51398994
 * https://segmentfault.com/a/1190000000373535
 * <p>
 * <p>
 * 阻塞队列与普通队列的区别在于，当队列是空的时，从队列中获取元素的操作将会被阻塞，或者当队列是满时，往队列里添加元素的操作会被阻塞。试图从空的阻塞队列中获取元素的线程将会被阻塞，直到其他的线程往空的队列插入新的元素。同样，试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞，直到其他的线程使队列重新变得空闲起来，如从队列中移除一个或者多个元素，或者完全清空队列，下图展示了如何通过阻塞队列来合作：
 *
 * @author yuijnshui@lxfintech.com
 * @Title: BlockingQueue
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/28上午10:13
 */

public class BlockingQueue {

    private List queue = new LinkedList();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        //注意要使用while循环，而不是if，因为下面的notifyAll可能把正在等待的入队线程给唤醒
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }

    public static void main(String[] args) {
        final BlockingQueue queue = new BlockingQueue(4);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.enqueue("put value " + i);
                    System.out.println("put  value is " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                    for (int i=0;i<10;i++){
                        System.out.println(Thread.currentThread().getName() + " - value is " + queue.dequeue());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
