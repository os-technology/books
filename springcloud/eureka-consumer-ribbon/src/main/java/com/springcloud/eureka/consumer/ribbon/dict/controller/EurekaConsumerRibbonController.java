package com.springcloud.eureka.consumer.ribbon.dict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: EurekaConsumerRibbonController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/2下午4:22
 */
@RestController
public class EurekaConsumerRibbonController {


    @Autowired
    RestTemplate restTemplate;


    /**
     * 我们注入了LoadBalancerClient和RestTemplate，
     * 并在/consumer接口的实现中，先通过loadBalancerClient
     * 的choose函数来负载均衡的选出一个eureka-client的服务实例，
     * 这个服务实例的基本信息存储在ServiceInstance中，然后通过这
     * 些对象中的信息拼接出访问/dc接口的详细地址，最后再利用RestTemplate
     * 对象实现对服务提供者接口的调用。
     *
     * @return
     */
    @GetMapping("/ribbon")
    public String ribbon() {
        String result = restTemplate.getForObject("http://eureka-client/dc", String.class);
        return result;
    }
    @GetMapping("/test")
    public String test() {
        String result = restTemplate.getForObject("http://eureka-client/dc", String.class);
        return result;
    }
}
