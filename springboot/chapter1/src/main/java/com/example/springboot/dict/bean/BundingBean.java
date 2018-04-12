package com.example.springboot.dict.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: BundingBean
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/12上午9:29
 */
@XmlRootElement(name="xml")
public class BundingBean {

    private String toUserName;  //  是   接收方（公众号）的user name
    private String fromUserName; // 是   发送方（微信用户）的user name
    private String createTime;  //  是   消息创建时间，消息后台生成
    private String msgType;     //是     消息类型：device_event
    private String event;       //  是   事件类型，取值为bind/unbind bind：绑定设备 unbind：解除绑定
    private String deviceType;  //  是   设备类型，目前为“公众账号原始ID”
    private String deviceID;    //  是   设备ID，第三方提供
    private String content;         //是     当Event为bind时，Content字段存放二维码中
    //  第三方追加的自定义的数据
    //  详情见1.5章节 获取设备二维码
    //  或 1.11.1章节 API：获取deviceid和二维码
    private String sessionID;   //   是  微信客户端生成的session id，用于request和response对应，
    //  因此响应中该字段第三方需要原封不变的带回
    private String openID;      //  是    微信账号的OpenID


    public String getToUserName() {
        return toUserName;
    }

    public BundingBean setToUserName(String toUserName) {
        this.toUserName = toUserName;
        return this;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public BundingBean setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public BundingBean setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getMsgType() {
        return msgType;
    }

    public BundingBean setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public String getEvent() {
        return event;
    }

    public BundingBean setEvent(String event) {
        this.event = event;
        return this;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public BundingBean setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public BundingBean setDeviceID(String deviceID) {
        this.deviceID = deviceID;
        return this;
    }

    public String getContent() {
        return content;
    }

    public BundingBean setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSessionID() {
        return sessionID;
    }

    public BundingBean setSessionID(String sessionID) {
        this.sessionID = sessionID;
        return this;
    }

    public String getOpenID() {
        return openID;
    }

    public BundingBean setOpenID(String openID) {
        this.openID = openID;
        return this;
    }
}
