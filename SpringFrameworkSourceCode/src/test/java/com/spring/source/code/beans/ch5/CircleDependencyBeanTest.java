package com.spring.source.code.beans.ch5;

import com.spring.source.code.beans.BaseJunitTest;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author code
 * @Title: CircleDependencyBeanTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/14下午4:10
 */
public class CircleDependencyBeanTest extends BaseJunitTest {


    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndPrototype() throws Throwable {
        try {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ch5/circleDependencyPrototypeBean.xml");
        ctx.getBean("testAA");
        } catch (BeansException e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    /**
     * BeanCurrentlyInCreationException 只会在发生异常的原始位置出现
     *
     * @throws Throwable
     */
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBeanCurrentlyInCreationException() throws Throwable {

        try {
            new ClassPathXmlApplicationContext("ch5/circleDependencyBean.xml");
        } catch (BeansException e) {

            e.printStackTrace();
            //因为要在创建testC时抛出
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test(expected = BeanCreationException.class)
    public void testCircleBeanCreationException() throws Throwable {

        try {
            new ClassPathXmlApplicationContext("ch5/circleDependencyBean.xml");
        } catch (BeansException e) {

            //我们检查在testB进行抛出，通过debug，发现e.getCause() 和 e.getCause().getCause()
            // 信息都为BeanCreationException，只有进入第三层cause，才得到 BeanCurrentlyInCreationException 异常
            Throwable eA = e.getCause();
            Throwable eB = e.getCause().getCause();
            if ((eA instanceof BeanCreationException) && (eB instanceof BeanCreationException)) {
                throw eA;
            }
        }
    }

    /**
     * 针对以上代码的分析如下。
     * * Spring容器创建“testA”bean，首先去“当前创建bean池”查找是否当前bean正在创建，如果没发现，则继续准备其需要的构造器参数“testB”， 并将“testA” 标识符放到“当前创建bean池”。
     * * Spring容器创建“testB”bean,首先去“当前创建bean池”查找是否当前bean正在创建，如果没发现，则继续准备其需要的构造器参数“testC” ,并将“testB” 标识符放到“当前创建bean池”。
     * * Spring容器创建“testC”bean,首先去“当前创建bean池”查找是否当前bean正在创建，如果没发现，则继续准备其需要的构造器参数“testA”， 并将“testC” 标识符放到“当前创建Bean池”。
     * * 到此为止Spring容器要去创建“testA” bean， 发现该bean 标识符在“当前创建bean池”中，因为表示循环依赖，抛出BeanCurrentlyInCreationException.
     */
}
