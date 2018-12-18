package org.lambda;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * https://blog.csdn.net/bitcarmanlee/article/details/70195403
 * http://www.importnew.com/16436.html
 * http://zh.lucida.me/blog/java-8-lambdas-insideout-language-features/
 *
 * @author code
 * @Title: LambdaJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/12/5下午6:13
 */
public class LambdaJunitTest {


    //1.替代匿名内部类
    @Test
    public void oldRunable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();
    }

    @Test
    public void runable() {
        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }


    //2.使用lambda表达式对集合进行迭代

    @Test
    public void iterTest() {
        List<String> languages = Arrays.asList("java", "scala", "python");
        //
        System.out.println("===before java8===");
        for (String each : languages) {
            System.out.println(each);

        }

        //after java8
        System.out.println("===after java8===");
        languages.forEach(x -> System.out.println(x));


        languages.forEach(System.out::println);
    }


    /**
     * 3.用lambda表达式实现map
     * 一提到函数式编程，一提到lambda表达式，怎么能不提map。。。没错，java8肯定也是支持的。请看示例代码：
     * map函数可以说是函数式编程里最重要的一个方法了。map的作用是将一个对象变换为另外一个。在我们的例子中，就是通过map方法将cost增加了0,05倍的大小然后输出。
     */
    @Test
    public void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        cost.stream().map(x -> x + x * 0.01).forEach(x -> System.out.println(x));
    }


    /**
     * 4.用lambda表达式实现map与reduce
     * 既然提到了map，又怎能不提到reduce。reduce与map一样，也是函数式编程里最重要的几个方法之一。
     * map的作用是将一个对象变为另外一个，而reduce实现的则是将所有值合并为一个
     */
    @Test
    public void mapReduceTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        Double result = cost.stream().map(x -> x + x * 0.05).reduce((sum, x) -> sum + x).get();
        System.out.println("计算结果：" + result);
    }

    /**
     * 5.filter操作
     * filter也是我们经常使用的一个操作。在操作集合的时候，经常需要从原始的集合中过滤掉一部分元素。
     */
    @Test
    public void filterTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0);
        List<Double> filterCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filterCost.forEach(x -> System.out.println(x));
    }

    @Test
    public void filterMapTest() {
        Map<String, String> map = new HashMap<>();

        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");

        Iterator<String> iter = map.keySet().iterator();
        iter.forEachRemaining(k -> {
            if (map.get(k).contains("2")) {
                iter.remove();
            }
        });

        System.out.println(JSON.toJSONString(map));

        Map<String, String> mapResult = map.entrySet().stream()
                .filter(ma -> !"3".equals(ma.getValue()))//filter只能过滤一个条件信息
                .filter(ma -> !"4".equals(ma.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println(JSON.toJSONString(mapResult));
    }


    private void filter() {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        String result = "";
        for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
            if ("aws.amazon.com".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }
        System.out.println("Before Java 8 : " + result);
        //Map -> Stream -> Filter -> String
        result = HOSTING.entrySet().stream()
                .filter(map -> "aws.amazon.com".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());
        System.out.println("With Java 8 : " + result);

    }

    /**
     * 6.与函数式接口Predicate配合
     */
    @Test
    public void predicateTest() {

        List<String> languages = Arrays.asList("Java", "Python", "scala", "Shell", "R");
        System.out.println("Language starts with J: ");
        predicateFilter(languages, x -> x.startsWith("J"));

        System.out.println("\nLanguage ends with a: ");
        predicateFilter(languages, x -> x.endsWith("a"));

        System.out.println("\nAll languages: ");
        predicateFilter(languages, x -> true);

        System.out.println("\nNo languages: ");
        predicateFilter(languages, x -> false);

        System.out.println("\nLanguage length bigger three: ");
        predicateFilter(languages, x -> x.length() > 4);

    }

    private void predicateFilter(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.print(x + " "));
    }
}
