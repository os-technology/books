package com.springcloud.eureka.consumer.dict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ConsumerController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/30上午11:56
 */
@RestController
public class EurekaConsumerController {

    /**
     * LoadBalancerClient,这是一个负载均衡客户端的抽象定义，下面我们就看看如何使用Spring Cloud提供的负载均衡器客户端接口来实现服务的消费。
     */
    @Autowired//(required = false)
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;


    private String getUrl(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        return "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort();
    }

    /**
     * 我们注入了LoadBalancerClient和RestTemplate，
     * 并在/consumer接口的实现中，先通过loadBalancerClient
     * 的choose函数来负载均衡的选出一个eureka-client的服务实例，
     * 这个服务实例的基本信息存储在ServiceInstance中，然后通过这
     * 些对象中的信息拼接出访问/dc接口的详细地址，最后再利用RestTemplate
     * 对象实现对服务提供者接口的调用。
     * @return
     */
    @GetMapping("/consumer")
    public String consumer(){

        String url = getUrl()+"/dc";
        System.out.println(url);
//        return restTemplate.getForObject(url,String.class);
        return restTemplate.getForObject("http://eureka-client/dc",String.class);
    }
    @GetMapping("/con_print")
    public String print(){
        String url = getUrl()+"/hello";
        System.out.println(url);//http://10.39.75.32:2111/hello 无法正常被调用，需要使用 http://eureka-client 方式才可以
        return restTemplate.getForObject(url,String.class);
    }

}
