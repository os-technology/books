# SpringCloud

	本demo已经尽力以JDK1.7为基础进行构建，但是由于官方要求JDK1.8，所以demo的部分模块必须使用JDK1.8运行，否则报错。
	官方要求使用jdk8，虽然spring boot在jdk7中也能运行，但是这里和spring cloud集成的时候就出问题了，问题表现为在maven build的时候出现8194错误代码。
	
本教程参考资料：[http://blog.didispace.com/Spring-Cloud基础教程/](http://blog.didispace.com/Spring-Cloud基础教程/)

GitHub地址：[https://github.com/dyc87112/SpringCloud-Learning.git](https://github.com/dyc87112/SpringCloud-Learning.git)

社区信息：[spring for all 社区](http://www.spring4all.com/)

**学习位置**  
1. [链接地址](http://blog.didispace.com/spring-cloud-starter-dalston-3/)

### Spring Cloud与Spring Boot版本匹配关系
Dalston版相关描述：[https://blog.csdn.net/ljj_9/article/details/78645267](https://blog.csdn.net/ljj_9/article/details/78645267)

Dalston.SR1对应JDK1.8。版本查找方式再pom文件中进行。

```
<dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Dalston.SR1</version><!--Dalston.SR1-->
                <!--<type>pom</type>-->
                <!--<scope>import</scope>-->
            </dependency>
            
            
点击Dalston.SR1 ,在父pom中得到

 <parent>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-dependencies-parent</artifactId>
		<version>1.3.2.RELEASE</version>
		<relativePath/>
	</parent>
	
继续点击1.3.2.REALEASE，进入父pom，得到
	
	<scm>
		<url>https://github.com/spring-cloud/spring-cloud-build</url>
		<connection>scm:git:git://github.com/spring-cloud/spring-cloud-build.git</connection>
		<developerConnection>scm:git:ssh://git@github.com/spring-cloud/spring-cloud-build.git</developerConnection>
		<tag>HEAD</tag>
	</scm>
	
	打开<url>标签的地址，看到java.version=1.8
```
###springcloud版本说明
说说Spring Cloud版本的那些事儿。

<font color=blue>springBoot 2.0版本已不再支持JDK1.7，需要将jdk版本升级为1.8方可正常使用。</font>


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


###eureka部分
在eureka-server中配置访问地址，[http://localhost:1111](http://localhost:1111)。  
先启动eureka-server,然后启动eureka-client。通过http://localhost:2111/hello，访问对应的controller信息。

#### **注意：**

**谷歌浏览器mac版会发起两次请求，其他浏览器会正常的发起一次请求，原因尚不清楚。**

springcloud中client的application路径配置需要注意,如果需要使用默认路径，java类路径为xx.xxx.application.java  。参考资料：[http://blog.csdn.net/u014788227/article/details/53670112](http://blog.csdn.net/u014788227/article/details/53670112)


官网资料地址：[`https://springcloud.cc/spring-cloud-brixton.html#_quick_start`](https://springcloud.cc/spring-cloud-brixton.html#_quick_start)

spring-cloud-consul 资料地址：[https://springcloud.cc/spring-cloud-consul.html](https://springcloud.cc/spring-cloud-consul.html)

###consul部分

#####1. consul配置
在consul-client的pom里面，dependencies部分添加

```xml
<!--选用的版本不可以太高。2.0.x基于JDK1.8开发，如果使用JDK1.7编译会报错-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.10.RELEASE</version>
    <type>pom</type>
</dependency>
```
其他部分按照教程即可。

启动consul命令

```
consul agent -dev
```
  
注意：如果application.java的路径高于三层包路径，则需要指定基础包范围，即服务的发现路径。`@ComponentScan(basePackages = "com.springcloud.eureka.client.consul")`或者在SpringBootApplication 注解上添加如下内容：`@SpringBootApplication(scanBasePackages = "com.springcloud.eureka.client")`

consul版本不要选太高，否则可能导致服务无法正常，本demo使用0.9.0版本。  
#####2. 下载地址：  
Linux-64：[`https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_linux_amd64.zip`](https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_linux_amd64.zip)  
mac-64：[`https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_darwin_amd64.zip`](https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_darwin_amd64.zip)  
windows-64：[`https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_windows_amd64.zip`](https://releases.hashicorp.com/consul/0.9.0/consul_0.9.0_windows_amd64.zip)


#####3. 基于consul分布式锁实现[demo尚不可用]
[http://blog.didispace.com/spring-cloud-consul-lock-and-semphore/](http://blog.didispace.com/spring-cloud-consul-lock-and-semphore/)
##### 4. 基于Consul的分布式信号量实现
[http://blog.didispace.com/spring-cloud-consul-lock-and-semphore-2/](http://blog.didispace.com/spring-cloud-consul-lock-and-semphore-2/)

###Spring Cloud构建微服务架构：服务消费（Ribbon）【Dalston版】

通过上一篇[《Spring Cloud构建微服务架构：服务消费（基础）》](http://blog.didispace.com/spring-cloud-starter-dalston-2-1/)，我们已经学会如何通过LoadBalancerClient接口来获取某个服务的具体实例，并根据实例信息来发起服务接口消费请求。但是这样的做法需要我们手工的去编写服务选取、链接拼接等繁琐的工作，对于开发人员来说非常的不友好。所以，下来我们看看Spring Cloud中针对客户端负载均衡的工具包：Spring Cloud Ribbon。

ribbon服务的controller类中，我们除了去掉了原来与LoadBalancerClient相关的逻辑之外，对于RestTemplate的使用，我们的第一个url参数有一些特别。这里请求的host位置并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成。那么这样的请求为什么可以调用成功呢？因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。

###Spring Cloud Feign

Spring Cloud Feign是一套基于Netflix Feign实现的声明式服务调用客户端。它使得编写Web服务客户端变得更加简单。我们只需要通过创建接口并用注解来配置它既可完成对Web服务接口的绑定。它具备可插拔的注解支持，包括Feign注解、JAX-RS注解。它也支持可插拔的编码器和解码器。Spring Cloud Feign还扩展了对Spring MVC注解的支持，同时还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。


`EurekaConsumerFeignApplication`类添加`@EnableFeignClients`**【开启扫描Spring Cloud Feign客户端的功能】**注解之后，如果类路径不在三层包之内，则需要指定包路径，在该注解上添加`basePackages`参数的路径信息，同时`@ComponentScan`的参数不动。

 说明：  
 
 * `@EnableFeignClients`如果没有添加路径参数，则启动时报接口无法正常实例化异常，并启动失败。
 * `@EnableFeignClients`添加了参数路径设置，如果`@ComponentScan`没有指定应用的发现路径，则服务启动后，无法正常进行调用。会提示500错误。

 
###Spring Cloud Feign的文件上传实现

在Spring Cloud封装的Feign中并不直接支持传文件，但可以通过引入Feign的扩展包来实现，本来就来具体说说如何实现。

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.16.20</version>
    <scope>provided</scope>
</dependency>
        
        
        
 @SneakyThrows
这个注解用在方法上，可以将方法中的代码用try-catch语句包裹起来，捕获异常并在catch中用Lombok.sneakyThrow(e)把异常抛出，可以使用@SneakyThrows(Exception.class)的形式指定抛出哪种异常，很简单的注解，直接看个例子：

public class SneakyThrows implements Runnable {
    @SneakyThrows(UnsupportedEncodingException.class)
    public String utf8ToString(byte[] bytes) {
        return new String(bytes, "UTF-8");
    }

    @SneakyThrows
    public void run() {
        throw new Throwable();
    }
}

实际效果相当于：

public class SneakyThrows implements Runnable {
    @SneakyThrows(UnsupportedEncodingException.class)
    public String utf8ToString(byte[] bytes) {
        try{
            return new String(bytes, "UTF-8");
        }catch(UnsupportedEncodingException uee){
            throw Lombok.sneakyThrow(uee);
        }
    }

    @SneakyThrows
    public void run() {
        try{
            throw new Throwable();
        }catch(Throwable t){
            throw Lombok.sneakyThrow(t);
        }
    }
}
```

<font color=red><B>注意：</B></font>  
单元测试的java类路径必须与application.java类的路径相同，否则无法正常实例化接口进行调用。本示例中，`eureka-feign-upload-client`模块，application位置在`com.springcloud.feign.upload.client.app`包下，则单元测试的位置也需要在Test中对应的包下进行创建。否则提示接口无法实例化。原因尚不清楚。

###分布式配置中心

 ```
 Spring Cloud Config是Spring Cloud团队创建的一个全新项目，用来为分布式系统中的基础设施和微服务应用提供集中化的外部配置支持，它分为服务端与客户端两个部分。其中服务端也称为分布式配置中心，它是一个独立的微服务应用，用来连接配置仓库并为客户端提供获取配置信息、加密/解密信息等访问接口；而客户端则是微服务架构中的各个微服务应用或基础设施，它们通过指定的配置中心来管理应用资源与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息。Spring Cloud Config实现了对服务端和客户端中环境变量和属性配置的抽象映射，所以它除了适用于Spring构建的应用程序之外，也可以在任何其他语言运行的应用程序中使用。由于Spring Cloud Config实现的配置中心默认采用Git来存储配置信息，所以使用Spring Cloud Config构建的配置服务器，天然就支持对微服务应用配置信息的版本管理，并且可以通过Git客户端工具来方便的管理和访问配置内容。当然它也提供了对其他存储方式的支持，比如：SVN仓库、本地化文件系统。

在本文中，我们将学习如何构建一个基于Git存储的分布式配置中心，并对客户端进行改造，并让其能够从配置中心获取配置信息并绑定到代码中的整个过程。
 ```

 **项目模块**：springcloud-config-repo-demo(配置仓库名称),config-client(配置中心的应用名称),config-server-git(配置中心)
 
 配置仓库地址：[https://github.com/os-technology/springcloud-config-repo-demo](https://github.com/os-technology/springcloud-config-repo-demo)。配置仓库必须单独进行创建，不可在其他项目的子模块等位置创建，否则无法正常生效。
 
 该部分目前只能使用JDK1.8进行正常启动。操作方式如下：
 
**config-servier-git模块操作**
 
 ```
 访问配置信息的URL与配置文件的映射关系如下：

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
 ```
 启动config-server-git模块，然后输入 [http://localhost:2119/config-client/default/master](http://localhost:2119/config-client/default/master)得到如下结果：
 

 
 ```json
 {
name: "config-client",
profiles: - [
"default"
],
label: "master",
version: null,
state: null,
propertySources: - [
- {
name: "https://github.com/os-technology/springcloud-config-repo-demo/config-client.yml",
source: - {
info.profile: "default",
info.from: "git"
}
}
]
}
 ```
 
 URL中的default部分，可以替换成dev。访问时会得到对应的json信息。
 
 **config-client模块**  
 
 在微服务应用中获取上述的配置信息。  
 
 **该模块(config-client)这里需要格外注意：上面这些属性必须配置在bootstrap.properties中，这样config-server中的配置信息才能被正确加载。**
 
 pom.xml配置中，必须要再次添加如下依赖方可正常访问。否则访问`http://localhost:2120/info`提示404异常。
 
 ```
 <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Dalston.SR1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
 ```
 
 在完成了上面你的代码编写之后，读者可以将config-server-git、config-client都启动起来，然后访问 [http://localhost:2120/info](http://localhost:2120/info) 


 
 
 