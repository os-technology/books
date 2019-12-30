package com.view.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 机器人编号题
 * <p>
 * 一批机器人，按照 AA001  AA002...AA999,BA001 ....ZZ999，进行编号。
 * 要求每次编号的起始位置为上一个编号为基础，整体为连续性编号。
 *
 * @author code
 * @Title: RobotCode
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/302:25 PM
 */
public class RobotCode {

    private String first(String code) {

        if (code.charAt(1) != 'Z' || !code.contains("Z1000")) {
            return code.charAt(0) + "";
        }

        return String.valueOf((char) (code.charAt(0) + 1));

    }

    Pattern pattern = Pattern.compile("[^0-9]");

    private String second(String code) {

        Matcher matcher = pattern.matcher(code);
        Integer num = Integer.valueOf(matcher.replaceAll(""));
        if (num < 999) {
            return String.valueOf(code.charAt(1));
        }
        if (code.charAt(1) == 'Z') {
            return "A";
        }
        return String.valueOf((char) (code.charAt(1) + 1));
    }


    private String num(String code) {

        Matcher matcher = pattern.matcher(code);
        Integer num = Integer.valueOf(matcher.replaceAll(""));
        if (num < 999) {
            String val = (num + 1) + "";
            //保证为三位数字
            return getThreeNum(val);
        }

        return "001";
    }

    /**
     * 数字格式化
     *
     * @param val
     * @return
     */
    String getThreeNum(String val) {
        //保证为三位数字
        return val.length() == 1 ? "00" + val : (val.length() == 2 ? "0" + val : val);
    }

    /**
     * @param code  起始位置编号
     * @param count 机器人数量
     * @return
     */
    private List<String> getCode(String code, int count) {
        List<String> codeList = new ArrayList<>();
        String a = first(code);
        String b = second(code);
        String c = num(code);


        for (int i = 0; i < count; i++) {
            int numcode = Integer.valueOf(c);
            int tmpNum = numcode + i % 1000;//取余保证数字部分在1-999之间变化
            String tmpCode = a + b + getThreeNum(String.valueOf(tmpNum));
            if (tmpNum % 100 == 0) {//内容输出格式化
                codeList.add("\n");
            }
            if (tmpNum >= 1000) {
                a = first(tmpCode);
                b = second(tmpCode);
                c = "001";
                tmpCode = a + b + getThreeNum(String.valueOf(c));


            }

            codeList.add(tmpCode);
        }
        return codeList;
    }


    private void print(String code, int count) {
        List<String> result = getCode(code, count);
        for (String val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RobotCode rc = new RobotCode();
        rc.print("AB991", 9);
        rc.print("AZ991", 9);
        rc.print("AK991", 1159);


    }
}
