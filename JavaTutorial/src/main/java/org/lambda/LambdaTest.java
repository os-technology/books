package org.lambda;

import java.awt.event.ActionEvent;

/**
 * @author code
 * @Title: LambdaTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/11/14下午4:36
 */
public class LambdaTest {
    @FunctionalInterface
    public interface Runnable {
        void run();
    }

    public interface Callable<V> {
        V call() throws Exception;
    }

    public interface ActionListener {
        void actionPerformed(ActionEvent e);
    }

    public interface Comparator<T> {
        int compare(T o1, T o2);

        boolean equals(Object obj);
    }

    public static void main(String[] args) {

        Runnable r1 = () -> {
            System.out.println("Hello Lambda!");
        };

        Object obj = r1;

        Object o = (Runnable) () -> {
            System.out.println("hi");
        }; // correct

        System.out.println((Runnable) () -> {
        }); // 正确

    }
}
