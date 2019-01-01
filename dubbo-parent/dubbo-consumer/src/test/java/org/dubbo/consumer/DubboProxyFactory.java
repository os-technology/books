package org.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.util.StringUtils;

/**
 * @author code
 * @Title: DubboProxyFactory
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/12/29下午6:42
 */
public class DubboProxyFactory {

    ReferenceConfig reference;

    /**
     * 超时时间
     */
    private Integer timeout;

    public DubboProxyFactory(ApplicationConfig application, RegistryConfig registry) {
        reference = new ReferenceConfig(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        if(timeout != null) {
            reference.setTimeout(timeout);
        }
    }

    public Object create(Class clazz, String version) {
        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        // 引用远程服务
        reference.setInterface(clazz);
        if(!StringUtils.isEmpty(version)) {
            reference.setVersion(version);
        }

        return reference.get();
    }


    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
