**源码地址**：[https://github.com/spring-projects/spring-framework](https://github.com/spring-projects/spring-framework)  
**准备工作**：gradle环境，IDE，本笔记使用idea工具进行操作。
下载完成后，项目根目录下有个import-into-eclipse.md文件，打开，按照说明进行编译。

* 3.1 constructor-arg

 类的构造函数会全部进行实例化。参见`ConstructorArgJunitTest`测试类
 
 ApplicationContext的初始化和BeanFactory有一个重大的区别：BeanFactory在初始化容器时，并未实例化Bean，直到第一次访问某个Bean时才实例目标Bean；而ApplicationContext则在初始化应用上下文时就实例化所有单实例的Bean。因此ApplicationContext的初始化时间会比BeanFactory稍长一些，不过稍后的调用则没有"第一次惩罚"的问题。
 
 **ClassPathResource** : spring配置文件读取类
 
 spring profile 多环境配置管理
 [https://www.cnblogs.com/pangguoming/p/5888871.html](https://www.cnblogs.com/pangguoming/p/5888871.html)