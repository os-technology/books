package com.wisely.highlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: ELConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/15上午8:40
 */

@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch2.el")
@PropertySource("classpath:ch2_EL_test.properties")
public class ELConfig {

    @Value("Come on,you can do it well!")
    private String normal;

    @Value("#{systemProperties['os.name']} - #{systemProperties['os.version']}")
    private String osName;

    @Value("#{T(java.lang.Double).parseDouble(T(java.lang.Math).random()*100)}")
    private double randomNumber;

    @Value("#{demoService.author}")
    private String fromAnother;

    @Value("classpath:ch2_EL_test.txt")
    private Resource testFile;
    @Value("http://aposoft.cn/")
    private Resource url;
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    /**
     * 使用@Value注入配置文件，需要配置一个PropertySourcesPlaceholderConfigurer的Bean
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(url.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
