package org.beans.request;

/**
 * 预下单返回体
 * @author yuijnshui@lxfintech.com
 * @Title: HxbOrderDataContent
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/8下午5:43
 */

public class HxbOrderDataContent extends HxbDataContent {
    /**
     * 姓名
     */
    private String acctName;
    /**
     * 证件类型
     * 1-二代居民身份证
     */
    private String cerType;
    /**
     * 证件号码
     */
    private String cerNo;
    /**
     * 卡号类型
     * 0：储蓄卡（借记卡）
     * 1：信用卡（贷记卡）
     * 2：信用卡（准贷记卡）
     * 3：预付费卡
     * 注：目前只支持借记卡
     */
    private String acctType;

    /**
     * 账号/卡号
     */
    private String acctNo;
    /**
     * 开户行行号
     */
    private String bankCode;
    /**
     * 信用卡安全码 - O
     */
    private String cvn2;
    /**
     * 信用卡有效期 - O
     */
    private String exp;
    /**
     * 银行预留手机号 - M
     * 预下单必须是四要素信息，手机号为必填
     */
    private String phone;
    /**
     * 币种 - CNY
     */
    private String ccy;
    /**
     * 交易金额，单位，分。
     */
    private int amount;
    /**
     * 用户IP - O
     */
    private String userIp;
    /**
     * 异步回调地址
     */
    private String asyncUrl;

    /**
     * 用户Id
     */
    private String UID;
}
