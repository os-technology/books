本教程参考资料：[http://blog.didispace.com/Spring-Cloud基础教程/](http://blog.didispace.com/Spring-Cloud基础教程/)

GitHub地址：[https://github.com/dyc87112/SpringCloud-Learning.git](https://github.com/dyc87112/SpringCloud-Learning.git)

###eureka部分
在eureka-server中配置访问地址，[http://localhost:1111](http://localhost:1111)。  
先启动eureka-server,然后启动eureka-client。通过http://localhost:2111/hello，访问对应的controller信息。

注意：

springcloud中client的application路径配置需要注意,如果需要使用默认路径，java类路径为xx.xxx.application.java  。参考资料：[http://blog.csdn.net/u014788227/article/details/53670112](http://blog.csdn.net/u014788227/article/details/53670112)


官网资料地址：[`https://springcloud.cc/spring-cloud-brixton.html#_quick_start`](https://springcloud.cc/spring-cloud-brixton.html#_quick_start)

spring-cloud-consul 资料地址：[https://springcloud.cc/spring-cloud-consul.html](https://springcloud.cc/spring-cloud-consul.html)

###consul配置部分

在consul-client的pom里面，dependencies部分添加

```xml
<!--选用的版本不可以太高，高版本基于JDK1.8开发，如果JDK版本较低，则会报错-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.4.RELEASE</version>
    <type>pom</type>
</dependency>
```
其他部分按照教程即可。
注意：如果application.java的路径高于三层包路径，则需要指定基础包范围，即服务的发现路径。`@ComponentScan(basePackages = "com.springcloud.eureka.client.consul")`或者在SpringBootApplication 注解上添加如下内容：`@SpringBootApplication(scanBasePackages = "com.springcloud.eureka.client")`

consul版本不要选太高，否则可能导致服务无法正常，本demo使用0.9.0版本。

