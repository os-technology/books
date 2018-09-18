本模块配套资料地址：链接: [https://pan.baidu.com/s/1INw2cc5Fvj7MDsG3EYbTAQ](https://pan.baidu.com/s/1INw2cc5Fvj7MDsG3EYbTAQ) 密码: x4gp

**题外话**：Spring 技术系列干货整理 [https://mp.weixin.qq.com/s/N507Cfb_mbkGvHtg_FIaVg](https://mp.weixin.qq.com/s/N507Cfb_mbkGvHtg_FIaVg)

**学习位置： 7.1 springboot的web开发支持**

#笔记整理

## 6.2.3 类型安全的配置(基于properties)
 * 上例中使用@Value注入每个配置在实际项目中会显得格外麻烦，因为我们的配置通常会是许多个，若使用上例的方式则要使用`@Value`注入很多次。
 * Spring Boot还提供了基于类型安全的配置方式，通过`@ConfigurationProperties`将`properties`属性和一个Bean及其属性关联，从而实现类型安全的配置。

 * 具体操作如下：
  1. 创建一个配置文件`author.properties`，指定配置内容如下：
  
     ```bash
     book.author=author
     book.name=spring boot config
     ```
  2. 根据配置内容，得到统一前缀为book，则对应的bean中使用如下注解

     ```java
     @ConfigurationProperties(prefix = "book")//加载properties文件内的配置，prefix指定配置的前缀
     @PropertySource("classpath:author.properties")//指定加载的配置文件名称，如果是在 application.properties 或者application.yml 中配置，则无需该注解进行加载。
     ```
  **注意**：系统配置文件如果与指定配置文件配置了同样的参数信息，则其他配置文件的相同配置参数值会被系统文件配置值覆盖。demo参见`boot2->ch_6_x`模块，`BookAttrbutes.java`类。
  
## 6.4 profile配置

 * profile是spring针对不同的环境进行不同的配置提供支持的，全局profile配置采用`application-{profile}。properties`(如application-prod.properties)
 * 通过在`application.properties`设置 `spring.profiles.active=dev`来指定活动的profile配置。
 * demo参见`boot2->ch_6_x`模块

 
## 6.5 SpringBoot运行原理

* 查看当前项目查看自动配置信息的三种方式
 
 ```
 1. 在application.properties中配置  debug=true
 2. VM参数中添加 -Ddebug
 3. jar方式启动命令   java -jar xxx.jar --debug
 ```
 
 启动后已启用的自动配置为 `Positive matches:`，未启用的自动配置为 `Negative matches:`
 
 ### 6.5.1 运作原理
 `@SpringBootApplication`为一个组合注解，核心功能由`@EnableAutoConfiguration`提供