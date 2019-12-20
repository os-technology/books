package com.notes.boot.dict.view;

import org.junit.Test;

/**
 * @author code
 * @Title: HashTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/2011:46 AM
 */
public class HashTest {
    /**
     * https://blog.csdn.net/zh854663752/article/details/88033093
     * <p>
     * & 是所有的2进制位数“与”出的最终结果，“与”的规则是两者都为1时才得1，否则就得0
     * 举个例子
     * 7 & 6=？
     * 7的2进制是：1 1 1
     * 6的2进制是：1 1 0
     * 结果： 1 1 0
     * 得到结果为110，2进制转换为10进制110=6
     * 所以：7 & 6 = 6
     */
    @Test
    public void test1() {
//        for (int i = 0; i < 31; i++) {
//            System.out.println(i & 15);
//        }
        System.out.println(16 & 15);
        System.out.println((15 & (14-1)));
        System.out.println((29 & (13-1)));
    }


}
