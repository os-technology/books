package com.spring.source.code.beans;

import com.log.LogPortal;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 单元测试基础类
 *
 * @author yuijnshui
 * @Title: BaseJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/27下午3:40
 */

//@ImportResource({"classpath:disconfig.xml"})//引入disconf
//@ImportResource({"classpath:replaceMethodTest_disconf.xml"})//引入disconf
public class BaseJunitTest {
    @Before
    public void setLog() {//日志配置
        LogPortal.setLogModule("SpringFrameworkSourceCode");
        LogPortal.setLogLevel(LogPortal.LogLevel.INFO);
    }

    /**
     * 获取beanFactory
     *
     * @param profile
     * @param xmlFile
     * @return org.springframework.beans.factory.support.DefaultListableBeanFactory
     * @author code
     * @date 2018/8/2 上午10:32
     */
    protected DefaultListableBeanFactory getDefaultListableBeanFactory(String profile, String xmlFile) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        Resource resource = new ClassPathResource(xmlFile);

        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(factory);

        if (StringUtils.isNotEmpty(profile)) {//profile变量不为空时需要进行环境变量的设置
            StandardEnvironment environment = new StandardEnvironment();
            environment.setActiveProfiles(profile);//设置配置文件的profile方式之一
            xmlReader.setEnvironment(environment);
        }

        xmlReader.loadBeanDefinitions(resource);
        return factory;
    }

    /**
     * 无环境变量的配置方式
     *
     * @param xmlFile
     * @return org.springframework.beans.factory.support.DefaultListableBeanFactory
     * @author code
     * @date 2018/8/2 上午10:37
     */
    protected DefaultListableBeanFactory getDefaultListableBeanFactory(String xmlFile) {
        return getDefaultListableBeanFactory(null, xmlFile);
    }
}
