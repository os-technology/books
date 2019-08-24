package com.notes.boot.dict.threadlocal;

/**
 * java的线程安全问题演示
 * 不可不知的threadlocal底层原理
 *
 * @author code
 * @Title: CountTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/222:44 PM
 */
public class CountTest {

    private long count = 0;

    /**
     * 如要保证输出结果为20000，添加 synchronized 关键字即可
     * 共享的情况，加 synchronized 锁控制即可
     */
    public void incCount() {
        count = count + 1;
    }

    //进行累加的线程
    private static class Count extends Thread {
        private CountTest countTest;

        public Count(CountTest countTest) {
            this.countTest = countTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                countTest.incCount();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountTest test = new CountTest();

        Count count1 = new Count(test);
        Count count2 = new Count(test);

        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(test.count);
    }
}
