package org.lambda.net;

/**
 * lambda 表达式引用方法
 * 有时候我们不是必须要自己重写某个匿名内部类的方法，
 * 我们可以可以利用 lambda表达式的接口快速指向一个已经被实现的方法。
 * <p>
 * 语法
 * <p>
 * 方法归属者::方法名 静态方法的归属者为类名，普通方法归属者为对象
 *
 * @author code
 * @Title: Exe1
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/5/2512:02
 */
public class Exe1 {


    public static void main(String[] args) {
        LambdaTechnology.ReturnOneParam lambda0 = a -> test1(a, 7);
        System.out.println("引用参数不同的实现方法：" + lambda0.method(3));

        LambdaTechnology.ReturnOneParam lambda1 = a -> doubleNum(a);
        System.out.println("引用参数相同的实现方法：" + lambda1.method(3));

        //lambda2 引用了已经实现的 doubleNum 方法
        LambdaTechnology.ReturnOneParam lambda2 = Exe1::doubleNum;
        System.out.println("直接引用了已经实现的 doubleNum 静态方法：" + lambda2.method(3));

        Exe1 exe1 = new Exe1();
        //lambda3 引用了已经实现的 addTwo 方法
        LambdaTechnology.ReturnOneParam lambda3 = exe1::addTwo;
        System.out.println("引用了已经实现的 addTwo 非静态方法：" + lambda3.method(2));
    }

    /**
     * 要求
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     */
    public static int doubleNum(int a) {
        return a * 2;
    }

    public int addTwo(int a) {
        return a + 2;
    }

    public static int test1(int a, int b) {
        return a + b;
    }
}
