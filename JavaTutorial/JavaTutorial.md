#### 2018-9-12 lombok(省略set，get方法)

 ```xml
 <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.2</version>
    <scope>compile</scope>
 </dependency>
 ```
 * @Data 在类上添加，表示类中所有属性都添加setter，getter方法
 * @NoArgsConstructor 在类上添加，表示无参构造函数
 * @AllArgsConstructor 表示全参构造函数
 * @Build 在类上使用，表示该类使用构造者模式进行传参，参见`DemoModel.java`


#### 2018-9-11 logback的介绍
[https://www.cnblogs.com/lixuwu/p/5804793.html](https://www.cnblogs.com/lixuwu/p/5804793.html)

  * Logback是由log4j创始人设计的又一个开源日志组件。logback当前分成三个模块：logback-core,logback- classic和logback-access。logback-core是其它两个模块的基础模块。logback-classic是log4j的一个 改良版本。此外logback-classic完整实现SLF4J API使你可以很方便地更换成其它日志系统如log4j或JDK14 Logging。logback-access访问模块与Servlet容器集成提供通过Http来访问日志的功能。 Logback是要与SLF4J结合起来用两个组件的官方网站如下：

 ```
  logback的官方网站： http://logback.qos.ch

  SLF4J的官方网站：http://www.slf4j.org

  本文章用到的组件如下：请自行到官方网站下载！

  logback-access-1.0.0.jar
  logback-classic-1.0.0.jar
  logback-core-1.0.0.jar
  slf4j-api-1.6.0.jar

  maven配置

  <dependency>  
       <groupId>ch.qos.logback</groupId>  
       <artifactId>logback-classic</artifactId>  
    <version>1.0.11</version>  
  </dependency> 
  这样依赖包全部自动下载了！
 ```
 
 