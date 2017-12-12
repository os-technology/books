package org.springmvc.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springmvc.AbstractServiceTest;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: RedisTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2017/9/30下午4:07
 */

public class RedisTest extends AbstractServiceTest {

    @Autowired
    NotifyCache notifyCache;

    @Test
    public void testRedis(){

        String list = notifyCache.get("*");
        System.out.println(list);

    }



}
