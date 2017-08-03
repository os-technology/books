package org.download.xtd;

import org.download.util.HtmlFilterDataRequest;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: XtdNumberUtilTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/30下午12:06
 */

public class XtdNumberUtilTest {


    @Test
    public void testGetCaiPiaoHtml() {


        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
//        houerFuShiKillTwoNum(mats);
        fixNum(mats,1,"34567",null);
    }

    /**
     * 后二复式杀号
     */
    private void houerFuShiKillTwoNum(String[] mats) {
        System.out.println(mats[0] + "  " + "初始数据");

        int time = 0;//倍投下标
        int multiple[] = getMultipleType(10, true);//倍投倍数值，单倍计算的输赢算法还有问题，需要处理
        double maxMoney = 0;//最大投入金额
        BigDecimal initMoney = new BigDecimal(1.28);//初始投入金额
        BigDecimal winMoney = new BigDecimal(1.94);//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//净利润金额
        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        int allWinTime = 0;//本次统计总赢次数
        int allLoseTime = 0;//本次统计总的输次数
        for (int m = 0; m < mats.length - 1; m++) {
            String init = getSubNum(mats[m],2,2);
            String compare = getSubNum(mats[m+1],2,2);

            if (compareNumberIsTrue(init, compare)) {//赢
                allWinTime++;

                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
                if (time > 0) {
                    double inputMoney = getCalResult(initMoney.doubleValue(), multiple[time]);
                    maxMoney = maxMoney > inputMoney ? maxMoney : inputMoney;
                    System.out.println(mats[m + 1] + "  " + "赢  1   " + inputMoney + "    "
                            + getMoneyString((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time]))));
                    //盈利计算
                    incomeMoney = incomeMoney.add((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                } else {
                    System.out.println(mats[m + 1] + "  " + "赢  1   " + getMoneyString(initMoney) + "    " + getMoneyString(winMoney.subtract(initMoney)));
                    //盈利计算
                    incomeMoney = incomeMoney.add(winMoney.subtract(initMoney));
                }

                //重置操作
                time = 0;
                tmpWinTime++;
                tmpLoseTime = 0;
            } else {//输
                allLoseTime++;

                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;

                System.out.println(mats[m + 1] + "  " + "输  0   " + getCalResult(initMoney.doubleValue(), multiple[time]));
                time++;
                tmpWinTime = 0;
                tmpLoseTime++;
            }

        }
        printResult(maxMoney, incomeMoney, maxWinTime, maxLoseTime, allWinTime, allLoseTime);
    }

    private void printResult(double maxMoney, BigDecimal incomeMoney, int maxWinTime, int maxLoseTime, int allWinTime, int allLoseTime) {
        System.out.println("最大倍投金额(仅针对两个号码不同的情况得出的结果)：" + maxMoney);
        System.out.println("最大连赢次数：" + maxWinTime);
        System.out.println("最大连挂次数：" + maxLoseTime);
        System.out.println("总赢次数：" + allWinTime);
        System.out.println("总输次数：" + allLoseTime);
        System.out.println("总收益：" + getMoneyString(incomeMoney));
    }

    /**
     * 截取结果值个数
     * @param inputValue 输入值
     * @param startNum   截取开始位置(万，千，百，十，个 5 4 3 2 1)
     * @param count      截取个数(1 2 3 4 5)
     * @return
     */
    private String getSubNum(String inputValue, int startNum, int count) {

        String value = inputValue.substring(inputValue.length()-startNum,inputValue.length()-(startNum-count));
        return value;
    }

    @Test
    public void testgetSubNum(){
        System.out.println(getSubNum("12345",2,2));
    }

    /**
     * 定码投注
     *
     * @param mats          开奖号码数组
     * @param location      定码位置(5，4，3，2，1 万，千，百，十，个)
     * @param array         选码数值组合
     * @param multipleArray 倍数数组
     */
    private void fixNum(String[] mats, int location, String array, int[] multipleArray) {

        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        for (String mat:mats){
            String value = getSubNum(mat,location,1);
            if (array.contains(value)){//赢

                System.out.println(mat+" 赢 ");

                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
                tmpWinTime++;
                tmpLoseTime = 0;
            }else{
                System.out.println(mat+" 输 ");

                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;
                tmpWinTime = 0;
                tmpLoseTime++;
            }
        }
        System.out.println("固定数字投注模式  投注数字："+array);
        System.out.println("最大连赢次数：" + maxWinTime);
        System.out.println("最大连挂次数：" + maxLoseTime);
    }


    /**
     * 倍投组合类型
     *
     * @param t
     * @param multiple
     * @return
     */
    private int[] getMultipleType(int t, boolean multiple) {
        if (multiple) {
            return getMultiple(t);
        } else {
            return getSingle(t);
        }
    }

    /**
     * 单倍投注结果
     */
    private int[] getSingle(int t) {
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
    private int[] getMultiple(int t) {
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
     * 倍投计算
     */
    private double getCalResult(double init, double multiple) {
        BigDecimal result = new BigDecimal(init).multiply(new BigDecimal(multiple));
        return result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //不相同，true，相同，false
    private boolean compareNumberIsTrue(String init, String compare) {
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

    private double getMoneyString(BigDecimal inputMoney) {
        return inputMoney.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }



    public HtmlFilterDataRequest getValueCaiPiao() {

        HtmlFilterDataRequest request = new HtmlFilterDataRequest();

        request.setUrl("http://www.fzbyy.cc/Dianshiju/146089.html")
                .setUrlPageSuffix("")
                .setHtmlStartRange("<table id=\"tltview\" style=\"width:1688px; \" border=\"1\" cellspacing=\"0\" cellpadding=\"3\">")
                .setHtmlEndRange("<script type=\"text/javascript\">")
                .setTranslateStart("<td class=\"ylfx_kjhm\"><div class=\"ball_color3\">")
                .setTranslateEnd("</div></td>");


        return request;
    }


}
