package com.packing.banner.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: SpringBootApplicationBannerStart
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/29下午4:27
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.packing.banner.boot")
public class SpringBootApplicationBannerStart {

    /**
     * 注意：如果<springframework-version>4.2.1.RELEASE</springframework-version>版本为4.1.5.RELEASE，则无法正常启动，至少使用4.2.1.RELEASE以上版本方可。该pom文件配置在springbootApplication模块下。
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationBannerStart.class, args);

        //关闭banner图案
//        SpringApplication app = new SpringApplication(SpringBootApplicationBannerStart.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
    }
}
