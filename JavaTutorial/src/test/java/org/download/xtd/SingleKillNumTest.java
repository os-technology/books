package org.download.xtd;

import org.download.xtd.params.PrintDataBean;
import org.junit.Test;
import org.number.Num;

import java.math.BigDecimal;

/**
 * 杀单号投注
 *
 * @author yuijnshui@lxfintech.com
 * @Title: SingleKillNumTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/6下午4:31
 */
@Deprecated
public class SingleKillNumTest {

    @Test
    public void test_SingleKillNum_Result() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        compareResult(mats, "111",5);
    }

    private void compareResult(String[] mats, String caipiaoCode,int location) {

        StringBuilder dataBuilder = new StringBuilder();
        StringBuilder printResult = new StringBuilder();

        dataBuilder.append(mats[0] + "  " + "初始数据").append("\n");

        BigDecimal initMoney = new BigDecimal(12);//初始投入金额
        BigDecimal winMoney = new BigDecimal(19.4);//每次盈利金额
        BigDecimal incomeMoney = new BigDecimal(0);//净利润金额
        double maxMoney = 0;//最大投入金额
        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        int allWinTime = 0;//本次统计总赢次数
        int allLoseTime = 0;//本次统计总的输次数

        int multiple = 1;//倍数始终为1

        for (int m = 0; m < mats.length - 1; m++) {
            String init = NumberTools.getSubNum(mats[m], location, location);
            String compare = NumberTools.getSubNum(mats[m + 1], location, 1);
            String tmpData = "";
            if (NumberTools.compareArrayNumberIsTrue(init, compare)) {//赢

                tmpData = mats[m + 1] + "  " + "赢  1   ";

                //数值操作

                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
//                time = 0;
                tmpLoseTime = 0;
                allWinTime++;
                tmpWinTime++;

            } else {//输
                tmpData = mats[m + 1] + "  " + "输  0   " + NumberTools.getCalResult(initMoney, multiple);

                //数值处理

                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;
                tmpWinTime = 0;
                allLoseTime++;
                tmpLoseTime++;
            }
            dataBuilder.append(tmpData + "\n");

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
                .setStageNum(mats.length);

        printResult.append("执行规则："+NumberTools.getNumLocation(location)+"  固定杀出号").append("\n");
        //封装打印的统计展示数据
        NumberTools.print(printResult, bean);

        System.out.println(dataBuilder);
        System.out.println(printResult);
        //总盈金额
        BigDecimal allWinMoney = winMoney.multiply(new BigDecimal(bean.getAllWinTime()));
        //总亏金额
        BigDecimal allLoseMoney = initMoney.multiply(new BigDecimal(mats.length - 1));

        BigDecimal result = winMoney.multiply(new BigDecimal(bean.getAllWinTime())).subtract(initMoney.multiply(new BigDecimal(mats.length-1)));
        System.out.println("总盈金额："+ NumberTools.getMoneyString(allWinMoney));
        System.out.println("总亏金额："+ NumberTools.getMoneyString(allLoseMoney));
        System.out.println("总盈亏："+ NumberTools.getMoneyString(allWinMoney.subtract(allLoseMoney)));

    }
}
