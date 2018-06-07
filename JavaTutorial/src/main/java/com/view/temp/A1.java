package com.view.temp;

import java.math.BigDecimal;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: A1
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/4上午9:53
 */

public class A1 {
    static {
        System.out.println(1);
    }

    public A1(){
        System.out.println(2);
    }

    public static void main(String[] args) {
//        A1 a = new B();

        System.out.println(new BigDecimal(20.1).multiply(new BigDecimal("100")).setScale(0).toPlainString());
    }

}


class B extends A1{
    static {
        System.out.println(3);
    }
    public B(){
        System.out.println(4);
    }
}