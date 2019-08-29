package org.number;

import java.util.Calendar;

/**
 * @author code
 * @Title: MonthTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/2911:09 AM
 */
public class MonthTest {
    /**
     * @param args
     */
    public static void main(String[] args) {

        int month = 2;
        int year = 2013;
        int numDays = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default:
                System.out.println("Invalid month.");
                break;
        }
        System.out.println("Number of Days = " + numDays);
    }

    private void days(){
        int year=2013,month=2;
        Calendar a = Calendar.getInstance();

        a.set(Calendar.YEAR, year);

        a.set(Calendar.MONTH, month - 1);

        a.set(Calendar.DATE, 1);//把日期设置为当月第一天

        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天

        int maxDate = a.get(Calendar.DATE);

        System.out.println(maxDate);
    }
}
