#JunitMockTest

**说明：**本模块基于springboot+myBatis进行构建，仅能查询数据，增删改操作不可用。
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
 
 