package org.springmvc.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: NotifyCache
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/9/11上午11:02
 */
@Component
public class NotifyCache {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void listAppend(String key, String value) {
        redisTemplate.boundSetOps(key).add(value);
    }

    /**
     * 每个值具有唯一性，故true的表示删除成功，false表示删除了2条以上的数据
     *
     * @param keyName
     * @param value
     * @return
     */
    public void listRemove(String keyName, String value) {
        redisTemplate.boundSetOps(keyName).remove(value);

    }

    public Set<String> listGet(String keyName){
        return  redisTemplate.opsForSet().members(keyName);
    }

    public void set(String keysName, String value) {
        redisTemplate.boundValueOps(keysName).set(value);
    }

    public String get(String keyName) {
        return redisTemplate.boundValueOps(keyName).get();

    }

    /**
     * 按秒计算有效期
     *
     * @param keyName
     * @param value
     * @param expiredSecond
     * @Author yujinshui
     * @createTime 2016年9月7日 下午2:09:35
     */
    public void set(String keyName, String value, long expiredSecond) {
        redisTemplate.boundValueOps(keyName).set(value, expiredSecond, TimeUnit.SECONDS);
    }

    /**
     * 通知时间的缓存记录
     *
     * @param keyName
     * @param value
     */
    public void setNotifyTime(String keyName, String value) {
        set(keyName, value, NotifyRedisDefine.KEY_EXPIRED_TIME_WEBHOOKS);
    }

    public void delete(String keyName) {
        redisTemplate.delete(keyName);
    }
}


