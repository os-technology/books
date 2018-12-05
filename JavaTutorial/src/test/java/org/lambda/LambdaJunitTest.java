package org.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/bitcarmanlee/article/details/70195403
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
}
