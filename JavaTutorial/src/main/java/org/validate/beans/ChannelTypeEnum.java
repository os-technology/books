package org.validate.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * 通道类型
 *
 * @author code
 * @Title: ChannelTypeEnum
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/14上午9:47
 */
public enum ChannelTypeEnum {
    //微信公众号，默认
    WECHAT
    //微信小程序支付
    , WECHAT_APPLET
    //支付宝
    , ALIPAY;

    //渠道枚举map
    private static Map<String, ChannelTypeEnum> mapEnum = new HashMap<>();

    static {
        for (ChannelTypeEnum channelTypeEnum : ChannelTypeEnum.values()) {
            mapEnum.put(channelTypeEnum.name(), channelTypeEnum);
        }
    }

    public static ChannelTypeEnum getEnum(String name) {
        return mapEnum.get(name);
    }

    /**
     * 检查是否为微信通道（公众号，小程序）
     *
     * @param channelTypeEnum
     * @return
     */
    public static boolean isWechatChannel(ChannelTypeEnum channelTypeEnum) {
        return ChannelTypeEnum.WECHAT == channelTypeEnum
                || ChannelTypeEnum.WECHAT_APPLET == channelTypeEnum;
    }
}
