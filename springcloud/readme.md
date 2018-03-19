参考资料：[http://blog.didispace.com/Spring-Cloud%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/](http://blog.didispace.com/Spring-Cloud%E5%9F%BA%E7%A1%80%E6%95%99%E7%A8%8B/)

在eureka-server中配置访问地址，[http://localhost:1111](http://localhost:1111)。  
先启动eureka-server,然后启动eureka-client。通过http://localhost:2111/hello，访问对应的controller信息。

注意：

springcloud中client的application路径配置需要注意,如果需要使用默认路径，java类路径为xx.xxx.application.java  。参考资料：[http://blog.csdn.net/u014788227/article/details/53670112](http://blog.csdn.net/u014788227/article/details/53670112)


官网资料地址：[`https://springcloud.cc/spring-cloud-brixton.html#_quick_start`](https://springcloud.cc/spring-cloud-brixton.html#_quick_start)
