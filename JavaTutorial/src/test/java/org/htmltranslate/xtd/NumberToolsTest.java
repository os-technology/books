package org.htmltranslate.xtd;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: NumberToolsTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/8下午9:18
 */

public class NumberToolsTest {

    @Test
    public void testPlayCase() {
        System.out.println(NumberTools.getPlayCase(1));
    }

    @Test
    public void testCheckNumCount() {
        String output = NumberTools.checkNumCount("11qqbbb");
        System.out.println(output);
        System.out.println(output.length() == 4);

    }

    @Test
    public void testRegex() {
        String output = "1133512";
//
//        System.out.println(regMatch(output, "(?s)(.)(?=.*\\1)"));
        System.out.println(regMatch(output, "([1]{2,})"));
//        String test = "hahahhehe sendCode\":\"12367890123rsdfsdfsdfdsahahhehe sendCode\":\"12323444444rsdfsdfsdfds";
//        test = regMatch(test, "sendCode\":\"([\\d]{8})([\\d]{3})");
//        System.out.println(test);
    }

    public String regMatch(String withinText, String regString) {
        String code = null;
        Pattern pattern = Pattern.compile(regString);
        Matcher matcher = pattern.matcher(withinText);
        if (matcher.find()) {
            matcher.reset();
            while (matcher.find()) {
                code = matcher.group();
                System.out.println(code);

            }
        }
        return code;
    }

    public String matchResult(String cont, String mat) {
        String info = null;
        Matcher m = null;


        Pattern p = Pattern.compile(mat);
        m = p.matcher(cont);
        if (m.find()) {
            info = m.group();
        }
//            if (i != null)
//                info = m.group(i);
//            else
//                info = m.group();


        return info;
    }


    public boolean matchResult1(String cont, String mat) {
        boolean flag = false;
        Matcher m = null;
        try {
            Pattern p = Pattern.compile(mat);
            m = p.matcher(cont);
            // flag = m.matches();
            // while(m.find()){
            // flag = true;
            // }
            if (m.find())
                flag = true;
        } catch (Exception e) {
            flag = false;
        }
        System.out.println("子匹配数【以()为组进行数量统计】：" + m.groupCount());
        return flag;
    }
}
