package org.mq.rocketmq.beans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: OrderDataSender
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/6/7上午10:24
 */

public class OrderDataSender implements Serializable {

    private String productItemCode;

    private Integer lenovoUserId;

    private String lenovoOrderNo;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lenovoApplyTime;

    private String purchaseCardNo;

    private Double investAmt;

    private String mobileInBank;

    private String mobile;

    private String idType;

    private String idNo;

    private String customerName;

    private String bankName;

    private Double interestAmt;

    public String getProductItemCode() {
        return productItemCode;
    }

    public OrderDataSender setProductItemCode(String productItemCode) {
        this.productItemCode = productItemCode;
        return this;
    }

    public Integer getLenovoUserId() {
        return lenovoUserId;
    }

    public OrderDataSender setLenovoUserId(Integer lenovoUserId) {
        this.lenovoUserId = lenovoUserId;
        return this;
    }

    public String getLenovoOrderNo() {
        return lenovoOrderNo;
    }

    public OrderDataSender setLenovoOrderNo(String lenovoOrderNo) {
        this.lenovoOrderNo = lenovoOrderNo;
        return this;
    }

    public Date getLenovoApplyTime() {
        return lenovoApplyTime;
    }

    public OrderDataSender setLenovoApplyTime(Date lenovoApplyTime) {
        this.lenovoApplyTime = lenovoApplyTime;
        return this;
    }

    public String getPurchaseCardNo() {
        return purchaseCardNo;
    }

    public OrderDataSender setPurchaseCardNo(String purchaseCardNo) {
        this.purchaseCardNo = purchaseCardNo;
        return this;
    }

    public Double getInvestAmt() {
        return investAmt;
    }

    public OrderDataSender setInvestAmt(Double investAmt) {
        this.investAmt = investAmt;
        return this;
    }

    public String getMobileInBank() {
        return mobileInBank;
    }

    public OrderDataSender setMobileInBank(String mobileInBank) {
        this.mobileInBank = mobileInBank;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public OrderDataSender setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getIdType() {
        return idType;
    }

    public OrderDataSender setIdType(String idType) {
        this.idType = idType;
        return this;
    }

    public String getIdNo() {
        return idNo;
    }

    public OrderDataSender setIdNo(String idNo) {
        this.idNo = idNo;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderDataSender setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public OrderDataSender setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public Double getInterestAmt() {
        return interestAmt;
    }

    public OrderDataSender setInterestAmt(Double interestAmt) {
        this.interestAmt = interestAmt;
        return this;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}
