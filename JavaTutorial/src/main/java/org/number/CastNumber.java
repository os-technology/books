package org.number;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: CastNumber
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/11上午7:55
 */

public class CastNumber {

    public static int parseInt(String num){
        int result = 0;
        int index = 0;
        if (num.startsWith("-")){
            index++;
        }

        while(index<=num.length()-1){

            int n = num.charAt(index++);
            if (n<=57&&n>=48){
                result*=10;
                result+=n-48;
            }else{
                System.err.println("num is not Integer");
                throw new NumberFormatException();
            }
        }

        if (num.startsWith("-")){
            result=-result;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(parseInt("2344132"));
        Integer.parseInt("123");
    }
}
