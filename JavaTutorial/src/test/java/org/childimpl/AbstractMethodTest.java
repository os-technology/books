package org.childimpl;

import org.junit.Assert;
import org.junit.Test;

/**
 * 抽象类子类具体实现操作
 * @author yuijnshui
 * @Title: AbstractMethodTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/20下午4:45
 */
public class AbstractMethodTest {

    @Test
    public void testMethod(){
        ManBehavior man = new ManBehavior();
        String out = man.action("男人");
        Assert.assertEquals(out,"男人:喜欢玩游戏");

        WomenBehavior women = new WomenBehavior();
        String info = women.action("女人");
        Assert.assertEquals(info,"女人:喜欢购物");
    }
}
