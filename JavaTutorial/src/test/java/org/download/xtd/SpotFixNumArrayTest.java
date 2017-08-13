package org.download.xtd;

import org.junit.Test;

/**
 * 定位选码投注
 *
 * @author yuijnshui@lxfintech.com
 * @Title: SpotFixNumArrayTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/4下午4:57
 */

public class SpotFixNumArrayTest {

    @Test
    public void testNumArray() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        fixNum(mats, 1, "014689", null,"101");
    }


    @Test
    public void testTaiWanNumArray() {
        String[] mats = XTDHtmlStringTranslateUtil.getWufenMatArray();
        fixNum(mats, 1, "01368", null,"182");
    }
    /**
     * 定码投注
     *
     * @param mats          开奖号码数组
     * @param location      定码位置(5，4，3，2，1 万，千，百，十，个)
     * @param array         选码数值组合
     * @param multipleArray 倍数数组
     */
    private void fixNum(String[] mats, int location, String array, int[] multipleArray,String caipiaoCode) {

        int maxWinTime = 0;//最大连赢次数
        int tmpWinTime = 0;//每阶段连赢次数
        int maxLoseTime = 0;//最大连挂次数
        int tmpLoseTime = 0;//每阶段连挂次数
        for (String mat : mats) {
            String value = NumberTools.getSubNum(mat, location, 1);
            if (array.contains(value)) {//赢

                System.out.println(mat + " 赢 ");

                maxLoseTime = maxLoseTime > tmpLoseTime ? maxLoseTime : tmpLoseTime;
                tmpWinTime++;
                tmpLoseTime = 0;
            } else {
                System.out.println(mat + " 输 ");

                maxWinTime = maxWinTime > tmpWinTime ? maxWinTime : tmpWinTime;
                tmpWinTime = 0;
                tmpLoseTime++;
            }
        }
        System.out.println("彩票类型："+NumberTools.caiPiaoName(caipiaoCode));
        System.out.println("选号位置：" + NumberTools.getNumLocation(location));
        System.out.println("统计期数：" + mats.length + "期");
        System.out.println("固定数字投注模式  投注数字：" + array);
        System.out.println("最大连赢次数：" + maxWinTime);
        System.out.println("最大连挂次数：" + maxLoseTime);
    }
}
