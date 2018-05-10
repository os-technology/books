package org.sorts;

import com.alibaba.fastjson.JSON;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: BubblingSort
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/9下午6:58
 */

public class BubblingSort {

    public static void main(String[] args) {
        int[] a = {3,5,4,7};

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]<a[j+1]){
                    int tmp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
        System.out.println(JSON.toJSONString(a));
    }

}
