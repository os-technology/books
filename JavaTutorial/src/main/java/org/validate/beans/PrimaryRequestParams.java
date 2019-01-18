package org.validate.beans;

import org.hibernate.validator.constraints.NotEmpty;
import org.validate.EnumValue;

import java.io.Serializable;

/**
 * RPC 接口请求参数公共bean参数信息
 *
 * @author code
 * @Title: PrimaryRequestParams
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/11/5下午2:14
 */
public class PrimaryRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 必传
     * 已经添加到支付系统的子商户公众账号ID  wx8888888888888888
     */
    @NotEmpty
    private String subAppId;
    /**
     * 必传
     * 已经添加到支付系统的微信支付分配的子商户号  1900000109
     */
    @NotEmpty
    private String subMchId;


    /**
     * 必传
     * //微信公众号，默认
     * WECHAT
     * //微信小程序支付
     * , WECHAT_APPLET
     * //支付宝
     * , ALIPAY;
     */
    @EnumValue(enumClass = ChannelTypeEnum.class,enumMethod = "getEnum")
    private String channelType;


    public String getSubAppId() {
        return subAppId;
    }

    public PrimaryRequestParams setSubAppId(String subAppId) {
        this.subAppId = subAppId;
        return this;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public PrimaryRequestParams setSubMchId(String subMchId) {
        this.subMchId = subMchId;
        return this;
    }

    public String getChannelType() {
        return channelType;
    }

    public PrimaryRequestParams setChannelType(String channelType) {
        this.channelType = channelType;
        return this;
    }
}
