package org.test.tmp;

import com.alibaba.fastjson.JSON;
import org.algorithm.list.base64.Base64;
import org.apache.commons.lang3.StringUtils;
import org.beans.UserBean;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
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
     * 测试蹩脚的map赋值操作
     */
    @Test
    public void mapTest(){

        //被赋值的map
        HashMap wasSetMap = new HashMap();

        //不断变更值的map
        Map changeMap = null;

        changeMap = wasSetMap;


    }


    @Test
    public void spaceClean(){
        String info = "hello world  haha";
        System.out.println(StringUtils.deleteWhitespace(info));
    }

 @Test
    public void JSONArray(){
        String info = "[\"红\",\"黄\",\"绿\"]";
     List<String> list = JSON.parseArray(info, String.class);
        System.out.println(JSON.toJSONString(list));
    }


    /**
     * list 的remove需要使用迭代器处理
     */
    @Test
    public void list() {
        List<UserBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserBean bean = new UserBean();
            bean.setCompanyId(i + "")
                    .setId(Long.valueOf(i))
                    .setUsername("张三" + i)
                    .setAge(14 + i);
            list.add(bean);
        }
        System.out.println("创建list：" + JSON.toJSONString(list));
        Iterator<UserBean> itor = list.iterator();

        while (itor.hasNext()) {
            UserBean user = itor.next();
            if (user.getAge() < 16) {
                itor.remove();
            }
        }

        System.out.println("remove 后的list：" + JSON.toJSONString(list));
    }

    @Test
    public void intIncr() {
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(++a);
    }

    @Test
    public void compare() {
        System.out.println(Math.sqrt(16));
        System.out.println(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
        String a = "hello";
        String b = (a + "a").intern();
        String c = "helloa";

        System.out.println(c.getBytes());
        System.out.println(b.getBytes());
        System.out.println(c == b ? true : false);
    }

    @Test
    public void phone() {
        int[] arr = {8, 2, 1, 0, 3};
        int[] index = {2, 0, 3, 2, 4, 0, 1, 3, 2, 3, 3};
        String tel = "";
        for (int i : index) {
            tel += arr[i];
        }
        System.out.println("联系方式：" + tel);
    }


    @Test
    public void cycle() {
        String first = "https://iqiyi.com-l-iqiyi.com/20190119/21146_3f16f3ea/1000k/hls/85de2e14e5e00";
        for (int i = 0; i < 1710; i++) {
            if (i < 10) {
                System.out.println(first + "000" + i + ".ts");
            } else if (i < 100) {
                System.out.println(first + "00" + i + ".ts");
            } else if (i < 1000) {
                System.out.println(first + "0" + i + ".ts");
            } else {
                System.out.println(first + i + ".ts");
            }
        }
    }


    @Test
    public void matchString() {

        Assert.assertTrue("hello".matches("^[a-z][a-zA-Z0-9]*$"));
        Assert.assertTrue("helloH".matches("^[a-z][a-zA-Z0-9]*$"));
        Assert.assertTrue("hello_world".matches("^[a-z][a-zA-Z0-9]*$"));
        Assert.assertTrue("basicClass".matches("^[a-z][a-zA-Z0-9]*$"));
        Assert.assertTrue("hell3o".matches("^[a-z][a-zA-Z0-9]*$"));
    }


    @Test
    public void indexof() {
        String str = "hello/123";
        System.out.println(str.lastIndexOf('/'));
        ;
    }

    /**
     * 冒泡排序
     */
    @Test
    public void order() {
        int[] a = {3, 2, 5, 7, 1};

        int tmp = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        System.out.println(JSON.toJSONString(a));

    }


    @Test
    public void base64() throws IOException {
        File filename = new File("/Users/yujinshui/Desktop/paymax/资料文档/给三方的接口文档-华夏银行/测试环境证书信息/commonpay_pri.pfx");
        FileInputStream inputFromFile = new FileInputStream(filename);
        byte[] byteData = new byte[inputFromFile.available()];
        inputFromFile.read(byteData);
        inputFromFile.close();

        String pfxData = Base64.encode(byteData);
        System.out.println(pfxData);
    }


    /**
     * 二进制输出
     */
    @Test
    public void binaryOutput() {
        long a = 669127l;
        long out = a >> 1;
        String bin = Long.toBinaryString(out);
        System.out.println(a + " - " + Long.toBinaryString(a));
        System.out.println(out + " - " + Long.toBinaryString(out));

        String binary = "10100011010111000111";
        Long result = Long.parseLong(binary, 2);
        System.out.println(binary + " - " + result);
    }


    @Test
    public void testLen() {
        for (int i = 0; i < 128; i++) {
            System.out.print("是");
        }
    }

    @Test
    public void testChineseLen() throws UnsupportedEncodingException {
        System.out.println("你好".getBytes("UTF-8").length);
        System.out.println("你好".getBytes().length);
    }

    @Test
    public void testChinese() {
        String str = "java,，你好";

        System.out.println(length(str));
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    private int length(String s) {
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

    public boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    @Test
    public void testOut() {
        String str = "10";
        System.out.println(str);
        str = "20";
        System.out.println(str);
    }

    @Test
    public void testGetEnum() {
        OrderTypeEnum typeEnum = OrderTypeEnum.valueOf("charge".toUpperCase());
        System.out.println(typeEnum.name());
    }

    @Test
    public void testArray() {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(a[3]);//{1,2,3,4}[2]写法是错误的
    }


    @Test
    public void testBool() {
        System.out.println(getResult());
    }

    private boolean getResult() {
        String b = "hello";
        final String a = "hello";
        String c = a + 2;
        String d = b + 2;
        return c == d;
    }


    @Test
    public void testFact() {
        Map<String, String> map = new HashMap<>();
        List list = new ArrayList<>();
        String a = "aabcqweracb";
        byte[] array = a.getBytes();
        for (byte b : array) {
            String tmp = map.get(String.valueOf(b));
            if (tmp == null) {
                list.add((char) b);
                map.put(String.valueOf(b), String.valueOf((char) b));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private long value(long a) {
        if (a == 1) {
            return a;
        }
        return a * value(a - 1);
    }

    @Test
    public void testParam() {
        String data = String.format("数据异常，boss merchantId[%s] 对应的附加服务[%s]配置有多条", "123", "type");
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
