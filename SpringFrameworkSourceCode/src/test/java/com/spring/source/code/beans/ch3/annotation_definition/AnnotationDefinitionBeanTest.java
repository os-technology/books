package com.spring.source.code.beans.ch3.annotation_definition;

import com.log.LogPortal;
import com.spring.source.code.beans.BaseDisconfJunitTest;
import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author yuijnshui
 * @Title: AnnotationDefinitionBeanTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/8/2上午10:06
 */
public class AnnotationDefinitionBeanTest extends BaseDisconfJunitTest {

    /**
     * disconf注解方式尚不可用
     * @author code
     * @date 2018/8/3 下午12:57
     * @param
     * @return void
     */
    @Test
    public void testBeanDefinition(){

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        Resource resource = new ClassPathResource("annotationDefineTest.xml");

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(resource);

        AnnotationDefinitionBean annotationDefinitionBean = (AnnotationDefinitionBean) factory.getBean("annotationDefinitionBean");

        Assert.assertNotNull(annotationDefinitionBean);
        LogPortal.info(annotationDefinitionBean.getDefine());
    }
}
