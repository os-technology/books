package org.volatiles;

/**
 * http://www.importnew.com/24082.html
 *
 * @author yuijnshui@lxfintech.com
 * @Title: VolatileInfo
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/12下午1:16
 * <p>
 * 1.当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
 * 2.而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的，当其他线程去读取时，此时
 * 内存中可能还是原来的旧值，因此无法保证可见性。
 */

public class VolatileInfo {


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            IncrNumber inc1 = new IncrNumber(10);
            Thread th1 = new Thread(inc1, "线程-1");
            th1.start();
            Thread th2 = new Thread(inc1, "线程-2");
            th2.start();
            Thread th3 = new Thread(inc1, "线程-3");
            th3.start();
            Thread th4 = new Thread(inc1, "线程-4");
            th4.start();
        }

    }

}

/**
 * 如果去掉volatile标识，则i可能输出结果为：
 * 线程-1--12
 * 线程-3--13
 * 线程-2--12
 * 线程-4--14
 *
 * 加上volatile，
 * 线程-1--12
 * 线程-2--12
 * 线程-3--13
 * 线程-4--14
 */
class IncrNumber implements Runnable {


    volatile int i;
    String name;

    public IncrNumber(int i) {
        this.i = i;
        this.name = name;
    }

    @Override
    public void run() {
        i++;
        System.out.println(Thread.currentThread().getName() + "--" + i);
    }
}

class NumSet implements Runnable {

    int j = 0;

    public NumSet(int i) {
        j = i;
    }

    @Override
    public void run() {

    }
}