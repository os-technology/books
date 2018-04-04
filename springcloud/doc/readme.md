### Spring Cloud与Spring Boot版本匹配关系
[https://blog.csdn.net/ljj_9/article/details/78645267](https://blog.csdn.net/ljj_9/article/details/78645267)
###springcloud版本说明
说说Spring Cloud版本的那些事儿。

版本命名
之前提到过，Spring Cloud是一个拥有诸多子项目的大型综合项目，原则上其子项目也都维护着自己的发布版本号。那么每一个Spring Cloud的版本都会包含不同的子项目版本，为了要管理每个版本的子项目清单，避免版本名与子项目的发布号混淆，所以没有采用版本号的方式，而是通过命名的方式。

这些版本名字采用了伦敦地铁站的名字，根据字母表的顺序来对应版本时间顺序，比如：最早的Release版本：Angel，第二个Release版本：Brixton，以此类推……

版本号
经过上面的解释，不难猜出，之前所提到的Angel.SR6，Brixton.SR5中的SR6、SR5就是版本号了。

当一个版本的Spring Cloud项目的发布内容积累到临界点或者一个严重bug解决可用后，就会发布一个“service releases”版本，简称SRX版本，其中X是一个递增数字。

当前版本
通过下表，我们可以快速查阅当前各版本所包含的子项目，以及各子项目的版本号，通过此来决定需要选择怎么样的版本。

<table>
<thead>
<tr><th>Component</th><th>Angel.SR6</th><th>Brixton.SR5</th><th>Camden.M1</th><th>Camden.BUILD-SNAPSHOT</th></tr>
</thead>
<tbody>
<tr>
<td>spring-cloud-aws</td>
<td>1.0.4.RELEASE</td>
<td>1.1.1.RELEASE</td>
<td>1.1.1.RELEASE</td>
<td>1.1.2.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-bus</td>
<td>1.0.3.RELEASE</td>
<td>1.1.1.RELEASE</td>
<td>1.2.0.M1</td>
<td>1.2.0.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-cli</td>
<td>1.0.6.RELEASE</td>
<td>1.1.5.RELEASE</td>
<td>1.2.0.M1</td>
<td>1.2.0.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-commons</td>
<td>1.0.5.RELEASE</td>
<td>1.1.1.RELEASE</td>
<td>1.1.1.RELEASE</td>
<td>1.1.2.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-contract</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>1.0.0.M2</td>
<td>1.0.0.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-config</td>
<td>1.0.4.RELEASE</td>
<td>1.1.3.RELEASE</td>
<td>1.2.0.M1</td>
<td>1.2.0.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-netflix</td>
<td>1.0.7.RELEASE</td>
<td>1.1.5.RELEASE</td>
<td>1.2.0.M1</td>
<td>1.2.0.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-security</td>
<td>1.0.3.RELEASE</td>
<td>1.1.2.RELEASE</td>
<td>1.1.2.RELEASE</td>
<td>1.1.3.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-starters</td>
<td>1.0.6.RELEASE</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>spring-cloud-cloudfoundry</td>
<td>&nbsp;</td>
<td>1.0.0.RELEASE</td>
<td>1.0.0.RELEASE</td>
<td>1.0.1.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-cluster</td>
<td>&nbsp;</td>
<td>1.0.1.RELEASE</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>spring-cloud-consul</td>
<td>&nbsp;</td>
<td>1.0.2.RELEASE</td>
<td>1.1.0.M1</td>
<td>1.1.0.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-sleuth</td>
<td>&nbsp;</td>
<td>1.0.6.RELEASE</td>
<td>1.0.6.RELEASE</td>
<td>1.0.7.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-stream</td>
<td>&nbsp;</td>
<td>1.0.2.RELEASE</td>
<td>Brooklyn.M1</td>
<td>Brooklyn.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-cloud-zookeeper</td>
<td>&nbsp;</td>
<td>1.0.2.RELEASE</td>
<td>1.0.2.RELEASE</td>
<td>1.0.3.BUILD-SNAPSHOT</td>
</tr>
<tr>
<td>spring-boot</td>
<td>1.2.8.RELEASE</td>
<td>1.3.7.RELEASE</td>
<td>1.4.0.RELEASE</td>
<td>1.4.0.RELEASE</td>
</tr>
<tr>
<td>spring-cloud-task</td>
<td>&nbsp;</td>
<td>1.0.2.RELEASE</td>
<td>1.0.2.RELEASE</td>
<td>1.0.3.BUILD-SNAPSHOT</td>
</tr>
</tbody>
</table>


不难看出，最初的Angel版本相对来说拥有的子项目较少，Brixton、Camden则拥有更全的子项目，所以能提供更多的组件支持。而Brixton与Camden之间，Brixton的发布子项目更为稳定，Camden则更为前瞻。

我在开始编写Spring Cloud系列博文时，刚好是Brixton的第一个RELEASE版本，所以果断采用了这个版本来作为样例基础。也可以看到，在这短短的几个月时间里，没有更新多少文章，但是其版本提升尽如此迅速，更加证明了该项目良好的发展势头。所以，何不现在就加入我们一起学习和实践这个将来也许会占领企业微服务架构的强大框架呢？

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
下载地址：  
Linux-64：[`https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_linux_amd64.zip`](https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_linux_amd64.zip)  
mac-64：[`https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_darwin_amd64.zip`](https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_darwin_amd64.zip)  
windows-64：[`https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_windows_amd64.zip`](https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_windows_amd64.zip)

###Spring Cloud构建微服务架构：服务消费（Ribbon）【Dalston版】

通过上一篇[《Spring Cloud构建微服务架构：服务消费（基础）》](http://blog.didispace.com/spring-cloud-starter-dalston-2-1/)，我们已经学会如何通过LoadBalancerClient接口来获取某个服务的具体实例，并根据实例信息来发起服务接口消费请求。但是这样的做法需要我们手工的去编写服务选取、链接拼接等繁琐的工作，对于开发人员来说非常的不友好。所以，下来我们看看Spring Cloud中针对客户端负载均衡的工具包：Spring Cloud Ribbon。

ribbon服务的controller类中，我们除了去掉了原来与LoadBalancerClient相关的逻辑之外，对于RestTemplate的使用，我们的第一个url参数有一些特别。这里请求的host位置并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成。那么这样的请求为什么可以调用成功呢？因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。

###Spring Cloud Feign

Spring Cloud Feign是一套基于Netflix Feign实现的声明式服务调用客户端。它使得编写Web服务客户端变得更加简单。我们只需要通过创建接口并用注解来配置它既可完成对Web服务接口的绑定。它具备可插拔的注解支持，包括Feign注解、JAX-RS注解。它也支持可插拔的编码器和解码器。Spring Cloud Feign还扩展了对Spring MVC注解的支持，同时还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。


`EurekaConsumerFeignApplication`类添加`@EnableFeignClients`**【开启扫描Spring Cloud Feign客户端的功能】**注解之后，如果类路径不在三层包之内，则需要指定包路径，在该注解上添加`basePackages`参数的路径信息，同时`@ComponentScan`的参数不动。

 说明：  
 
 * `@EnableFeignClients`如果没有添加路径参数，则启动时报接口无法正常实例化异常，并启动失败。
 * `@EnableFeignClients`添加了参数路径设置，如果`@ComponentScan`没有指定应用的发现路径，则服务启动后，无法正常进行调用。会提示500错误。