package com.spring.source.code.beans.ch4.beanparser;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 当遇到自定义标签<user:aaa 这样类似于以user开头的元素，就会把这个元素扔给对应的UserBeanDefinitionParser去解析。
 *
 * @author yuijnshui
 * @Title: MyNamespaceHandler
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/6下午8:13
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        //userxsd与xsdDefineMarkTest.xml配置中的<myname:userxsd的userxsd相对应，否则无法正常解析
        registerBeanDefinitionParser("userxsd", new UserBeanDefinitionParser());
    }
}
