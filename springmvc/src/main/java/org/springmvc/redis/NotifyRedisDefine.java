package org.springmvc.redis;


/**
 * redis-key定义等相关内容
 *
 * @author yuijnshui@lxfintech.com
 * @Title: NotifyRedisDefine
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/9/11下午4:49
 */

public class NotifyRedisDefine {
    //key:用于获取redis中通知URL挂起的数据
    //value类型为list，结构为商户ID+URL+type(交易类型)
    public static final String KEY_UNLINK_URL = "UNLINK_URL";
    //512s超时时间
    public static final int KEY_EXPIRED_TIME_WEBHOOKS = getExpiredTimeSystemEnv("KEY_EXPIRED_TIME_WEBHOOKS");

    //超过五分钟挂起时间点key标识
    public static final String KEY_SUSPEND_TIME = "_SUSPEND_TIME";
    //连续五分钟一直UNRECEIVED状态的时间点key标识
    public static final String KEY_UNRECEIVED_TIME = "_UNRECEIVED_TIME";

    //五分钟秒数
    public static final long FIVEMINUTES_SECOND_WEBHOOKS = getFiveMinutesSystemEnv("FIVEMINUTES_SECOND_WEBHOOKS");


    private static long getFiveMinutesSystemEnv(String keyName) {
        String value = System.getenv(keyName);
        return Long.valueOf(value == null ? "300000" : value);
    }

    private static int getExpiredTimeSystemEnv(String sysKey) {
        String value = System.getenv(sysKey);
        return Integer.valueOf(value == null ? "512" : value);
    }

    public static String getKey(long merchantId, String url) {
        String value = merchantId + "|" + url;
        return value;
    }


    /**
     * 五分钟挂起时间点记录key
     *
     * @return
     */
    public static String getSuspendTimeKey(long merchantId, String url) {
        return getKey(merchantId, url) + KEY_SUSPEND_TIME;
    }


    /**
     * UNRECEIVED时间点缓存记录
     *
     * @return
     */
    public static String getUnreceivedTimeKey(long merchantId, String url) {
        return getKey(merchantId, url) + KEY_UNRECEIVED_TIME;
    }


    public static String getNotifyValue(long merchantId, String url) {
        return getKey(merchantId, url);
    }


}
