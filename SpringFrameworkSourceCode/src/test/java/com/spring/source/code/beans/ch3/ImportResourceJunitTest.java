package com.spring.source.code.beans.ch3;

import com.spring.source.code.beans.BaseJunitTest;
import com.spring.source.code.beans.ch3.alias_bean.AliasBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author yuijnshui
 * @Title: ImportResourceJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/4下午5:04
 */
public class ImportResourceJunitTest extends BaseJunitTest {

    @Test
    public void testImport(){
        DefaultListableBeanFactory factory = getDefaultListableBeanFactory("importResourceTest.xml");
        AliasBean aliasBean = factory.getBean("aliasName", AliasBean.class);
        Assert.assertNotNull(aliasBean);
    }
}
