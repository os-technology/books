package org.download.xtd;

import org.junit.Test;

/**
 * 彩票数据结果收集
 * @author yuijnshui@lxfintech.com
 * @Title: NumCollectListTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/8下午6:50
 */

public class NumCollectListTest {

    @Test
    public void testCollect_FenFenCai_NumList(){
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        String resultNumList = NumberTools.collectNumList(mats,"",2,2);
        String output = NumberTools.selectSort(resultNumList);
        System.out.println(output);
        System.out.println("收集期数："+mats.length);
        System.out.println("数据组数:"+NumberTools.getStringArray(output).length);
    }
    @Test
    public void testCollect_TaiWanWuFenCai_NumList(){
        String[] mats = XTDHtmlStringTranslateUtil.getWufenMatArray();
        String resultNumList = NumberTools.collectNumList(mats,"",2,2);
        String output = NumberTools.selectSort(resultNumList);
        System.out.println(output);
        System.out.println("数据组数:"+NumberTools.getStringArray(output).length);
    }

    @Test
    public void testCollect_ShiShiCai_NumList(){
        String[] mats = XTDHtmlStringTranslateUtil.getMatArray();
        String resultNumList = NumberTools.collectNumList(mats,"",5,2);
        String output = NumberTools.selectSort(resultNumList);
        System.out.println(output);
        System.out.println("数据组数:"+NumberTools.getStringArray(output).length);
    }
}
