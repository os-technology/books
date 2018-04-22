package com.springcloud.config.server.git.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ConfigServerGitApplication
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/17上午8:26
 */
@EnableConfigServer
@SpringBootApplication
@ComponentScan(basePackages = "com.springcloud.config.server.git")
public class ConfigServerGitApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServerGitApplication.class)
                .web(true).run(args);
    }
}
