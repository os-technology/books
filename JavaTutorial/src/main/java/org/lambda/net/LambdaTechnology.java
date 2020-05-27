package org.lambda.net;

/**
 * Lambda 的骚操作，你都get到了没
 * https://mp.weixin.qq.com/s/W2dF-6lUIsNth3LWw2XE9g
 *
 * @author code
 * @Title: LambdaTechnology
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/5/259:40
 */
public class LambdaTechnology {
    /*
     * @FunctionalInterface: 修饰函数式接口的，要求接口中的抽象方法只有一个。
     * 这个注解往往会和 lambda 表达式一起出现。
     */

    /**
     * 多参无返回
     */
    @FunctionalInterface
    public interface NoReturnMultiParam {
        void method(int a, int b);
    }

    /**
     * 无参无返回
     */
    @FunctionalInterface
    public interface NoReturnNoParam {
        void method();
    }

    /**
     * 一个参数有返回
     */
    @FunctionalInterface
    public interface NoReturnOneParam {
        void method(int a);
    }

    /**
     * 多个参数有返回
     */
    @FunctionalInterface
    public interface ReturnMultiParam {
        int method(int a, int b);
    }

    /*** 无参有返回*/
    @FunctionalInterface
    public interface ReturnNoParam {
        int method();
    }

    /**
     * 一个参数有返回值
     */
    @FunctionalInterface
    public interface ReturnOneParam {
        int method(int a);
    }

    /**
     * 不同类型参数有返回值
     */
    @FunctionalInterface
    public interface ReturnOneDiffParam {
        String method(int a, String b);
    }

    /*** 语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，
     -> 为 lambda运算符 ，读作(goes to)。*/
    public static void main(String[] args) {
//        originalExec();
        simpleFirst();
    }

    private static void simpleFirst() {
        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NoReturnMultiParam noReturnMultiParam = (a, b) -> {
            System.out.println("NoReturnMultiParam 简化参数类型");
        };

        //2.简化参数小括号，如果只有一个参数则可以省略参数小括号
        NoReturnOneParam lambda2 = a -> {
            System.out.println("简化参数小括号");
        };
        lambda2.method(1);

        //3.简化方法体大括号，如果方法条只有一条语句，则可以胜率方法体大括号
        NoReturnNoParam lambda3 = () -> {
            System.out.println("简化方法体大括号");
        };
        lambda3.method();

        //4.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号
        ReturnOneParam lambda4 = a -> a + 3;
        System.out.println("ReturnOneParam a + 3 = " + lambda4.method(5));


        ReturnMultiParam lambda5 = (a, b) -> a + b;
        System.out.println("ReturnMultiParam a + b = " + lambda5.method(1, 3));

        noReturnMultiParam.method(2, 3);
        // 不同类型参数的传参与返回
        ReturnOneDiffParam returnOneDiffParam = (a, b) -> {
            System.out.println("不同类型参数的传参与返回");
            return "mutliDiffParamValue : a=" + a + " b=" + b;
        };

        String mutliDiffParamResult = returnOneDiffParam.method(2, "mutliDiffParam");
        System.out.println("ReturnOneDiffParam val = " + mutliDiffParamResult);
    }

    private static void originalExec() {
        //无参无返回
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("NoReturnNoParam");
        };
        noReturnNoParam.method();

        //一个参数无返回
        NoReturnOneParam noReturnOneParam = (a) -> {
            System.out.println("NoReturnOneParam " + a);
        };
        noReturnOneParam.method(5);

        //多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a, int b) -> {
            System.out.println("NoReturnMultiParam param:" + "{" + a + "," + +b + "}");
        };
        noReturnMultiParam.method(6, 8);

        ReturnNoParam returnNoParam = () -> {
            System.out.println("ReturnNoParam");
            return 2;
        };
        int val = returnNoParam.method();
        System.out.println("ReturnNoParam value = " + val);

        //一个参数有返回值
        ReturnOneParam returnOneParam = (int a) -> {
            System.out.println("ReturnOneParam param:" + a);
            return 1;
        };

        int res2 = returnOneParam.method(6);
        System.out.println("returnOneParam:" + res2);

        //多个参数有返回值
        ReturnMultiParam returnMultiParam = (int a, int b) -> {
            System.out.println("ReturnMultiParam param:" + "{" + a + "," + b + "}");
            return 1;
        };

        int res3 = returnMultiParam.method(6, 8);
        System.out.println("returnMultiParam:" + res3);
    }
}

