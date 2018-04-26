package org.beans.response;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: HxbResponse
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/8下午5:37
 */

public class HxbResponse {


    /**
     * 商户号
     */
    private String mchtNo;
    /**
     * 商户订单号
     */
    private String tranNo;
    /**
     * 支付机构流水号
     * 代扣时必须返,快捷类可在订单确认时生成也可在此生成
     */
    private String pmcNo;
    /**
     * 返回码
     * 0000：成功
     * 订单成功返0000，失败这个返回码承担失败的原因码值和失败描述，订单处理中此处无要求
     */
    private String returnCode;

    /**
     * 返回码描述
     */
    private String returnMessage;
    /**
     * 处理结果
     * S：成功
     * F：失败
     * I：处理中
     * （快捷预支付不允许出现处理中的状态）
     */
    private String dealResult;


    /**
     * 订单发送时间 - O
     * 14 位定长。
     * 格式：年年年年月月日日时时分分秒秒
     */
    private String tradeTime;

    /**
     * 订单成功时间 - O
     * 14 位定长。
     * 格式：年年年年月月日日时时分分秒秒
     */
    private String successTime;

    /**
     * 交易成功金额,单位，分。 - C
     * 代扣交易成功时，必须返回。其他情况，未说明。
     */
    private int successAmount;

    /**
     * 扩展字段
     * 支付机构返回（例如token等），在支付确认时再回传回去
     */
    private String extra;
    /**
     * 备注
     */
    private String remark;


    public String getMchtNo() {
        return mchtNo;
    }

    public HxbResponse setMchtNo(String mchtNo) {
        this.mchtNo = mchtNo;
        return this;
    }

    public String getTranNo() {
        return tranNo;
    }

    public HxbResponse setTranNo(String tranNo) {
        this.tranNo = tranNo;
        return this;
    }

    public String getPmcNo() {
        return pmcNo;
    }

    public HxbResponse setPmcNo(String pmcNo) {
        this.pmcNo = pmcNo;
        return this;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public HxbResponse setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public HxbResponse setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
        return this;
    }

    public String getDealResult() {
        return dealResult;
    }

    public HxbResponse setDealResult(String dealResult) {
        this.dealResult = dealResult;
        return this;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public HxbResponse setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
        return this;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public HxbResponse setSuccessTime(String successTime) {
        this.successTime = successTime;
        return this;
    }

    public int getSuccessAmount() {
        return successAmount;
    }

    public HxbResponse setSuccessAmount(int successAmount) {
        this.successAmount = successAmount;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public HxbResponse setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public HxbResponse setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
