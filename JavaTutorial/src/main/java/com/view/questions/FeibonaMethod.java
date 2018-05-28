package com.view.questions;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: FeibonaMethod
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/28上午9:58
 */

public class FeibonaMethod {

    private static int feibona(int a){
        if(a==0||a==1){
            return a;
        }
        return feibona(a-1)+feibona(a-2);
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            System.out.print(feibona(i)+"  ");
        }
    }

}
