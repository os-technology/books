package com.wisely.highlight_spring4.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 在spring aware演示bean
 *
 * @author yuijnshui@lxfintech.com
 * @Title: AwareService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/16上午10:48
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {//实现BeanNameAware、 ResourceLoaderAware接口， 获得Bean名称和资源加载的服务。

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;//实现BeanNameAware需重写setBeanName方法。
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;//实现ResourceLoaderAware需重写setResourceLoader
    }

    public void outputBeanName(){
        System.out.println("Bean的名字为："+beanName);
        Resource resource = resourceLoader.getResource("classpath:ch3_test.txt");
        try {
            System.out.println("ResourceLoader加载的内容为："+IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
