package com.spring.source.code.beans.ch3.alias_bean;

import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author yuijnshui
 * @Title: AliasBeanJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/4下午2:12
 */
public class AliasBeanJunitTest extends BaseJunitTest {

    @Test
    public void aliasBeanTest(){
        DefaultListableBeanFactory factory = getDefaultListableBeanFactory( "aliasBeanMarkTest.xml");
        AliasBean aliasClass =  factory.getBean("aliasClass",AliasBean.class);
        AliasBean aliasBean1 =  factory.getBean("aliasBean1",AliasBean.class);
        Assert.assertNotNull(aliasClass);
        Assert.assertNotNull(aliasBean1);


        AliasBean aliasNameBean = (AliasBean) factory.getBean("aliasNameBean");
        Assert.assertNotNull(aliasNameBean);
        AliasBean aliasNameBean1 = factory.getBean("aliasNameBean",AliasBean.class);
        Assert.assertNotNull(aliasNameBean1);
    }
}
