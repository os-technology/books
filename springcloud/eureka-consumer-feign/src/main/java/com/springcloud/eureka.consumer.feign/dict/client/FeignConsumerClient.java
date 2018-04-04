package com.springcloud.eureka.consumer.feign.dict.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 创建一个Feign的客户端接口定义。使用@FeignClient注解
 * 来指定这个接口所要调用的服务名称，接口中定义的各个函数
 * 使用Spring MVC的注解就可以来绑定服务提供方的REST接口，
 * 比如下面就是绑定eureka-client服务的/dc接口的例子
 *
 * @author yuijnshui@lxfintech.com
 * @Title: FeignConsumerClient
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/3下午7:24
 */

@FeignClient("eureka-client")
public interface FeignConsumerClient {

    @GetMapping("/dc")
    String feign();

}
