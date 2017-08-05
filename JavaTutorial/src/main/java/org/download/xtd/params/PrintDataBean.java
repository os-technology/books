package org.download.xtd.params;

import java.math.BigDecimal;

/**
 * 需要打印输出的数据参数
 *
 * @author yuijnshui@lxfintech.com
 * @Title: PrintDataBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/8/5下午12:35
 */

public class PrintDataBean {

    /**
     * 彩票编码
     */
    private String caiPiaoCode;
    /**
     * 统计期数
     */
    private Integer stageNum;
    /**
     * z最大倍投金额
     */
    private BigDecimal maxMoney;
    /**
     * 总收益
     */
    private BigDecimal incomeMoney;
    /**
     * 最大连赢次数
     */
    private Integer maxWinTime;
    /**
     * 最大连挂次数
     */
    private Integer maxLoseTime;
    /**
     * 总赢次数
     */
    private Integer allWinTime;
    /**
     * 总输次数
     */
    private Integer allLoseTime;


    public String getCaiPiaoCode() {
        return caiPiaoCode;
    }

    public PrintDataBean setCaiPiaoCode(String caiPiaoCode) {
        this.caiPiaoCode = caiPiaoCode;
        return this;
    }

    public Integer getStageNum() {
        return stageNum;
    }

    public PrintDataBean setStageNum(Integer stageNum) {
        this.stageNum = stageNum;
        return this;
    }

    public BigDecimal getMaxMoney() {
        return maxMoney;
    }

    public PrintDataBean setMaxMoney(BigDecimal maxMoney) {
        this.maxMoney = maxMoney;
        return this;
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public PrintDataBean setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
        return this;
    }

    public Integer getMaxWinTime() {
        return maxWinTime;
    }

    public PrintDataBean setMaxWinTime(Integer maxWinTime) {
        this.maxWinTime = maxWinTime;
        return this;
    }

    public Integer getMaxLoseTime() {
        return maxLoseTime;
    }

    public PrintDataBean setMaxLoseTime(Integer maxLoseTime) {
        this.maxLoseTime = maxLoseTime;
        return this;
    }

    public Integer getAllWinTime() {
        return allWinTime;
    }

    public PrintDataBean setAllWinTime(Integer allWinTime) {
        this.allWinTime = allWinTime;
        return this;
    }

    public Integer getAllLoseTime() {
        return allLoseTime;
    }

    public PrintDataBean setAllLoseTime(Integer allLoseTime) {
        this.allLoseTime = allLoseTime;
        return this;
    }
}
