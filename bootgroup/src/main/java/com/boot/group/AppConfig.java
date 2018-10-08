package com.boot.group;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

/**
 * @author code
 * @Title: AppConfigTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/8上午11:42
 */
@Configuration
public class AppConfig {
//    public String dbUrl = "jdbc:mysql://10.5.18.20:3306/face?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
//
//    public String dbUsername = "root";
//
//    public String dbPassword = "zlb@2015";
//    @Bean
//    public DataSource dataSource() {
//
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl(dbUrl);
//        dataSource.setUsername(dbUsername);
//        dataSource.setPassword(dbPassword);
//        dataSource.setInitialSize(5);
//        dataSource.setMaxActive(20);
//        dataSource.setMaxIdle(10);
//        dataSource.setMinIdle(5);
//        dataSource.setTestOnBorrow(true);
//        dataSource.setValidationQuery("select 1");
//        return dataSource;
//
//    }

    @Autowired
    private ComboPooledDataSource dataSource;
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(false);
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan("com.boot.group.dict.entity");
        factory.setJpaDialect(new HibernateJpaDialect());
        Properties props = new Properties();
        props.put("hibernate.ejb.naming_strategy", "com.boot.group.TableNamingStrategy");
        factory.setJpaProperties(props);
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
