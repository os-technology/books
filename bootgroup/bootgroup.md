# bootgroup

模块说明：由springboot,jpa,shiro基础组件构成，用于进行demo学习演示。

### jpa部分

#### 概述
1. Java Persistence API（Java 持久层 API）：用于对象持久化的 API
2. 作用：使得应用程序以统一的方式访问持久层
3. 前言中提到了 Hibernate，那么JPA 与 Hibernate究竟是什么关系呢：
 * JPA 是 Hibernate 的一个抽象，就像 JDBC 和 JDBC 驱动的关系
 * JPA 是一种 ORM 规范，是 Hibernate 功能的一个子集 (既然 JPA 是规范，Hibernate 对 JPA 进行了扩展，那么说 JPA 是 Hibernate 的一个子集不为过)
 * Hibernate 是 JPA 的一个实现
4. JPA 包括三个方面的技术：
 * ORM 映射元数据，支持 XML 和 JDK 注解两种元数据的形式
 * JPA 的 API
 * 查询语言：JPQL。
本文也将详细介绍JPA ORM 映射元数据的注解方式和 JPA 的 API 以及 JPQL 三个方面

#### jpa-hibernate
 * **MySQL5Dialect与MySQL5InnoDBDialect有什么区别？**  
 他们最大的区别是，在使用Hibernate创建表时MySQL5InnoDBDialect会在生成的建表SQL语句最后加上"ENGINE=InnoDB"。
InnoDB是一种MySQL数据库引擎.MySQL5.5及之后使用它做为默认引擎。它提供了ACID兼容的事务（Transaction）功能，并提供外键支持。

* **MySQLDialect与MySQL5Dialect有什么区别？**  
MySQLDialect是针对MySQL5之前的版本。主要变化还是在于建表SQL语句。
MySQL由于4到5还是有不小的变化。比如varchar在4及之前版本最大长度限制为255，5及之后版本最大长度限制为65535。
MySQLInnoDBDialect会在生成的建表SQL语句最后加上"TYPE=InnoDB"。

* **MySQL5InnoDBDialect过时了**  
升级到 Hibernate 5 的时候，就会发现 MySQL5InnoDBDialect，被标注@Deprecated也就是过时了。不仅仅是 MySQL5InnoDBDialect 过时了，所有带InnoDB的 Dialect 都被标注过时了@Deprecated；在标注有 InnoDBDialect 过时的同时 新加了 MySQL55Dialect 及 MySQL57Dialect。
如果查看源码就会发现 MySQL55Dialect 与 MySQL5InnoDBDialect 源码一模一样。

 毕竟 MySQL 从 5.5 开始就默认使用 InnoDB 引擎，MySQL 8 已经移除了 MyISAM 引擎。Hibernate 的作者认为Dialect分为两类就没有什么必要了。
 
#### jpa配置

* 扫描 Repository Bean 所在的 package

 ```java
@EnableJpaRepositories({ "com.swwx.payright.face.dao" })
 ``` 
 或者
 
 ```xml
  <jpa:repositories base-package="com.boot.group.dict.dao" entity-manager-factory-ref="entityManagerFactory">
    </jpa:repositories>
 ```
 
#### jpa注解

* `@DynamicInsert`属性: 设置为true,设置为true,表示insert对象的时候,生成动态的insert语句,如果这个字段的值是null就不会加入到insert语句当中.默认false。
比如希望数据库插入日期或时间戳字段时，在对象字段为空的情况下，表字段能自动填写当前的sysdate。

* `@DynamicUpdate`属性: 设置为true,设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中,默认false。
比如只想更新某个属性，但是却把整个对象的属性都更新了，这并不是我们希望的结果，我们希望的结果是：我更改了哪些字段，只要更新我修改的字段就够了。

#### hibernate5库表映射策略变更

如果想升级`Hibernate到5.1`的话，那么之前的

`hibernate.ejb.naming_strategy`将不再被支持，而是被替换成了两个属性：
`hibernate.physical_naming_strategy`，`hibernate.implicit_naming_strategy`

这两个属性都是干嘛的呢？以下是Hibernate官方说明。

 * `implicit_naming_strategy` ：used whenever a table or column is not explicitly named to determine the name to use

   implicit naming strategy：**隐式命名策略，使用此属性当我们使用的表或列没有明确指定一个使用的名称 。**

 * `physical_naming_strategy`：used to convert a "logical name" (either implicit or explicit) name of a table or column into a physical name (e.g. following corporate naming guidelines)

  physical naming strategy：**物理命名策略，用于转换“逻辑名称”(隐式或显式)的表或列成一个物理名称。**
  
 * physical_naming_strategy有两个常用的配置：
 
 ```
 org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
 org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
 ```
 对于`PhysicalNamingStrategyStandardImpl`有`DefaultNamingStrategy`的效果；对于SpringPhysicalNamingStrategy  有ImprovedNamingStrategy的效果。
 
 
### FAQ
springboot2.0+jpa+hibernate5 ，目前无法进行增删改操作，查询正常。检查事务配置是否正确，或者将hibernate降低为版本4，进行检查。




