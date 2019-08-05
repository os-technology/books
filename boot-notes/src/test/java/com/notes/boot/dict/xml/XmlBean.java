package com.notes.boot.dict.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author code
 * @Title: XmlBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/51:31 PM
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class XmlBean extends BaseResponseBeans{



    private String device_info;
    private String openid;
    private String is_subscribe;
    private String sub_openid;
    private String sub_is_subscribe;
    private String trade_type;
    private String trade_state;
    private String bank_type;
    private String detail;
    private Integer total_fee;

    private String fee_type;
    private int settlement_total_fee;
    private int cash_fee;
    private String cash_fee_type;
    private int coupon_fee;
    private int coupon_count;
    private String coupon_id_$n;
    private String coupon_type_$n;
    private int coupon_fee_$n;

    private String transaction_id;
    private String out_trade_no;
    private String attach;
    private String time_end;
    private String trade_state_desc;


    public String getDevice_info() {
        return device_info;
    }

    public XmlBean setDevice_info(String device_info) {
        this.device_info = device_info;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public XmlBean setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public XmlBean setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
        return this;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public XmlBean setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
        return this;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    public XmlBean setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
        return this;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public XmlBean setTrade_type(String trade_type) {
        this.trade_type = trade_type;
        return this;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public XmlBean setTrade_state(String trade_state) {
        this.trade_state = trade_state;
        return this;
    }

    public String getBank_type() {
        return bank_type;
    }

    public XmlBean setBank_type(String bank_type) {
        this.bank_type = bank_type;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public XmlBean setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public XmlBean setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public XmlBean setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public XmlBean setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
        return this;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public XmlBean setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
        return this;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public XmlBean setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
        return this;
    }

    public int getCoupon_fee() {
        return coupon_fee;
    }

    public XmlBean setCoupon_fee(int coupon_fee) {
        this.coupon_fee = coupon_fee;
        return this;
    }

    public int getCoupon_count() {
        return coupon_count;
    }

    public XmlBean setCoupon_count(int coupon_count) {
        this.coupon_count = coupon_count;
        return this;
    }

    public String getCoupon_id_$n() {
        return coupon_id_$n;
    }

    public XmlBean setCoupon_id_$n(String coupon_id_$n) {
        this.coupon_id_$n = coupon_id_$n;
        return this;
    }

    public String getCoupon_type_$n() {
        return coupon_type_$n;
    }

    public XmlBean setCoupon_type_$n(String coupon_type_$n) {
        this.coupon_type_$n = coupon_type_$n;
        return this;
    }

    public int getCoupon_fee_$n() {
        return coupon_fee_$n;
    }

    public XmlBean setCoupon_fee_$n(int coupon_fee_$n) {
        this.coupon_fee_$n = coupon_fee_$n;
        return this;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public XmlBean setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public XmlBean setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public XmlBean setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTime_end() {
        return time_end;
    }

    public XmlBean setTime_end(String time_end) {
        this.time_end = time_end;
        return this;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    public XmlBean setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
        return this;
    }
}
