package org.beans.request;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HxbDataContent
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/8下午4:08
 */

public class HxbDataContent {

    //必填性说明：未说明或者M,代表必填；O,可以不填；C，如果商户填写了，则对应的参数返回需要添加。允许为空
    /**
     * 商户流水号
     */
    private String tranNo;//

    /**
     * 备注 - O
     */
    private String remark;//

    /**
     * 支付机构流水号 - C
     */
    private String pmcNo;
    /**
     * 短信验证码
     */
    private String msgCode;
    /**
     * 扩展字段-C
     */
    private String extra;

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
