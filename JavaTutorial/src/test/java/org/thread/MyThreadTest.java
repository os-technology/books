package org.thread;

import org.junit.Test;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: MyThreadTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/16下午5:39
 */

public class MyThreadTest {

    @Test
    public void testThread(){
        new Thread(new MyRunnable()).start();
    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                System.out.print(" - "+i);
            }
        }
    }

}
