package org.htmltranslate.xtd;

import org.htmltranslate.xtd.params.PrintDataBean;
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
        houerFuShiKillTwoNum(mats,"111", 5);
    }

    public void houerFuShiKillTwoNum(String[] mats,String caipiaoCode, int location) {
        if (location == 2) {
            houerFuShiKillTwoNum(mats, caipiaoCode, location, "11");
        } else if (location == 5) {
            houerFuShiKillTwoNum(mats, caipiaoCode, location, "01");
        }
    }

    @Test
    public void testShiShiCaiHtml() {

        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        houerFuShiKillTwoNum(mats,"101", 2);
    }

    /**
     * 台湾五分彩
     */
    @Test
    public void testTaiWanWuFenCaiHtml() {
        String[] mats = XTDHtmlStringTranslateUtil.getTaiWanWufenMatArray();
        houerFuShiKillTwoNum(mats,"182", 5);
    }

    /**
     * 北京PK10
     */
    @Test
    public void testBeiJingPK10_Html() {
        String[] mats = XTDHtmlStringTranslateUtil.getPKMatArray();
        for (String mat:mats){
            System.out.println(mat);
        }
//        houerFuShiKillTwoNum(mats,"1001", 2);
    }
    /**
     * 后二复式杀号
     *
     * @param mats        出号数组
     * @param caiPiaoCode 彩票类型编码
     * @param location    选号位置
     */
    private void houerFuShiKillTwoNum(String[] mats, String caiPiaoCode, int location, String playTypeCode) {
        StringBuilder dataBuilder = new StringBuilder();//数据builder
        StringBuilder printResult = new StringBuilder();//打印统计结果展示builder

        dataBuilder.append(mats[0] + "  " + "初始数据").append("\n");

        int multiple[] = NumberTools.getMultipleType(12);//倍投倍数值，单倍计算的输赢算法还有问题，需要处理
        /**********/
        int time = 0;//倍投下标
        double maxMoney = 0;//最大投入金额
        BigDecimal initMoney = new BigDecimal(1.28);//初始投入金额
        BigDecimal winMoney = new BigDecimal(1.94);//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//净利润金额
        BigDecimal tmpAllWinMoney = new BigDecimal(0);//临时盈利总金额
        BigDecimal tmpAllLoseMoney = new BigDecimal(0);//临时输掉总金额


        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        int allWinTime = 0;//本次统计总赢次数
        int allLoseTime = 0;//本次统计总的输次数
        /************/
        for (int m = 0; m < mats.length - 1; m++) {
            if (multiple.length<=time){
                System.out.println("超出最大倍投，不适合投注");
                break;
            }
            BigDecimal tmpWinMoney = null;
            BigDecimal tmpLoseMoney = null;


            String init = NumberTools.getSubNum(mats[m], location, 2);
            String compare = NumberTools.getSubNum(mats[m + 1], location, 2);
            String tmpData = "";
            if (NumberTools.compareArrayNumberIsTrue(init, compare)) {//赢

                if (time > 0) {
                    double inputMoney = NumberTools.getCalResult(initMoney, multiple[time]);
                    maxMoney = maxMoney > inputMoney ? maxMoney : inputMoney;

                    tmpWinMoney = winMoney.multiply(new BigDecimal(multiple[time]));
                    tmpLoseMoney = initMoney.multiply(new BigDecimal(multiple[time]));


                    tmpData = mats[m + 1] + "  " + "赢  1   " + inputMoney + "    "
                            + NumberTools.getMoneyString((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                    //盈利计算
                    incomeMoney = incomeMoney.add((winMoney.subtract(initMoney).subtract(initMoney.divide(new BigDecimal(2)))).multiply(new BigDecimal(multiple[time])));

                } else {
                    tmpWinMoney = winMoney;
                    tmpLoseMoney = initMoney;


                    tmpData = mats[m + 1] + "  " + "赢  1   " + NumberTools.getMoneyString(initMoney) + "    " + NumberTools.getMoneyString(winMoney.subtract(initMoney));
                    //盈利计算
                    incomeMoney = incomeMoney.add(winMoney.subtract(initMoney));
                }
                //临时赢取总金额
                tmpAllWinMoney = tmpAllWinMoney.add(tmpWinMoney);
                //数值操作

                time = 0;
                tmpLoseTime = 0;
                allWinTime++;
                tmpWinTime++;

                //数值处理
                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;

            } else {//输
                double thisLoseMoney =NumberTools.getCalResult(initMoney, multiple[time]);

                        tmpData = mats[m + 1] + "  " + "输  0   " + thisLoseMoney;

                tmpLoseMoney = new BigDecimal(thisLoseMoney);


                tmpWinTime = 0;
                time++;
                allLoseTime++;
                tmpLoseTime++;

                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
            }

            tmpAllLoseMoney= tmpAllLoseMoney.add(tmpLoseMoney);

            dataBuilder.append(tmpData + "\n");

        }
        printResult.append("规则：" + NumberTools.getPlaySelectType(playTypeCode) + "，杀" + NumberTools.getPlayCase(Integer.valueOf(playTypeCode)) + "号码，投注共64注").append("\n");


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
                .setMultipleModel(multiple)
                .setStageNum(mats.length);

        //封装打印的统计展示数据
        NumberTools.print(printResult, bean);

        System.out.println(dataBuilder);
        System.out.println(printResult);
    }


}
