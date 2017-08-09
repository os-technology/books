package org.download.xtd;

import org.download.xtd.params.PrintDataBean;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 后二规则测试
 *
 * @author yuijnshui@lxfintech.com
 * @Title: HouErZhiXuanRuleTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/3上午9:57
 */

public class HouErZhiXuanRuleTest {
    /**
     * 后二复式大底
     * 使用方法：个位与十位不包含2367定位胆即可投注
     *
     * @return
     */
    private String getFuShiDaDiString() {

        return "00 04 05 06 07 08 10 11 15 16 19 23 24 25 26 29 33 35 38 42 43 44 45 47 48 51 55 56 57 58 59 60 63 64 65 69 72 73 74 75 77 80 82 83 84 87 88 89 90 91 92 97";
//        return "00 01 04 06 07 10 12 13 14 15 16 17 18 19 20 24 26 27 30 31 32 33 35 36 37 39 41 42 43 44 45 46 47 48 50 51 52 53 54 55 59 61 62 63 64 65 66 67 68 71 73 74 75 76 78 79 80 82 83 85 86 87 89 91 92 93 96 97 98 99";
//        return "02,03,06,07,12,13,16,17," +
//                "20,21,22,23,24,25,26,27," +
//                "28,29,30,31,32,33,34,35," +
//                "36,37,38,39,42,43,46,47," +
//                "52,53,56,57,60,61,62,63," +
//                "64,65,66,67,68,69,70,71," +
//                "72,73,74,75,76,77,78,79," +
//                "82,83,86,87,92,93,96,97";
    }

    @Test
    public void test_HouerZhiXuanFenFenCai_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        compare_HouerZhiXuan_NumResult(mats, "111",new BigDecimal(0.1));
    }

    @Test
    public void test_HouerZhiXuanShiShiCai_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        compare_HouerZhiXuan_NumResult(mats, "101",new BigDecimal(0.1));
    }


    /**
     * 台湾五分彩
     */
    @Test
    public void test_TaiWanWuFenCai_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getWufenMatArray();
        compare_HouerZhiXuan_NumResult(mats, "182",new BigDecimal(0.1));
    }







    /**
     * 后二单式直选大底数据比对结果
     *
     * @param mats
     * @param caiPiaoCode 彩票编码
     *                    @param moneyPattern 金额模式，1，0.1，0.01，0.001
     *
     */
    private void compare_HouerZhiXuan_NumResult(String[] mats, String caiPiaoCode,BigDecimal moneyPattern) {

        StringBuilder dataBuilder = new StringBuilder();
        StringBuilder printResult = new StringBuilder();


        int multiple[] = NumberTools.getMultipleType(10);//倍投倍数值
        String[] numArray = getFuShiDaDiString().split(",| ");
        BigDecimal initMoney = new BigDecimal(2).multiply(moneyPattern).multiply(new BigDecimal(numArray.length));;//初始投入金额
        BigDecimal winMoney = new BigDecimal(19.4).multiply(moneyPattern).multiply(new BigDecimal(10));//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//净利润金额
        int time = 0;//倍投下标
        double maxMoney = 0;//最大投入金额
        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        int allWinTime = 0;//本次统计总赢次数
        int allLoseTime = 0;//本次统计总的输次数
        for (int m = 0; m < mats.length - 1; m++) {
            String tmpData = "";
            String nums = NumberTools.getSubNum(mats[m], 2, 2);
            if (getFuShiDaDiString().contains(nums)) {//赢

                if (time > 0) {
                    double inputMoney = NumberTools.getCalResult(initMoney, multiple[time]);
                    maxMoney = maxMoney > inputMoney ? maxMoney : inputMoney;
                    tmpData = mats[m] + "  赢 1  " + inputMoney + "  "
                            + NumberTools.getMoneyString((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));
                    //盈利计算
                    incomeMoney = incomeMoney.add((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                } else {

                    tmpData = mats[m] + "  赢 1  "+ NumberTools.getMoneyString(initMoney) + "  " + NumberTools.getMoneyString(winMoney.subtract(initMoney));
                    //盈利计算
                    incomeMoney = incomeMoney.add(winMoney.subtract(initMoney));
                }
                //后续标识操作
                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
                tmpLoseTime = 0;

                time = 0;
                tmpWinTime++;
                allWinTime++;
            } else {//输
                tmpData = mats[m] + "  输 0  "+ NumberTools.getCalResult(initMoney, multiple[time]);

                //数值处理
                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;
                tmpWinTime = 0;
                time++;
                tmpLoseTime++;
                allLoseTime++;
            }
            dataBuilder.append(tmpData).append("\n");
        }
        PrintDataBean bean = new PrintDataBean();
        bean.setCaiPiaoCode(caiPiaoCode)
                .setInitMoney(initMoney)
                .setWinMoney(winMoney)
                .setAllLoseTime(allLoseTime)
                .setAllWinTime(allWinTime)
                .setIncomeMoney(incomeMoney)
                .setMaxLoseTime(maxLoseTime)
                .setMaxWinTime(maxWinTime)
                .setMaxMoney(new BigDecimal(maxMoney))
                .setStageNum(mats.length);

        printResult.append("投注模式：后二直选单式：" + getFuShiDaDiString()).append("\n").append("\n");
        printResult.append("注数：" + getFuShiDaDiString().split(",| ").length).append("\n").append("\n");

        NumberTools.print(printResult, bean);
        System.out.println(dataBuilder);
        System.out.println(printResult);
    }



    /**
     * 个位与十位不包含的数字内容
     *
     * @return
     */
    private String getLostNum() {
        return "2367";
    }

}
