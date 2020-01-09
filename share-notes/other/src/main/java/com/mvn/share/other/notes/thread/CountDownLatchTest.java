package com.mvn.share.other.notes.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 参考：https://blog.csdn.net/liangyihuai/article/details/83106584
 * CountDownLatch用法
 * CountDown表示减法计数，Latch表示门闩的意思，计数为0的时候就可以打开门闩了
 * CountDownLatch，当计数为0的时候，下一步的动作实施者是main函数
 *
 * @author code
 * @Title: CountDownLatchTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/1/910:09 PM
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(latch), "player " + i).start();
        }
        System.out.println("正在等待所有玩家准备好");
        //阻碍当前线程进行,除非计数归零 countDown直到0，await的线程才会继续执行
        latch.await();
        System.out.println("开始游戏");
    }

    private static class MyThread extends Thread {
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

        }
    }
}


