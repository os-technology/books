package org.htmltranslate.xtd;

import org.junit.Test;

/**
 * 彩票数据结果收集
 *
 * @author yuijnshui@lxfintech.com
 * @Title: NumCollectListTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/8下午6:50
 */

public class NumCollectListTest {

    @Test
    public void testCollect_FenFenCai_NumList() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        handleResult(mats, "111", 2);
    }

    @Test
    public void testCollect_TaiWanWuFenCai_NumList() {
        String[] mats = XTDHtmlStringTranslateUtil.getTaiWanWufenMatArray();
        handleResult(mats, "182", 5);
    }
    @Test
    public void testCollect_BeijingWuFenCai_NumList() {
        String[] mats = XTDHtmlStringTranslateUtil.getBeijingWufenMatArray();
        handleResult(mats, "181", 2);
    }
    @Test
    public void testCollect_ShiShiCai_NumList() {
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        handleResult(mats, "101", 5);
    }

    public void handleResult(String[] mats, String caipiaoCode, int location) {
        handleResult(mats, caipiaoCode, location, 2);
    }

    private void handleResult(String[] mats, String caipiaoCode, int location, int count) {
        String resultNumList = NumberTools.collectNumList(mats, "", location, count);
        String output = NumberTools.selectSort(resultNumList).trim();
        System.out.println("类型：" + NumberTools.caiPiaoName(caipiaoCode));
        System.out.println(output);
        System.out.println("收集期数：" + mats.length);
        System.out.println("数据组数:" + NumberTools.getStringArray(output).length);
    }
}
