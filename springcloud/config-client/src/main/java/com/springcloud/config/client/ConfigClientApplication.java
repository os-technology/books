package com.springcloud.config.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ConfigClientApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/21上午11:51
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.springcloud.config.client")
public class ConfigClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApplication.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}
