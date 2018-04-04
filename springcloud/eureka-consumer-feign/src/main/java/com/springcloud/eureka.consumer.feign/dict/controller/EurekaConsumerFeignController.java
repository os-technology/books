package com.springcloud.eureka.consumer.feign.dict.controller;

import com.springcloud.eureka.consumer.feign.dict.client.FeignConsumerClient;
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
public class EurekaConsumerFeignController {

    @Autowired
   FeignConsumerClient feignConsumerClient;

    @GetMapping("/feign")
    public String consumer(){

        String feignContent = feignConsumerClient.feign()+" - feign";
        System.out.println(feignContent);
        return feignContent;
    }


}
