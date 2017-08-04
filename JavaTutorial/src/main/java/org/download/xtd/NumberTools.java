package org.download.xtd;

/**
 * 彩票公共工具类
 * @author yuijnshui@lxfintech.com
 * @Title: NumberTools
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/3上午10:25
 */

public class NumberTools {

    /**
     * 截取结果值个数
     * @param inputValue 输入值
     * @param startNum   截取开始位置(万，千，百，十，个 5 4 3 2 1)
     * @param count      截取个数(1 2 3 4 5)
     * @return
     */
    public static String getSubNum(String inputValue, int startNum, int count) {

        String value = inputValue.substring(inputValue.length()-startNum,inputValue.length()-(startNum-count));
        return value;
    }
}
