package com.thread.tutorial.start.github.one;

/**
 * 使用interrupt()方法
 *
 * @author code
 * @Title: InterruptThread
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/2/21下午6:49
 */
public class InterruptThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()) {
                System.out.println("线程已经被 Interrupt 了，我要退出了。");
//                break;//interrupt()使用
                return;
            }
            System.out.println("i=" + (i + 1));
        }
        System.out.println("看到这句话说明线程并未终止------");
    }

    /**
     * 使用 interrupt()方法: for循环虽然停止执行了，但是for循环下面的语句还是会执行，说明线程并未被停止。
     * 使用return停止线程
     *
     * @param args
     */
    public static void main(String[] args) {
        InterruptThread thread = new InterruptThread();
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
