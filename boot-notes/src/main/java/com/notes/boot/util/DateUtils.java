package com.notes.boot.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xiaowei.wang on 2016/5/12.
 */
public class DateUtils {

    public static final String formatPattern = "yyyy-MM-dd";
    public static final String formatMs = "yyyyMMddHHmmssSSS";
    public static final String dateTime = "yyyyMMddHHmmss";

    public static final String dateFormat = "yyyyMMdd";

//    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String formatPattern_full = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前日期
     * @return
     */
    public static String getCurrentDate(){
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        return format.format(new Date());
    }

    /**
     * 锁对象
     */
    private static final Object lockObj = new Object();

    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();


    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    System.out.println("put new sdf of pattern " + pattern + " to map");

                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {

                        @Override
                        protected SimpleDateFormat initialValue() {
                            System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }
    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }



    /**
     *
     * 获取前几天的日期
     */
    public static String getPrefixDate(int count){
        Calendar cal = Calendar.getInstance();
        int day = 0 - count;
        cal.add(Calendar.DATE,day);   // int amount   代表天数
        Date datNew = cal.getTime();
        return getSdf(formatPattern_full).format(datNew);
    }
    /**
     * 日期转换成字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date, String formatPattern){
        if(StringUtils.isEmpty(formatPattern)){
            formatPattern = dateFormat;
        }

        return getSdf(formatPattern).format(date);
    }

    public static String dateToString(String formatPattern){
        return dateToString(new Date(),formatPattern);
    }
    /**
     * 日期转换成字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        if(date==null)
            return  null;
        return getSdf(formatPattern_full).format(date);
    }

    /**
     * 字符串转换日期
     * @param str
     * @return
     */
    public static Date stringToDate(String str){
        //str =  " 2008-07-10 19:20:00 " 格式

        if(StringUtils.hasText(str)){
            try {
                return getSdf(formatPattern).parse(str);
            } catch (ParseException e) {
                LogPortal.error("异常信息是:",e);;
            }
        }
        return null;
    }

    /**
     * 字符串转换日期
     * @param str
     * @return
     */
    public static Date str2DateByFormat(String str, String format){
        //str =  " 2008-07-10 19:20:00 " 格式

        if(StringUtils.hasText(str)){
            try {
                return getSdf(format).parse(str);
            } catch (ParseException e) {
                LogPortal.error("异常信息是:",e);;
            }
        }
        return null;
    }

    /**
     * 获取给定时间的哪一天的起始时间yyyy-MM-dd 00:00:00
     * @param date
     * @return
     */
    public static Date getDayStart(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取给定时间的哪一天的结束时间yyyy-MM-dd 23:59:59
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    public static Date longStringToDate(String time) {
        Date date = new Date();
        date.setTime(Long.parseLong(time));
        return date;
    }

    public static Date longStringToDateEnd(String time) {
        Calendar cl = Calendar.getInstance();
        cl.setTimeInMillis(Long.parseLong(time));

        cl.set(Calendar.HOUR_OF_DAY, 23);
        cl.set(Calendar.MINUTE, 59);
        cl.set(Calendar.SECOND, 59);

        return cl.getTime();
    }

    public static String long2FormatString(Long time){
        if(null == time){
            return "";
        }
        return getSdf(formatPattern_full).format(new Date(time));
    }

    public static String long2FormatString(Object time){
        if(null == time){
            return "";
        }
        if("".equals(time.toString())){
            return "";
        }
        return getSdf(formatPattern_full).format(new Date(Long.parseLong(time.toString())));
    }

    /**
     * 获取指定间隔前几年的起始时间
     * @param i
     * @return
     */
    public static Date getDayBeforeYear(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.YEAR, -i);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public static Date getDayBeforeMonth(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.MONTH, -i);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public static Date getDayBeforeDay(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.DAY_OF_YEAR, -i);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * @Author: shane
     * @Time: 2017/2/9 14:54
     * @Email: shanbaohua@lxfintech.com
     * @param: Date generateTime
     * @Return: Integer
     * @Throw:
     * @Desc: 将Date转换为年月日的Integer类型。e.g.2017-02-09 14:55:00 ==> 20170209
     */
    public static Integer dateToInteger(Date generateTime) {
        if (null == generateTime) {
            return null;
        }
        try {
            return Integer.parseInt(getSdf(dateFormat).format(generateTime));
        } catch (Exception e) {
            LogPortal.error("dateToIntegerError, {}", e, generateTime);
            return null;
        }
    }

    /**
     * 将日期按照指定的格式转换为Long类型
     * @param generateTime
     * @param date2LongFormat
     * @return
     */
    public static Long dateToLong(Date generateTime, String date2LongFormat) {
        if (null == generateTime) {
            return null;
        }
        if(null == date2LongFormat){
            date2LongFormat = dateFormat;
        }
        try {
            return Long.valueOf(new SimpleDateFormat(date2LongFormat).format(generateTime));
        } catch (Exception e) {
            LogPortal.error("dateToLongError, {}", e, generateTime);
            return null;
        }
    }

    public static List<Integer> getBetweenInteger(Date start, Date stop) {
        List<Integer> list = new ArrayList<>();

        Calendar begin = Calendar.getInstance();
        begin.setTime(start);
        Calendar end = Calendar.getInstance();
        end.setTime(stop);

        while (end.compareTo(begin) >= 0) {
            list.add(dateToInteger(begin.getTime()));
            begin.add(Calendar.DAY_OF_MONTH, 1);
        }
        return list;
    }

    /**
     * 获取当前日期
     * @return
     */
    public static Date getNowDate(){
        Date date = new Date();
        return date;
    }

}
