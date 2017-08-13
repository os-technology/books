package org.download.xtd;

import org.download.xtd.params.PrintDataBean;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 五星组选60，只有一个数字重复
 *
 * @author yuijnshui@lxfintech.com
 * @Title: FiveStarGroupThreeTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/10下午6:54
 */

public class FiveStarGroupThreeTest {


    @Test
    public void test_FenFenCai_Star() {
//NumberTools
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        handleNumList(mats, "111", 5);
    }

    /**
     * 分类判断处理
     *
     * @param mats        出号数据
     * @param caipiaoCode 彩票名称编码
     * @param location    号码位置
     */
    private void handleNumList(String[] mats, String caipiaoCode, int location) {
        if (location == 2) {
            handleNumList(mats, caipiaoCode, location, "100", new BigDecimal(0.01));
        } else if (location == 5) {
            handleNumList(mats, caipiaoCode, location, "100", new BigDecimal(0.01));
        }
    }

    /**
     * 详细处理
     *
     * @param mats         出号数据
     * @param caipiaoCode  彩票名称编码
     * @param location     号码位置
     * @param playTypeCode 彩票选法编码
     */
    private void handleNumList(String[] mats, String caipiaoCode, int location, String playTypeCode, BigDecimal moneyPattern) {

        StringBuilder dataBuilder = new StringBuilder();
        StringBuilder printResult = new StringBuilder();


        int multiple[] = NumberTools.getFiveStarSixtyModel();//倍投倍数值

        BigDecimal initMoney = new BigDecimal(1680).multiply(moneyPattern);
        BigDecimal winMoney = new BigDecimal(3233.34).multiply(moneyPattern);//每次盈利金额
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
            String tmpData = "";
            String num = NumberTools.getSubNum(mat, location, 5);
            boolean result = NumberTools.getLengthFour(num);
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
                tmpData = mat + "  输 " + NumberTools.getCalResult(initMoney, multiple[time]);


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
