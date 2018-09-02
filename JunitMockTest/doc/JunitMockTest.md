#JunitMockTest

**说明：**本模块基于springboot+myBatis进行构建，仅能查询数据，增删改操作不可用。

##配置
####mock测试创建步骤如下
* 创建数据库
* 创建库表

	```sql
	CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `userid` int(11) DEFAULT NULL,
  `orgid` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni` (`userid`,`orgid`,`create_time`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

	#mock数据表
	CREATE TABLE `dataService`.`mocktable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL COMMENT '名称',
  `data` VARCHAR(45) NOT NULL COMMENT '数据',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`))
COMMENT = 'mock数据表';
INSERT INTO `dataService`.`mocktable` (`id`, `name`, `data`, `create_time`) VALUES ('1', '123', 'aa', '2018-09-01 18:27:37');

	
	```	
* 调整模块的数据库名称
* 使用单元测试，测试数据是否能正常插入


 **特殊类说明：**
 
 `com.code.junit.mock.boot.pageholder.MybatisPageInterceptor.java` :mybatis分页插件
 
 该插件依赖如下：
 
 ```xml
 <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.6</version>
        </dependency>
 ```
 在`mybatis-config.xml`使用方式如下：
 
 ```xml
	 <?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
	<configuration>
		<typeAliases>
			<typeAlias alias="DemoDO" type="com.lxjr.credit.account.dao.data.DemoDO" />
		</typeAliases>
	
		 <plugins>
	        <plugin interceptor="com.code.junit.mock.boot.pageholder.MybatisPageInterceptor">
	            <!-- 
	            <property name="dialectClass" value="com.code.junit.mock.boot.pageholder.dialect.OracleDialect"/>
	             -->
	            <property name="dialectClass" value="com.code.junit.mock.boot.pageholder.dialect.MySQLDialect" />
	        </plugin>
	    </plugins>
		
		<mappers>
		    <!--  
			<mapper resource="dal/sqlmap/demoUser-mapper.xml" />
			-->
		</mappers>
		
	</configuration>
 ```
 
 如果开启aop操作，则以下两个包是必须的.
 
 ```xml
 <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.9.1</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.1</version>
        </dependency>
 ```
 同时，单元测试采用新版注解方式
 
 ```java
 //在高版本的Spring框架中（Spring4.2以后），@TransactionConfiguration已经标注为过时的注解
 //替代@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
 @Transactional(transactionManager="transactionManager")
 @Rollback(value = false)
 
 ```
 
 ##mock与powerMockito版本对应关系
 相信有些朋友也碰到和我一样的问题，mockito结合powermock做单元测试会碰到一些明明程序看起来没问题，却始终报错。
有可能的问题就是版本使用不对，大家如果遇到这样的问题可以试试。（PS:当然也不绝对一定是版本的问题）
 
|Mockito                     | PowerMock|
|---|---|
|2.0.0-beta - 2.0.42-beta    |   1.6.5+   |
|1.10.19                     |   1.6.4   |
|1.10.8 - 1.10.x             |   1.6.2+   |
|1.9.5-rc1 - 1.9.5           |   1.5.0 - 1.5.6   |
|1.9.0-rc1 & 1.9.0           |   1.4.10 - 1.4.12   |
|1.8.5                       |   1.3.9 - 1.4.9   |
|1.8.4                       |   1.3.7 & 1.3.8   |
|1.8.3                       |   1.3.6   |
|1.8.1 & 1.8.2               |   1.3.5   |
|1.8                         |   1.3   |
|1.7                         |   1.2.5   |
 
 报错参考如下：
 
 ```java
 
java.lang.AbstractMethodError: org.powermock.api.mockito.internal.mockmaker.PowerMockMaker.isTypeMockable(Ljava/lang/Class;)Lorg/mockito/plugins/MockMaker$TypeMockability;

	at org.mockito.internal.util.MockUtil.typeMockabilityOf(MockUtil.java:29)
	at org.mockito.internal.util.MockCreationValidator.validateType(MockCreationValidator.java:22)
	at org.mockito.internal.creation.MockSettingsImpl.validatedSettings(MockSettingsImpl.java:232)
	at org.mockito.internal.creation.MockSettingsImpl.build(MockSettingsImpl.java:226)
	at org.mockito.internal.MockitoCore.mock(MockitoCore.java:64)
	at org.mockito.Mockito.mock(Mockito.java:1855)
 ```
 
##Mybatis部分

**库表说明配置**

* mocktable : 配置mapper.xml映射文件进行操作
* user : 没有配置mapper.xml，通过注解进行数据操作
 
 