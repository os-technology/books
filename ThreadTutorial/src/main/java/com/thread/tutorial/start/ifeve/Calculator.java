package com.thread.tutorial.start.ifeve;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * http://ifeve.com/thread-management-3/
 * @author code
 * @Title: Calculator
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/18下午4:01
 */
public class Calculator implements Runnable {

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        for (int i = 1; i < 10; i++) {
            System.out.printf("%s : %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }

    public static void main(String[] args) {

        String logPath = "/Users/yujinshui/Desktop/logs/thread.txt";
        File fileName = new File(logPath);
        if (!fileName.getParentFile().exists()) {
            fileName.getParentFile().mkdirs();
        }


        //5. 创建一个大小为10的Thread类的数组和一个大小为10的Thread.State数组来保存将要执行的线程和它们的状态
        Thread[] thread = new Thread[10];
        Thread.State[] state = new Thread.State[10];

        //6. 创建10个Calculator类的对象，每个初始为不同的数字，然后分别用10个线程来运行它们。把其中5个的优先值设为最高，把另外5个的优先值为最低。
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Calculator(i));
            if (i % 2 == 0) {
                thread[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                thread[i].setPriority(Thread.MIN_PRIORITY);
            }
            thread[i].setName("Thread " + i);
        }

        //7.   创建一个 PrintWriter对象用于把线程状态的改变写入文档。
        try (FileWriter file = new FileWriter(logPath);
//        try (FileWriter file = new FileWriter("./thread.txt");
             PrintWriter pw = new PrintWriter(file)) {
            //8.   把10个线程的状态写入文档。现在，它成为NEW.
            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + thread[i].getState());
                state[i] = thread[i].getState();
            }

            //9.   开始执行这10个线程.
            for (int i = 0; i < 10; i++) {
                thread[i].start();
            }

            //10. 直到这10个线程执行结束，我们会一直检查它们的状态。如果发现它的状态改变，就把状态记入文本。

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (thread[i].getState() != state[i]) {
                        writeThreadInfo(pw, thread[i], state[i]);
                        state[i] = thread[i].getState();

                    }
                }
                finish = true;

                for (int i = 0; i < 10; i++) {

                    finish = finish && (thread[i].getState() == Thread.State.TERMINATED);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //11. 实现一个方法 writeThreadInfo()，这个方法写线程的 ID, name, priority, old status, 和 new status。
    //12.运行这个例子，然后打开 log.txt 文档并查看10个线程的状态变化。
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {

        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());

        pw.printf("Main : Priority: %d\n", thread.getPriority());

        pw.printf("Main : Old State: %s\n", state);

        pw.printf("Main : New State: %s\n", thread.getState());

        pw.printf("Main : ************************************\n");

    }

    /**
     * 接下来是程序在执行的 thread.txt 文本的一些行的裁图。在这个文本中，可以发现有高优先级的线程们比低优先级的先结束。还可以发现线程状态的演变过程。
     * 程序的控制台显示的是线程计算的乘法表，而 thread.txt 文本记录的是不同线程的状态演变。这样子，可以更好的观察线程的演变过程。
     */
}
