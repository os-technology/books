package org.sys.thread;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: TestThread
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/16下午5:37
 */

public class TestThread {

    static class MyRun implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println("输出结果："+i);
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new MyRun()).start();
    }
}
