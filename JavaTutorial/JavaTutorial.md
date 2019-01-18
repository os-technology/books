#### 2019-1-18

添加`hibernate-validate` 参数校验插件

依赖包内容如下：

 ```xml
 <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>5.3.6.Final</version>
        </dependency>
        <dependency>
            <groupId>javax.el</groupId>
            <artifactId>javax.el-api</artifactId>
            <version>2.2.5</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.web</groupId>
            <artifactId>javax.el</artifactId>
            <version>2.2.5</version>
        </dependency>
 ```
 
 **校验规则整理**
 
  ```
  @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值【可被用于null或必须满足的最大数值数据进行校验】
  
  如果传参必须指定值信息，则可以使用正则表达式
 
  @Pattern(regexp = EncryptContant.HMACSHA256+"|"+EncryptContant.MD5,message = "加密方式参数值错误")
    private String signType;
  
  枚举类的校验参见@EnumValue注解
  
  ```


#### 2018-11-6 
**素数判断逻辑**：假设一个数不是素数的话，那么它就是合数，即意味着这个数可以由两个自然数相乘得到，其中一个大于或等于它的平方根，另一个小于或等于它的平方根。并且成对出现。因此，判断一个数是否为素数，只需判断从2开始到该整数的平方根范围内是否有整数能整除该数，有则为合数，无则为素数。

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
 
 