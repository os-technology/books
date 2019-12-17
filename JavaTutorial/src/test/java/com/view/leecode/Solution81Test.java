package com.view.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * @author code
 * @Title: Solution81Test
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/1611:17 AM
 */
public class Solution81Test {
    Solution81 solution81 = new Solution81();

    @Test
    public void test(){
        Executors.newCachedThreadPool();
        String s = "lee(t(c)o)de)";
        String result = solution81.minRemovedToMakeValid(s);
        Assert.assertEquals("lee(t(c)o)de",result);
    }
}
