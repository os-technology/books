package org.sys.threadview;

/**
 * 线程池的回收
 * https://cloud.tencent.com/developer/article/1452041
 *
 * @author code
 * @Title: ThreadPoolTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/311:17 AM
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new SimpleTask(i).runTask(i);
        }
        System.out.println("main - " + Thread.currentThread().getName());
        System.gc();
        //		try {
        //			TimeUnit.SECONDS.sleep(10);
        //		} catch (InterruptedException e) {
        //			e.printStackTrace();
        //		}
    }
}
