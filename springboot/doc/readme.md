#SpringBoot

[http://blog.didispace.com/Spring-Boot基础教程/](http://blog.didispace.com/Spring-Boot基础教程/)

[Spring-Boot-Reference-Guide-ZH](http://blog.didispace.com/books/spring-boot-reference/)

**学习位置：**  
1. [http://blog.didispace.com/springbootproperties/](http://blog.didispace.com/springbootproperties/)

较新版的Spring Boot取消了@SpringApplicationConfiguration这个注解,用@SpringBootTest就可以了，`RunWith`注解指定的class类，使用`SpringJUnit4ClassRunner.class`

**详细注解** 参见chapter1模块中的测试类`SpringbootApplicationTests`

###源码参考教程

[https://blog.csdn.net/jamet/article/category/7112037](https://blog.csdn.net/jamet/article/category/7112037)

SpringBoot(1.5.6.RELEASE)源码解析  
[http://www.cnblogs.com/dylan-java/p/7450914.html](http://www.cnblogs.com/dylan-java/p/7450914.html)

注解说明：

```java
@Configuration注解(可以理解为xml里面的<beans>标签)，一般和@Bean注解(可以理解为xml里面的<bean>标签)搭配使用。使用这2个注解可以创建一个配置类
@EnableAutoConfiguration注解自动载入应用程序所需要的所有Bean，这依赖于SpringBoot在类路径中的查找
```