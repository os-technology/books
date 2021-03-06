# bootgroup

模块说明：由springboot,jpa,shiro(该部分尚未完成)基础组件构成，用于进行demo学习演示。

### jpa部分
官方demo地址：[https://github.com/spring-projects/spring-data-jpa](https://github.com/spring-projects/spring-data-jpa)
中文文档：[https://github.com/ityouknow/spring-data-jpa-reference-documentation](https://github.com/ityouknow/spring-data-jpa-reference-documentation)
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
 
 
 `<context:component-scan/>` 扫描指定的包中的类上的注解，常用的注解有

 ```java
@Controller 声明Action组件
@Service    声明Service组件    @Service("myMovieLister") 
@Repository 声明Dao组件
@Component   泛指组件, 当不好归类时. 
@RequestMapping("/menu")  请求映射
@Resource  用于注入，( j2ee提供的 ) 默认按名称装配，@Resource(name="beanName") 
@Autowired 用于注入，(srping提供的) 默认按类型装配 
@Transactional( rollbackFor={Exception.class}) 事务管理
@ResponseBody
@Scope("prototype")   设定bean的作用域

 ```
 
#### jpa注解

* `@DynamicInsert`属性: 设置为true,设置为true,表示insert对象的时候,生成动态的insert语句,如果这个字段的值是null就不会加入到insert语句当中.默认false。
比如希望数据库插入日期或时间戳字段时，在对象字段为空的情况下，表字段能自动填写当前的sysdate。

* `@DynamicUpdate`属性: 设置为true,设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中,默认false。
比如只想更新某个属性，但是却把整个对象的属性都更新了，这并不是我们希望的结果，我们希望的结果是：我更改了哪些字段，只要更新我修改的字段就够了。

* `@GeneratedValue`注解的strategy属性提供四种值：

  –**AUTO**： 主键由程序控制，是默认选项，不设置即此项。

  –**IDENTITY**：主键由数据库自动生成，即采用数据库ID自增长的方式，Oracle不支持这种方式。

  –**SEQUENCE**：通过数据库的序列产生主键，通过@SequenceGenerator 注解指定序列名，mysql不支持这种方式。

  –**TABLE**：通过特定的数据库表产生主键，使用该策略可以使应用更易于数据库移植。
  
  配置demo
  
  ```java
  //JPA的注解来定义实体的时候，使用@Id来注解主键属性即可。如果数据库主键是自增长的，需要在增加一个注解@GeneratedValue，即
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private String id;
  ```

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
 
### spring事务部分

|PROPAGATION类型|说明|
|---|---|
| REQUIRED| 加入当前已有事务；只有当前没有事务才起一个新的事务.<br>    比如说，`ServiceB.methodB`的事务级别定义为`PROPAGATION_REQUIRED`, 那么由于`ServiceA.methodA`的时候，`ServiceA.methodA`已经起了事务，这时调用`ServiceB.methodB`，`ServiceB.methodB`看到自己已经运行在`ServiceA.methodA`的事务内部，就不再起新的事务。而假如`ServiceA.methodA`运行的时候发现自己没有在事务中，它就会为自己分配一个事务。这样，在`ServiceA.methodA`或者在ServiceB.methodB内的任何地方出现异常，事务都会被回滚。|
|SUPPORTS | 如果当前在事务中，即以事务的形式运行，如果当前不在一个事务中，那么就以非事务的形式运行 |
|MANDATORY | 必须在一个事务中运行。也就是说，只能被一个父事务调用。否则，就要抛出异常。|
|REQUIRES_NEW | 比如我们设计`ServiceA.methodA`的事务级别为`PROPAGATION_REQUIRED`，`ServiceB.methodB`的事务级别为`PROPAGATION_REQUIRES_NEW`，那么当执行到ServiceB.methodB的时候，`ServiceA.methodA`所在的事务就会挂起，`ServiceB.methodB`会起一个新的事务，等待`ServiceB.methodB`的事务完成以后，它才继续执行。它与`PROPAGATION_REQUIRED` 的事务区别在于事务的回滚程度了。因为`ServiceB.methodB`是新起一个事务，那么就是存在两个不同的事务。如果`ServiceB.methodB`已经提交，那么`ServiceA.methodA`失败回滚，ServiceB.methodB是不会回滚的。如果`ServiceB.methodB`失败回滚，它抛出的异常被ServiceA.methodA捕获，ServiceA.methodA事务仍然可以提交。|
| NOT_SUPPORTED|当前不支持事务。比如`ServiceA.methodA`的事务级别是`PROPAGATION_REQUIRED` ，而`ServiceB.methodB`的事务级别是`PROPAGATION_NOT_SUPPORTED`， 那么当执行到`ServiceB.methodB`时，`ServiceA.methodA`的事务挂起，而它以非事务的状态运行完，再继续`ServiceA.methodA`的事务。 |
| NEVER|不能在事务中运行。假设`ServiceA.methodA`的事务级别是`PROPAGATION_REQUIRED`， 而ServiceB.methodB的事务级别是`PROPAGATION_NEVER`，那么ServiceB.methodB就要抛出异常了。 |
|NESTED | 理解Nested的关键是`savepoint`。它与`PROPAGATION_REQUIRES_NEW`的区别是，`PROPAGATION_REQUIRES_NEW`另起一个事务，将会与它的父事务相互独立，而Nested的事务和它的父事务是相依的，它的提交是要等和它的父事务一块提交的。也就是说，如果父事务最后回滚，它也要回滚的。而Nested事务的好处是它有一个savepoint。也就是说`ServiceB.methodB`失败回滚，那么`ServiceA.methodA`也会回滚到savepoint点上，`ServiceA.methodA`可以选择另外一个分支，比如`ServiceC.methodC`，继续执行，来尝试完成自己的事务。但是这个事务并没有在EJB标准中定义。|


目前无法通过自定义的aop方式进行代理对象的单元测试，只能通过启动服务进行试验。通过切面来检查动态代理是否正常。

`http://localhost:8080/aspect`: 被代理对象(实际对象)方式调用
`http://localhost:8080/handler`:代理对象(创建一个代理对象)方式调用(代理的方式就会经过切面，否则是不会经过切面的)

事务失效的解决方案：

 ```xml
 <aop:aspectj-autoproxy expose-proxy="true" />
 ```
 
 ```java
 ((Service)AopContext.currentProxy()).invokeMethod();
 ```
 
 链接参考：https://blog.csdn.net/cdsn13082487212/article/details/79515423
 

### 添加页面配置

* 问题1   

 按照网上说法添加对应依赖之后，启动项目，依旧提示404
依赖如下：

 ```xml
<!-- servlet 依赖. -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.1</version>
        </dependency>
        <!-- 解决访问页面404 -->
        <!--由于Spring boot使用的内嵌的tomcat，而内嵌的tamcat是不支持jsp页面的，所有需要导入额外的包才能解决。-->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <scope>provided</scope>
        </dependency>
 ```

启动项目报错如下：

```java

java.io.FileNotFoundException: /Users/yujinshui/.m2/repository/com/mchange/c3p0/0.9.5.2/mchange-commons-java-0.2.11.jar (No such file or directory)
```

解决方案：需要配置启动参数信息(忽略对该jar的检查)

`-Dserver.tomcat.additional-tld-skip-patterns=*mchange-commons-java*.jar`

此时依旧报错

进行`working directory`的配置

点击  `Edit  configurations`，找到对应的应用项目，配置`working directory`信息为`$MODEULE_DIR$`.

配置web路径：

点开 `Project structure`,`Project settings`-->`Modules`,`Deployment Descriptor` 配置`web.xml`路径，`Web Resource Directory`配置webapp路径即可。
 
### FAQ
==**springboot2.0+jpa+hibernate5 ，目前无法进行增删改操作，查询正常。检查事务配置是否正确，或者将hibernate降低为版本4，进行检查。已经找到问题所在。原因如下：**==

在`spring-mvc.xml`配置文件中，包扫描配置如下：

  ```xml
 <context:component-scan base-package="com.boot.group.dict"
		use-default-filters="false">
		<context:include-filter type="annotation"
			expression="org.springframework.stereotype.Controller" />
	</context:component-scan>
  ```

则在`application-bean.xml`配置文件中，进行包扫描配置时，一定需要排除controller部分的扫描，否则无法正常插入数据。即配置应该如下：

```xml
<context:component-scan base-package="com.boot.group">
		<!--Spring的applicationContext.xml文件中配置扫描包时，不要包含controller的注解-->
		<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```

或者在配置里面将`<context:include-filter`和`<context:exclude-filter`部分都删除。

[Spring AOP 对Spring MVC的Controller切面拦截不起作用](https://www.jianshu.com/p/60665a64e2dd)

Spring MVC启动时的配置文件，包含组件扫描、url映射以及设置freemarker参数，让spring不扫描带有@Service注解的类。为什么要这样设置？因为springmvc.xml与applicationContext.xml不是同时加载，如果不进行这样的设置，那么，spring就会将所有带@Service注解的类都扫描到容器中，等到加载applicationContext.xml的时候，会因为容器已经存在Service类，使得cglib将不对Service进行代理，直接导致的结果就是在applicationContext 中的事务配置不起作用，发生异常时，无法对数据进行回滚。以上就是原因所在。


==**hibernate-core 4版本，出现以下错误时**==

 ```java
 Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in URL [file:/Users/yujinshui/jobs/local_space/books/bootgroup/target/classes/spring-jpa.xml]: Invocation of init method failed; nested exception is java.lang.NoClassDefFoundError: org/hibernate/boot/MetadataBuilder
 ...
 Caused by: java.lang.NoClassDefFoundError: org/hibernate/boot/MetadataBuilder
 ```
原因如下：

	org.hibernate.boot.MetadataBuilder版本5中提供，在版本中4.x.x.Final，它在另一个包中定义：org/hibernate/metamodel/MetadataBuilder.class

问题解决详细过程整理：

1.  `spring-boot-starter-parent` 采用 `1.4.x` 版本，其中的 `hibernate-entitymanager`版本为`hibernate5`版本，由于我们使用hibernate4，所以，将它默认的hibernate依赖版本进行排除(参见`hibernate-core`在pom中的排除方式)
2. 故障点定位。通过xml配置的方式故障点不太容易确认，我们通过使用代码配置的方式进行定位操作。

  1. AppConfig.java类里面
  
     ```java

     @Bean
     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(false);
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan("com.boot.group.dict.entity");
        factory.setJpaDialect(new HibernateJpaDialect());
        Properties props = new Properties();
        props.put("hibernate.ejb.naming_strategy", "com.boot.group.TableNamingStrategy");
        factory.setJpaProperties(props);
        //问题发生位置。即进行entityManagerFactory构建时发生问题。
        factory.afterPropertiesSet();
        return factory;
    }
     ```
  2. 通过对源码的调用定位，找到如下代码(`LocalContainerEntityManagerFactoryBean.java`，这里是`spring-orm:4.3.7.jar`)，问题发生位置见注释。

     ```java
     @Override
	protected EntityManagerFactory createNativeEntityManagerFactory() throws PersistenceException {
		PersistenceUnitManager managerToUse = this.persistenceUnitManager;
		if (this.persistenceUnitManager == null) {
			this.internalPersistenceUnitManager.afterPropertiesSet();
			managerToUse = this.internalPersistenceUnitManager;
		}

		this.persistenceUnitInfo = determinePersistenceUnitInfo(managerToUse);
		JpaVendorAdapter jpaVendorAdapter = getJpaVendorAdapter();
		if (jpaVendorAdapter != null && this.persistenceUnitInfo instanceof SmartPersistenceUnitInfo) {
			((SmartPersistenceUnitInfo) this.persistenceUnitInfo).setPersistenceProviderPackageName(
					jpaVendorAdapter.getPersistenceProviderRootPackage());
		}

		PersistenceProvider provider = getPersistenceProvider();
		if (provider == null) {
			String providerClassName = this.persistenceUnitInfo.getPersistenceProviderClassName();
			if (providerClassName == null) {
				throw new IllegalArgumentException(
						"No PersistenceProvider specified in EntityManagerFactory configuration, " +
						"and chosen PersistenceUnitInfo does not specify a provider class name either");
			}
			Class<?> providerClass = ClassUtils.resolveClassName(providerClassName, getBeanClassLoader());
			provider = (PersistenceProvider) BeanUtils.instantiateClass(providerClass);
		}

		if (logger.isInfoEnabled()) {
			logger.info("Building JPA container EntityManagerFactory for persistence unit '" +
					this.persistenceUnitInfo.getPersistenceUnitName() + "'");
		}
		EntityManagerFactory emf =
		//-------问题发生位置--------
				provider.createContainerEntityManagerFactory(this.persistenceUnitInfo, getJpaPropertyMap());
		postProcessEntityManagerFactory(emf, this.persistenceUnitInfo);

		return emf;
	}
     ```
  3. 因为是jpa配置，所以，我们通过跟踪发现， `provider`实体类为`SpringHibernateJpaPersistenceProvider.java`(`spring-orm:4.3.7.jar`)类，里面代码如下：
  
     ```java
     public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo info, Map properties) {
		final List<String> mergedClassesAndPackages = new ArrayList<String>(info.getManagedClassNames());
		if (info instanceof SmartPersistenceUnitInfo) {
			mergedClassesAndPackages.addAll(((SmartPersistenceUnitInfo) info).getManagedPackages());
		}
		//问题发生位置点，此处调用了hibernate-entitymanager包中的类进行实现。
		return new EntityManagerFactoryBuilderImpl(
				new PersistenceUnitInfoDescriptor(info) {
					@Override
					public List<String> getManagedClassNames() {
						return mergedClassesAndPackages;
					}
				}, properties).build();
	}
     ```
  4. `EntityManagerFactoryBuilderImpl`是`hibernate-entitymanager`包中的类，点击进去我们可以看到，此处是调用了`hibernate-entitymanager:5.0.12.final`包里的该类，同时也定位到`MetadataBuilder`的导包路径为`import org.hibernate.boot.MetadataBuilder;`
  5. 解决方案，手动排除`hibernate-entitymanager`，然后在pom中导入`hibernate-entitymanager`的hibernate4版本即可。
  6. 默认采用xml配置方式配置，如果要使用AppConfig类配置，只需将`BootGroupApplication.java`中的`@ContextConfiguration(classes = AppConfig.class)`注释解开，同时，将`application-bean.xml`配置中的`<import resource="classpath*:spring-jpa.xml"/>`注释掉即可。
  
