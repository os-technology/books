package com.mvn.share.other.notes.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**参考：https://blog.csdn.net/liangyihuai/article/details/83106584
 * CyclicBarrier，下一步动作实施者是“其他线程”。
 *
 * @author code
 * @Title: CyclicBarrierTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/1/911:14 PM
 */
public class CyclicBarrierTest {public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

    CyclicBarrier barrier = new CyclicBarrier(2);
    for(int i = 0; i < 3; i++){
        new Thread(new MyRunnable(barrier), "队友"+i).start();
    }
    System.out.println("main function is finished.");

}


    private static class MyRunnable implements Runnable{
        private CyclicBarrier barrier;

        public MyRunnable(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for(int i = 0; i <2; i++) {
                try {
                    Random rand = new Random();
                    int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                    Thread.sleep(randomNum);
                    System.out.println(Thread.currentThread().getName() + ", 通过了第"+i+"个障碍物, 使用了 "+((double)randomNum/1000)+"s");
                    this.barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

