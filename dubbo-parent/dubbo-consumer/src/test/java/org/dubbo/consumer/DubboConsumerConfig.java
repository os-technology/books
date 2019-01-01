package org.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

/**
 * @author code
 * @Title: DubboConsumerConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/12/31上午11:56
 */
public class DubboConsumerConfig {

    private static final String APPLICATION_NAME = "dubbo_hello";
    private static final String REGISTRY_ADDRESS = "zookeeper://127.0.0.1:2181?backup=127.0.0.1:2182,127.0.0.1:2183";
    private static Integer TIME_OUT;

    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APPLICATION_NAME);
        return applicationConfig;
    }

    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        registryConfig.setProtocol("zookeeper");
//        registryConfig.setRegister(true);
        return registryConfig;
    }

    public ReferenceConfig referenceConfig(){
        ReferenceConfig referenceConfig = new ReferenceConfig();
        referenceConfig.setApplication(applicationConfig());
        referenceConfig.setRegistry(registryConfig());
        if (TIME_OUT!=null){
            referenceConfig.setTimeout(TIME_OUT);
        }

        return referenceConfig;
    }


    public <T> T getConsumer(Class<T> clazz){
        ReferenceConfig referenceConfig = referenceConfig();
                referenceConfig.setInterface(clazz);
                referenceConfig.setVersion("1.0.0");
                return (T)referenceConfig.get();

    }

    public <T> T getConsumer(String className){
        ReferenceConfig referenceConfig = referenceConfig();
        referenceConfig.setInterface(className);
        return (T)referenceConfig.get();

    }
}
