package org.htmltranslate.xtd;

import org.htmltranslate.xtd.params.PrintDataBean;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 三星复式
 *
 * @author yuijnshui@lxfintech.com
 * @Title: ThreeStarCompoundTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/14上午10:12
 */

public class ThreeStarCompoundTest {

    /**
     * 天地分分彩
     */
    @Test
    public void testFenFenCaiZuThreeHtml() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        handleNumList(mats, "111", 4,2);
    }

    @Test
    public void testFenFenCaiZuSixHtml() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        handleNumList(mats, "111", 4,3);
    }

    /**
     * 台湾五分彩
     */
    @Test
    public void testTaiWanWuFenCaiHtml() {
        String[] mats = XTDHtmlStringTranslateUtil.getWufenMatArray();
        handleNumList(mats, "182", 5,3);
    }


    /**
     * 分类判断处理
     *
     * @param mats        出号数据
     * @param caipiaoCode 彩票名称编码
     * @param location    号码位置
     */
    private void handleNumList(String[] mats, String caipiaoCode, int location,int arrayLen) {

        handleNumList(mats, caipiaoCode, location, "43", new BigDecimal(0.1),arrayLen);
    }

    /**
     * 详细处理
     *
     * @param mats         出号数据
     * @param caipiaoCode  彩票名称编码
     * @param location     号码位置
     * @param playTypeCode 彩票选法编码
     */
    private void handleNumList(String[] mats, String caipiaoCode, int location, String playTypeCode, BigDecimal moneyPattern,int arrayLen) {

        StringBuilder dataBuilder = new StringBuilder();
        StringBuilder printResult = new StringBuilder();


        //倍率数组
        int multiple[] = arrayLen==2?NumberTools.getThreeStarArrayThreeModel()//组三
                :NumberTools.getThreeStarArraySixModel();//组六

        BigDecimal initMoney = arrayLen==2?new BigDecimal(180).multiply(moneyPattern)
                :new BigDecimal(240).multiply(moneyPattern);
        BigDecimal winMoney = arrayLen==2?new BigDecimal(646.67).multiply(moneyPattern)
                :new BigDecimal(323.34).multiply(moneyPattern);//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//净利润金额
        int time = 0;//倍投下标
        double maxMoney = 0;//最大投入金额
        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        int allWinTime = 0;//本次统计总赢次数
        int allLoseTime = 0;//本次统计总的输次数

        for (String mat : mats) {
            if (multiple.length<=time){
                System.out.println("超出最大倍投，不适合投注，不再继续统计");
                break;
            }
            String tmpData = "";
            String num = NumberTools.getSubNum(mat, location, 3);
            boolean result =false;
            if (arrayLen==2) {//组三
                  result = NumberTools.getLengthTwo(num);
            }else {//组六
                  result = NumberTools.getLengthThree(num);
            }
            if (result) {

                //每次盈利计算
                BigDecimal tmpIncomeMoney = winMoney.multiply(new BigDecimal(multiple[time])).subtract(initMoney.multiply(NumberTools.multiplePlus(time, multiple)));

                double inputMoney = NumberTools.getCalResult(initMoney, multiple[time]);
                maxMoney = maxMoney > inputMoney ? maxMoney : inputMoney;


                tmpData = mat + "  赢 1  " + inputMoney + "  "
                        + NumberTools.getMoneyString(tmpIncomeMoney);
                //总盈利计算
                incomeMoney = incomeMoney.add(tmpIncomeMoney);

                //后续标识操作

                tmpLoseTime = 0;

                time = 0;
                tmpWinTime++;
                allWinTime++;

                //数值处理
                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;
            } else {
                double tmpLoseMoney = NumberTools.getCalResult(initMoney, multiple[time]);
                tmpData = mat + "  输 " + tmpLoseMoney;

                tmpWinTime = 0;
                time++;
                tmpLoseTime++;
                allLoseTime++;

                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
            }
            dataBuilder.append(tmpData).append("\n");
        }

        PrintDataBean bean = new PrintDataBean();
        bean.setCaiPiaoCode(caipiaoCode)
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

        printResult.append("投注模式：" + NumberTools.getPlaySelectType(playTypeCode)).append("\n");
//        printResult.append("注数：" + getFuShiDaDiString().split(",| ").length).append("\n").append("\n");

        NumberTools.print(printResult, bean);
        System.out.println(dataBuilder);
        System.out.println(printResult);


    }
}
