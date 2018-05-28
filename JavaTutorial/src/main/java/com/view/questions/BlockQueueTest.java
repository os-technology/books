package com.view.questions;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: BlockQueueTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/28下午2:58
 */

public class BlockQueueTest {
    static ArrayBlockingQueue<String> query = new ArrayBlockingQueue<String>(4);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        query.put(i + "");
                        System.out.println(Thread.currentThread().getName()+"---put suc "+i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName()+" 获取数据--->" + query.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(2000000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
