package org.beans.response;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HxbNotifyDataContent
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/9下午6:03
 */

public class HxbNotifyDataContent {

    /**
     * 商户号
     */
    private String mchtNo;
    /**
     * 商户订单号
     * 商户上送流水号,原始交易订单号
     */
    private String tranNo;
    /**
     * 支付机构流水号
     * <p>
     * 在预下单时生成-paymax订单号
     */
    private String pmcNo;
    /**
     * 返回码
     * 0000：成功
     * 验证成功返0000，失败这个返回码承担失败的原因码值和失败描述
     */
    private String returnCode;
    /**
     * 返回码描述
     */
    private String returnMessage;
    /**
     * 交易处理结果
     * S：成功
     * F：失败
     */
    private String dealResult;
    /**
     * 交易完成日期
     * 交易完成时间
     * 14 位定长。
     * 格式：年年年年月月日日时时分分秒秒
     */
    private String successTime;
    /**
     * 成交金额
     * 单位：分
     * 交易成功时返回
     */
    private String successAmount;

}
