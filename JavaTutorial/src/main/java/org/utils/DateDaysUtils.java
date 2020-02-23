package org.utils;

import java.util.Calendar;

/**
 * @author code
 * @Title: DateDaysUtils
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/2/227:46 PM
 */
public class DateDaysUtils {
    /**
     * java得到指定年所在月份的天数
     *
     * @param args
     */
    public static void main(String[] args) {
        int year = 2020, month = 2;
        Calendar a = Calendar.getInstance();

        a.set(Calendar.YEAR, year);

        a.set(Calendar.MONTH, month - 1);

        a.set(Calendar.DATE, 1);//把日期设置为当月第一天

        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天

        int maxDate = a.get(Calendar.DATE);

        System.out.println(maxDate);
    }
}
