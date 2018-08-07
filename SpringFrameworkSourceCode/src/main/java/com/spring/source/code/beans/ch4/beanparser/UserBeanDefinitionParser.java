package com.spring.source.code.beans.ch4.beanparser;

import com.spring.source.code.beans.ch4.UserXsd;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 解析xsd文件的定义和组件的定义
 * @author code
 * @Title: UserBeanDefinitionParser
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/8/6下午8:03
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {


    /**
     * element对应的类
     * @author code
     * @date 2018/8/6 下午8:07
     * @param element
     * @return java.lang.Class
     */
    protected Class getBeanClass(Element element){
        return UserXsd.class;
    }

    /**
     * 从element中解析并提取对应的元素
     * @author code
     * @date 2018/8/6 下午8:08
     * @param element
    * @param builder
     * @return void
     */
    protected void doParse(Element element, BeanDefinitionBuilder builder){

        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");

        //将提取的数据放入BeanDefinitionBuilder中，待到完成所有bean的解析后统一注册到beanFactory中
        if (StringUtils.hasText(userName)){
            builder.addPropertyValue("userName",userName);
        }
        if (StringUtils.hasText(userName)){
            builder.addPropertyValue("email",email);
        }

    }
}
