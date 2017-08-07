package org.download.xtd;

import org.download.xtd.params.PrintDataBean;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 后二复式杀个位十位两个数字规则
 *
 * @author yuijnshui@lxfintech.com
 * @Title: HouerFuShiKillTwoNumTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/7/30下午12:06
 */

public class HouerFuShiKillTwoNumTest {


    @Test
    public void testFenFenCaiHtml() {

        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        houerFuShiKillTwoNum(mats, "111",5);
    }

    @Test
    public void testTaiWanWuFenCaiHtml() {
        String[] mats = XTDHtmlStringTranslateUtil.getWufenMatArray();
        houerFuShiKillTwoNum(mats, "182",2);
    }


    /**
     * 后二复式杀号
     */
    private void houerFuShiKillTwoNum(String[] mats, String caiPiaoCode,int location) {
        StringBuilder dataBuilder = new StringBuilder();//数据builder
        StringBuilder printResult = new StringBuilder();//打印统计结果展示builder

        dataBuilder.append(mats[0] + "  " + "初始数据").append("\n");

        int multiple[] = NumberTools.getMultipleType(10);//倍投倍数值，单倍计算的输赢算法还有问题，需要处理
        /**********/
        int time = 0;//倍投下标
        double maxMoney = 0;//最大投入金额
        BigDecimal initMoney = new BigDecimal(12.8);//初始投入金额
        BigDecimal winMoney = new BigDecimal(19.4);//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//净利润金额
        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        int allWinTime = 0;//本次统计总赢次数
        int allLoseTime = 0;//本次统计总的输次数
        /************/
        for (int m = 0; m < mats.length - 1; m++) {
            String init = NumberTools.getSubNum(mats[m], location, 2);
            String compare = NumberTools.getSubNum(mats[m + 1], location, 2);
            String tmpData = "";
            if (NumberTools.compareArrayNumberIsTrue(init, compare)) {//赢

                if (time > 0) {
                    double inputMoney = NumberTools.getCalResult(initMoney, multiple[time]);
                    maxMoney = maxMoney > inputMoney ? maxMoney : inputMoney;

                    tmpData = mats[m + 1] + "  " + "赢  1   " + inputMoney + "    "
                            + NumberTools.getMoneyString((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                    //盈利计算
                    incomeMoney = incomeMoney.add((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                } else {
                    tmpData = mats[m + 1] + "  " + "赢  1   " + NumberTools.getMoneyString(initMoney) + "    " + NumberTools.getMoneyString(winMoney.subtract(initMoney));
                    //盈利计算
                    incomeMoney = incomeMoney.add(winMoney.subtract(initMoney));
                }

                //数值操作

                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
                time = 0;
                tmpLoseTime = 0;
                allWinTime++;
                tmpWinTime++;

            } else {//输
                tmpData = mats[m + 1] + "  " + "输  0   " + NumberTools.getCalResult(initMoney, multiple[time]);

                //数值处理

                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;
                tmpWinTime = 0;
                time++;
                allLoseTime++;
                tmpLoseTime++;
            }
            dataBuilder.append(tmpData + "\n");

        }
        printResult.append("规则：后二复式，杀个位十位号码，投注共64注").append("\n");


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

        //封装打印的统计展示数据
        NumberTools.print(printResult, bean);

        System.out.println(dataBuilder);
        System.out.println(printResult);
    }


}
