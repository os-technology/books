#SpringBoot
springboot启动流程解析[https://www.cnblogs.com/trgl/p/7353782.html](https://www.cnblogs.com/trgl/p/7353782.html)  
教程地址：[http://blog.didispace.com/Spring-Boot基础教程/](http://blog.didispace.com/Spring-Boot基础教程/)    
GitHub源码地址：[https://github.com/dyc87112/SpringBoot-Learning](https://github.com/dyc87112/SpringBoot-Learning)   
社区信息：[spring for all 社区](http://www.spring4all.com/)   
[Spring-Boot-Reference-Guide-ZH](http://blog.didispace.com/books/spring-boot-reference/)

其他参考资料：[https://github.com/rhwayfun/spring-boot-learning-examples](https://github.com/rhwayfun/spring-boot-learning-examples)  
其他教程地址：[http://www.majunwei.com/view/201708040918493826.html](http://www.majunwei.com/view/201708040918493826.html)  
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

@Controller和@RestController的区别？
官方文档：
@RestController is a stereotype annotation that combines @ResponseBody and @Controller.
意思是：
@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。

1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。

例如：本来应该到success.jsp页面的，则其显示success.

2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
```