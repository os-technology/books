package com.mvn.share.other.notes;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CountDownLatch 和 CyclicBarrier 的使用
 *
 * @author code
 * @Title: RunRaceThread
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/1/910:06 PM
 */
public class RunRaceThread {

    private static final int num = 5;
    //5+1，表示主线程也包含在内
    private static CyclicBarrier barrier = new CyclicBarrier(num + 1);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CountDownLatch latch = new CountDownLatch(num);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            new Thread(new MyThread(latch), "player " + i).start();

        }
        System.out.println("正在等待所有玩家准备好");
        //阻碍当前线程进行,除非计数归零 countDown直到0，await的线程才会继续执行
        latch.await();
        System.out.println("开始游戏");
        barrier.await();
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间：" + (endTime - startTime));
    }


    private static class MyThread implements Runnable {
        private CountDownLatch latch;

        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            Random random = new Random();
            int randomNum = random.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
            try {
                Thread.sleep(randomNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 已经准备好了, 所使用的时间为 " + ((double) randomNum / 1000) + "s");
            latch.countDown();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
