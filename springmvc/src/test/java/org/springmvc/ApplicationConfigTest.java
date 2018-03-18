package org.springmvc;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
//@ComponentScan(basePackages = {"com.swwx.payright.notify","com.swwx.payright.notify.aspect", "com.swwx.charm.event.lib.service"})
@ImportResource({"classpath:spring-servlet.xml"})
public class ApplicationConfigTest {

    public String dbUrl =
            "jdbc:mysql://172.30.21.20:3306/notify?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";

    public String dbUsername = "root";

    public String dbPassword = "zlb@2015";



    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
