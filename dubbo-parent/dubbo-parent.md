dubbo consumer通过Java代码进行配置时，如果provider包含版本号，则必须配置版本号信息，否则无法正常访问。

#### [Spring Boot的Maven插件Spring Boot Maven plugin](https://blog.csdn.net/crazy__qu/article/details/79110269)

Spring Boot的Maven插件（Spring Boot Maven plugin）能够以Maven的方式为应用提供Spring Boot的支持，即为Spring Boot应用提供了执行Maven操作的可能。
Spring Boot Maven plugin能够将Spring Boot应用打包为可执行的jar或war文件，然后以通常的方式运行Spring Boot应用。
Spring Boot Maven plugin的最新版本为2017.6.8发布的1.5.4.RELEASE，要求Java 8, Maven 3.2及以后。


1. Spring Boot Maven plugin的5个Goals

 * spring-boot:repackage，默认goal。在mvn package之后，再次打包可执行的jar/war，同时保留mvn package生成的jar/war为.origin
 * spring-boot:run，运行Spring Boot应用
 * spring-boot:start，在mvn integration-test阶段，进行Spring Boot应用生命周期的管理
 * spring-boot:stop，在mvn integration-test阶段，进行Spring Boot应用生命周期的管理
 * spring-boot:build-info，生成Actuator使用的构建信息文件build-info.properties

2. pom文件

	```xml
	<build>  
    <plugins>  
        <plugin>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-maven-plugin</artifactId>  
                        <version>1.5.4.RELEASE</version>  
        </plugin>  
    </plugins>  
</build>
	```

3. mvn package spring-boot:repackage说明

 Spring Boot Maven plugin的最主要goal就是repackage，其在Maven的package生命周期阶段，能够将mvn package生成的软件包，再次打包为可执行的软件包，并将mvn package生成的软件包重命名为*.original。

 基于上述配置，对一个生成Jar软件包的项目执行如下命令。

 `mvn package spring-boot:repackage  `