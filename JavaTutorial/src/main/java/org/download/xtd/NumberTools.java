package org.download.xtd;

import org.download.xtd.params.PrintDataBean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 彩票公共工具类
 *
 * @author yuijnshui@lxfintech.com
 * @Title: NumberTools
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/3上午10:25
 */

public class NumberTools {


    /**
     * 获取彩票名称
     *
     * @param typeName
     * @return
     */
    public static String caiPiaoName(String typeName) {
        Map<String, String> typeList = new HashMap<>();
        typeList.put("111", "天地分分彩");
        typeList.put("113", "天地三分彩");
        typeList.put("115", "天地五分彩");
        typeList.put("110", "天地半分彩");
        typeList.put("119", "天地1.5分彩");
        typeList.put("100", "天地秒秒彩");
        typeList.put("101", "重庆时时彩");
        typeList.put("103", "天津时时彩");
        typeList.put("104", "新疆时时彩");
        typeList.put("181", "北京5分彩");
        typeList.put("182", "台湾5分彩");
        typeList.put("331", "江苏快3");
        typeList.put("332", "安徽快3");
        typeList.put("333", "吉林快3");
        typeList.put("1001", "北京赛车PK拾");
        typeList.put("555", "天地十一选五");
        typeList.put("501", "广东十一选五");
        typeList.put("502", "山东十一选五");
        typeList.put("504", "江西十一选五");
        typeList.put("505", "上海十一选五");
        typeList.put("506", "安徽十一选五");
        typeList.put("803", "重庆快乐十分彩");
        typeList.put("801", "广东快乐十分彩");
        typeList.put("802", "天津快乐十分彩");
        typeList.put("303", "上海时时乐");
        typeList.put("301", "福彩3D");
        typeList.put("302", "排列3");
        typeList.put("362", "台湾5分3D");

        return typeList.get(typeName);
    }


    /**
     * 倍投金额计算
     *
     * @param init     首次投入金额
     * @param multiple 倍数
     * @return
     */
    public static double getCalResult(BigDecimal init, int multiple) {
        BigDecimal result = init.multiply(new BigDecimal(multiple));
        return result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param printResult
     * @param bean        数据输出bean
     */
    public static void print(StringBuilder printResult, PrintDataBean bean) {
        if (printResult == null || bean == null) {
            System.out.println("请求参数为null，请检查");
            return;
        }
        printResult.append("彩票类型：" + NumberTools.caiPiaoName(bean.getCaiPiaoCode())).append("\n");

        printResult.append("本次统计期数：" + bean.getStageNum() + "期").append("\n");
        if (bean.getMaxMoney() != null && bean.getMaxMoney().intValue() != 0) {
            printResult.append("最大倍投金额(仅针对两个号码不同的情况得出的结果)：" + getMoneyString(bean.getMaxMoney())).append("\n");
        }
        if (bean.getMaxWinTime() != null && bean.getMaxWinTime() != 0) {
            printResult.append("最大连赢次数：" + bean.getMaxWinTime()).append("\n");
        }
        printResult.append("最大连挂次数：" + bean.getMaxLoseTime()).append("\n");
        printResult.append("总赢次数：" + bean.getAllWinTime()).append("\n");
        printResult.append("总输次数：" + bean.getAllLoseTime()).append("\n");
        if (bean.getIncomeMoney() != null && bean.getIncomeMoney().intValue() != 0) {
            printResult.append("总收益：" + getMoneyString(bean.getIncomeMoney())).append("\n");
        }
    }


    /**
     * 两个数字以上的比对操作
     * 不相同，true，相同，false
     *
     * @param init
     * @param compare
     * @return
     */
    public static boolean compareArrayNumberIsTrue(String init, String compare) {
        char[] charValue = init.toCharArray();
        boolean bool = false;
        for (char ch : charValue) {
            if (compare.contains(ch + "")) {
                bool = false;
                break;
            } else {
                bool = true;
            }
        }
        return bool;
    }


    /**
     * 倍投组合类型
     *
     * @param t
     * @return
     */
    public static int[] getMultipleType(int t) {
        return getMultipleType(t, true);
    }

    /**
     * 倍投组合类型
     * 单倍计算的输赢算法还有问题，需要处理
     *
     * @param t
     * @param multiple
     * @return
     */
    public static int[] getMultipleType(int t, boolean multiple) {
        if (multiple) {
            return getMultiple(t);
        } else {
            return getSingle(t);
        }
    }

    /**
     * 单倍投注结果
     */
    public static int[] getSingle(int t) {
        int[] multi = new int[t];
        for (int i = 0; i < t; i++) {
            multi[i] = 1;
        }
        return multi;
    }

    /**
     * {1,2,6,18,54,162,486}
     *
     * @param t 倍投次数
     * @return
     */
    public static int[] getMultiple(int t) {
        int[] multi = new int[t];
        for (int i = 0; i < t; i++) {
            if (i == 0) {
                multi[i] = 1;
            } else if (i == 1) {
                multi[i] = 2;
            } else {
                multi[i] = multi[i - 1] * 3;
            }
        }
        return multi;
    }

    /**
     * 金额转换为double类型
     *
     * @param inputMoney
     * @return
     */
    public static double getMoneyString(BigDecimal inputMoney) {
        if (inputMoney == null) {
            System.out.println("请求参数为空，返回0");
            return 0;
        }
        return inputMoney.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 选位
     *
     * @param in 1 2 3 4 5 个 十 百 千 万
     * @return
     */
    public static String getNumLocation(int in) {
        String[] numArray = {"个位", "十位", "百位", "千位", "万位"};
        return numArray[in - 1];
    }

    /**
     * 截取结果值个数
     *
     * @param inputValue 输入值
     * @param startNum   截取开始位置(万，千，百，十，个 5 4 3 2 1)
     * @param count      截取个数(1 2 3 4 5)
     * @return
     */
    public static String getSubNum(String inputValue, int startNum, int count) {

        String value = inputValue.substring(inputValue.length() - startNum, inputValue.length() - (startNum - count));
        return value;
    }
}
