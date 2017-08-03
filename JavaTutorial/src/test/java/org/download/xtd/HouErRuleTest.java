package org.download.xtd;

/**
 * 后二规则测试
 *
 * @author yuijnshui@lxfintech.com
 * @Title: HouErRuleTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/3上午9:57
 */

public class HouErRuleTest {


    /**
     * 后二复式大底
     * 使用方法：个位与十位不包含2367定位胆即可投注
     *
     * @return
     */
    private String getFuShiDaDiString() {
        return "02,03,06,07,12,13,16,17," +
                "20,21,22,23,24,25,26,27," +
                "28,29,30,31,32,33,34,35," +
                "36,37,38,39,42,43,46,47," +
                "52,53,56,57,60,61,62,63," +
                "64,65,66,67,68,69,70,71," +
                "72,73,74,75,76,77,78,79," +
                "82,83,86,87,92,93,96,97";
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
