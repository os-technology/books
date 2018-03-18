package org.JavaTutorial.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Tmp
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/10/9上午10:48
 */

public class Tmp {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getPrefixDate(int count) {
        Calendar cal = Calendar.getInstance();
        int day = 0 - count;
        cal.add(Calendar.DATE, day);   // int amount   代表天数
        Date datNew = cal.getTime();
        return sdf.format(datNew);
    }
}
