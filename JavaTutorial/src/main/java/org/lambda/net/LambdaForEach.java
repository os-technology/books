package org.lambda.net;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * https://mp.weixin.qq.com/s/W2dF-6lUIsNth3LWw2XE9g
 *
 * @author code
 * @Title: LambdaForEach
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/5/2617:23
 */
public class LambdaForEach {
//    @FunctionalInterface
//    public interface Consumer<T> {
//        void accept(T t);
//    }

    public static void main(String[] args) {
        //遍历集合
//        listForEach();
        //删除集合中的某个元素
//        listForDeleteElement();
        //集合内元素的排序
//        listForSortElements();
        //Lambda 表达式中的闭包问题
        closePack();
    }

    /**
     * 遍历集合
     * * <p>
     * * 我们可以调用集合的public void forEach(Consumer<? super E> action) 方法，
     * * 通过 lambda 表达式的方式遍历集合中的元素。以下是 Consumer 接口的方法以及
     * * 遍历集合的操作。Consumer 接口是 jdk 为我们提供的一个函数式接口。
     */
    private static void listForEach() {
        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 2, 3, 4, 5);

        //lambda表达式方法引用
        list.forEach(System.out::println);

        System.out.println("偶数输出：");
        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });
    }

    /**
     * 删除集合中的某个元素
     * <p>
     * 我们通过public boolean removeIf(Predicate<? super E> filter)方法来删除集合中的某个元素，
     * Predicate 也是 jdk 为我们提供的一个函数式接口，可以简化程序的编写。
     */
    private static void listForDeleteElement() {
        ArrayList<Item> items = getList();

        items.removeIf(item -> item.getId() == 7);
        items.forEach(System.out::println);
    }

    private static ArrayList<Item> getList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(11, "小牙刷", 12.05));
        items.add(new Item(5, "日本马桶盖", 999.05));
        items.add(new Item(7, "格力空调", 888.88));
        items.add(new Item(17, "肥皂", 2.00));
        items.add(new Item(9, "冰箱", 4200.00));
        items.add(new Item(13, "背心", 7.80));
        items.add(new Item(11, "半袖", 37.80));
        items.add(new Item(14, "风衣", 139.80));
        items.add(new Item(12, "秋裤", 55.33));
        return items;
    }

    /**
     * 集合内元素的排序
     * <p>
     * 在以前我们若要为集合内的元素排序，就必须调用 sort 方法，
     * 传入比较器匿名内部类重写 compare 方法，我们现在可以使用 lambda 表达式来简化代码。
     */
    private static void listForSortElements() {
        ArrayList<Item> items = getList();
//        items.sort((a, b) -> a.getId() - b.getId());
        items.sort(Comparator.comparingInt(Item::getId));
        items.forEach(System.out::println);

    }

    /**
     * TODO Lambda 表达式中的闭包问题
     * <p>
     * 这个问题我们在匿名内部类中也会存在，如果我们把注释放开会报错，
     * 告诉我 num 值是 final 不能被改变。这里我们虽然没有标识 num 类型为 final，
     * 但是在编译期间虚拟机会帮我们加上 final 修饰关键字。
     */
    private static void closePack() {
        int num = 10;
        Consumer<String> consumer = ele -> {
            //num=5;//启用该行代码，便会提示final信息。
            System.out.println(num);
        };
        consumer.accept("hello");
    }
}
