package org.colon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author code
 * @Title: ColonTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/9/41:51 PM
 */
public class ColonTest {
    public static void main(String[] args) {
//        normalMethod();

        colonMethod();

    }

    private static void colonMethod() {
        ColonTest colonTest = new ColonTest();
        List<String> a1 = Arrays.asList("a", "b", "c");
        System.out.println("输出方式一");
        a1.forEach(System.out::println);
        a1.forEach(colonTest::printValue);

        System.out.println("输出方式二");
        Consumer<String> consumer = colonTest::printValue;
        a1.forEach(x->consumer.accept(x));
    }

    private static void normalMethod() {
        List<String> a1 = Arrays.asList("a", "b", "c");
        for (String a : a1) {
            printValur(a);
        }
        a1.forEach(x -> ColonTest.printValur(x));
    }

    public void printValue(String str) {
        System.out.println("print value : " + str);
    }
    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }
}
