package com.spring.source.code.beans.ch2;

import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yuijnshui
 * @Title: BeanFactoryTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/14下午9:19
 */
//@ActiveProfiles("dev")
//@ContextConfiguration("classpath:/beanFactoryTest.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
public class BeanFactoryTest extends BaseJunitTest {

    /**
     * XmlBeanFactory 过期。从spring 3.2 后推荐使用DefaultListableBeanFactory和XmlBeanDefinitionReader来代替它。
     */
    @Test
    public void testSimpleLoad_3_2_x_old() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");

        String eqlVal = "myTestBean";
        myTestBean.setStr(eqlVal);
        Assert.assertEquals(eqlVal, myTestBean.getStr());
        System.out.println(this);

        Assert.assertNotNull("BeanAttr is null",myTestBean.getBeanAttr());
    }

    /**
     * xml文件新的读取方式
     * profile配置方式：-Dspring.profiles.active=dev
     *
     * @param
     * @return void
     * @author code
     * @date 2018/7/15 下午7:30
     */
    @Test

    public void testSimpleLoad_new() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        Resource resource = new ClassPathResource("beanFactoryTest.xml");
        new XmlBeanDefinitionReader(factory).loadBeanDefinitions(resource);

        MyTestBean myTestBean = (MyTestBean) factory.getBean("myTestBean");
        MyTestBean myTestBean1 = factory.getBean("myTestBean",MyTestBean.class);

        String eqlVal = "myTestBean";
        myTestBean.setStr(eqlVal);
        Assert.assertEquals(eqlVal, myTestBean.getStr());

        Assert.assertNotNull(myTestBean1);

    }


    @Test
    public void testSimpleLoad_profile() {


        DefaultListableBeanFactory factory = getBeanFactory("dev");

        MyTestBean myTestBean = (MyTestBean) factory.getBean("myTestBean");

        String eqlVal = "myTestBean";
        myTestBean.setStr(eqlVal);
        Assert.assertEquals(eqlVal, myTestBean.getStr());
        System.out.println(this);


    }

    /**
     * 带有&符号的bean类必须实现FactoryBean接口，实例化的时候才可以在字符串前缀上添加&
     * @author code
     * @date 2018/7/23 下午1:52
     * @param
     * @return void
     */
    @Test
    public void testSimpleLoad_special() {


        DefaultListableBeanFactory factory = getBeanFactory("dev");

        MyTestBeanFactoryBean myTestBean = (MyTestBeanFactoryBean) factory.getBean("&myTestBeanFactoryBean");

        String eqlVal = "myTestBeanFactoryBean";
        myTestBean.setStr(eqlVal);
        Assert.assertEquals(eqlVal, myTestBean.getStr());
        System.out.println(this);


    }


    private DefaultListableBeanFactory getBeanFactory(String profile) {
        return getDefaultListableBeanFactory(profile,"beanFactoryProfileTest.xml");
    }



    @Test
    public void testSimpleLoadWithoutId(){
        DefaultListableBeanFactory factory = getBeanFactory("pro");

        //如果配置文件中不指定id名称，则根据传入的class进行名称查找,(会自动按照驼峰命名法进行命名),这种方式getBean()方法不能传入字符串信息，会报错
        BeanAttr beanAttr =  factory.getBean(BeanAttr.class);

        Assert.assertNotNull(beanAttr);
    }

    /**
     *仅用来代表resource对象可以获取到inputstream信息，非测试内容
     * @author code
     * @date 2018/7/16 下午7:26
     * @param
     * @return void
     */
    @Test
    public void testInputStream() throws IOException {
        Resource resource = new ClassPathResource("beanFactoryTest.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);


    }
    /**
     * 可用于进行代码编写时进行的验证
     * @author code
     * @date 2018/7/16 下午7:27
     * @param
     * @return void
     */
    @Test
    public void testNotNull(){
        Assert.assertNotNull("String is null",null);
    }

}
