package org.test.tmp;

import org.junit.Test;

import java.util.*;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: TmpTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/10/12下午1:41
 */

public class TmpTest {

    @Test
    public void testOut(){
        String str = "10";
        System.out.println(str);
        str="20";
        System.out.println(str);
    }
    @Test
    public void testGetEnum(){
        OrderTypeEnum typeEnum = OrderTypeEnum.valueOf("charge".toUpperCase());
        System.out.println(typeEnum.name());
    }

    @Test
    public void testArray(){
        int[] a={1,2,3,4,5};
        System.out.println(a[3]);//{1,2,3,4}[2]写法是错误的
    }


    @Test
    public void testBool(){
        System.out.println(getResult());
    }

    private boolean getResult() {
        String b = "hello";
        final String a = "hello";
        String c = a+2;
        String d = b+2;
        return c==d;
    }


    @Test
    public void testFact(){
        Map<String,String> map = new HashMap<>();
        List list = new ArrayList<>();
        String a = "aabcqweracb";
        byte[] array = a.getBytes();
        for(byte b:array){
            String tmp = map.get(String.valueOf(b));
            if(tmp==null) {
                list.add((char)b);
                map.put(String.valueOf(b), String.valueOf((char) b));
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    private long value(long a){
        if(a==1){
            return a;
        }
        return a*value(a-1);
    }

    @Test
    public void testParam(){
        String data = String.format("数据异常，boss merchantId[%s] 对应的附加服务[%s]配置有多条","123", "type");
        System.out.println(data);
        Integer a = null;

        try {
            a = new Integer("a");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("catch is over");
        a = 12;
    }

}
