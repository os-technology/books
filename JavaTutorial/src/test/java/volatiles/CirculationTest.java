package volatiles;

import org.junit.Test;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Circulation
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/14上午7:55
 */

public class CirculationTest {
    public boolean flag = true;


    @Test
    public void testThreadFlag(){
        Thread th1 = new Thread(new ThreadTrueOrFalse());
        long time1 = System.currentTimeMillis();
        th1.start();
        flag = false;
        long time2 = System.currentTimeMillis();
        System.out.println("毫秒数"+(time2-time1));
    }

    @Test
    public void testWhile(){
        int i=0;
        while (true){
            System.out.println(i++);
            if (i>100)
                break;
        }
    }

    class ThreadTrueOrFalse implements Runnable{
        private boolean flag1;
        public ThreadTrueOrFalse(boolean flag){
            this.flag1 = flag;
        }
        public ThreadTrueOrFalse(){
            this.flag1 = flag;
        }
        int i=0;
        @Override
        public void run() {

            while (flag){
                System.out.println(i++);
            }
        }
    }
}


