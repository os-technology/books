package org.lottery;

import java.util.Random;

/**
 * 彩票模拟出号
 *
 * @author yuijnshui@lxfintech.com
 * @Title: LotteryMock
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/6/30下午5:29
 */

public class LotteryMock {

    private static  String createNum(){
        Random ran = new Random();
        int a = ran.nextInt(10);
        String result = "";
        for( int i = 0;i<10;i++){
            if (a==i){
                result+=a;
            }else{
                result+="-";
            }

        }
        return result;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(createNum());
        }
    }

}
