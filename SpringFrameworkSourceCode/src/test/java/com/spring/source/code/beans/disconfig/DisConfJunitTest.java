package com.spring.source.code.beans.disconfig;

import com.baidu.disconf.client.usertools.DisconfDataGetter;
import com.disconfig.DisconfAnnotationAutoService;
import com.disconfig.DisconfAutoService;
import com.spring.source.code.beans.BaseDisconfJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuijnshui
 * @Title: DisConfJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/8/1下午4:00
 */
public class DisConfJunitTest extends BaseDisconfJunitTest {
    @Test
    public void testDisconf() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("disconf.xml");
        DisconfAutoService disconfAutoService = (DisconfAutoService)ac.getBean("disconfAutoService");
        Assert.assertNotNull(disconfAutoService);
        System.out.println("disconf配置值：auto="+disconfAutoService.getAuto()+" disconfig="+disconfAutoService.getDisconf());


    }

    @Autowired
    private DisconfAnnotationAutoService disconfAnnotationAutoService;

    @Test
    public void disconfAnnotation(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("disconf_annotation.xml");
        DisconfAnnotationAutoService disconfAnnotationAutoService = ac.getBean(DisconfAnnotationAutoService.class);
        System.out.println(disconfAnnotationAutoService.getContent());
    }

    @Test
    public void testDisconfFile(){
        String result = DisconfDataGetter.getByFile("autoconfig.properties").get("auto").toString();
        Assert.assertNotNull(result);
    }
}
