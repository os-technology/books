package org.test.tmp;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
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




    /**
     * 二进制输出
     */
    @Test
    public void binaryOutput(){
        long a = 669127l;
        long out = a>>1;
        String bin = Long.toBinaryString(out);
        System.out.println(a+" - "+Long.toBinaryString(a));
        System.out.println(out+" - "+Long.toBinaryString(out));

        String binary = "10100011010111000111";
        Long result = Long.parseLong(binary,2);
        System.out.println(binary+" - "+result);
    }



    @Test
    public void testLen(){
        for(int i=0;i<128;i++){
            System.out.print("是");
        }
    }

    @Test
    public void testChineseLen() throws UnsupportedEncodingException {
        System.out.println("你好".getBytes("UTF-8").length);
        System.out.println("你好".getBytes().length);
    }

    @Test
    public void testChinese(){
        String str = "java,，你好";

        System.out.println(length(str));
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     * @param  s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    private  int length(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }
    public  boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }
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