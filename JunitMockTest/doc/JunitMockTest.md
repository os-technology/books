#JunitMockTest

**说明：**本模块基于springboot+myBatis进行构建，仅能查询数据，增删改操作不可用。包含Junit测试，Mockito和PowerMockito测试三部分内容。

##配置
####mock测试创建步骤如下
* 调整模块的数据库名称
* 在对应的MySQL地址创建相应的数据库名称
* 启动应用(`JunitMockApplication.java`)，库表采用初始化自动创建的方式进行操作。如果没有初始化成功，请检查 `persistence-mybatis.xml`文件配置是否注释。
 
 ```xml
 <!--persistence-mybatis.xml 库表初始化配置-->
 <jdbc:initialize-database data-source="DS" ignore-failures="NONE">
		<jdbc:script location="classpath:init.sql" />
	</jdbc:initialize-database>
 ```
* 使用单元测试，测试数据是否能正常插入

**注意**：如果不需要每次重新创建库表，则删除drop table语句即可。

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
 
## mock与powerMockito版本对应关系

* mock测试官网demo地址：

 [https://github.com/powermock](https://github.com/powermock)

 [https://github.com/powermock/powermock-examples-maven](https://github.com/powermock/powermock-examples-maven)
 
 * 相信有些朋友也碰到和我一样的问题，mockito结合powermock做单元测试会碰到一些明明程序看起来没问题，却始终报错。
 * 有可能的问题就是版本使用不对，大家如果遇到这样的问题可以试试。（PS:当然也不绝对一定是版本的问题）
 
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

## powerMockito环境搭建

 ```java
 @RunWith(PowerMockRunner.class)//运行环境，表明用 PowerMockerRunner来运行测试用例，否则无法使用PowerMock 
 @PrepareForTest(MockServiceImpl.class)//所有需要测试的类，列在此处，以逗号分隔
 ```

## 注解以及相关方法说明部分

#### 注解说明部分

 * `@PrepareForTest`使用场景
  
  ```
  当使用PowerMockito.whenNew方法时，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是需要mock的new对象代码所在的类。

  当需要mock final方法的时候，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是final方法所在的类。 

  当需要mock静态方法的时候，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是静态方法所在的类。

  当需要mock私有方法的时候, 只是需要加注解@PrepareForTest，注解里写的类是私有方法所在的类

 当需要mock系统类的静态方法的时候，必须加注解@PrepareForTest和@RunWith。注解里写的类是需要调用系统方法所在的类
  ```
   
 * @Mock: 创建一个Mock.
 * @InjectMocks: 创建一个实例，其余用@Mock（或@Spy）注解创建的mock将被注入到用该实例中。
 * <font color=blue>注意：必须使用@RunWith(MockitoJUnitRunner.class) 或 Mockito.initMocks(this)进行mocks的初始化和注入。</font>
 
#### 方法说明部分
* **`PowerMockito.spy`**：监控一个真实的对象。使用方法，如果该对象中有私有方法，通过 spy方法之后，可以mock私有方法的返回值，否则无法正常mock结果返回。
* `PowerMockito.doReturn(preValue).when(service.method)`:当需要调用when部分的`service.method`内容(一般指方法)时，返回`preValue `.即实际过程中不会调用`service.method`。
* `PowerMockito.when(service.method, mockTable).thenReturn(afterValue)`:当调用`service.method`完成后，返回`afterValue`。即实际过程中会调用`service.method`内容。示例如下：

 ```java
 PowerMockito.when(mockService, "convertJson", mockTable).thenReturn("");
 //表示调用 mockService 实例中的 convertJson (private或者protected)方法之后，返回空字符串。
 ```
* `Mockito.doAnswer(new Answer(){@Override answer(InvocationOnMock invocation){...}}).when(dao).methodName(Mockito.any(ParamType.class))`:表示当调用 `dao`中的`methodName`方法，并且传参内容为符合条件的任意参数值时，会触发`answer(InvocationOnMock invocation)`方法，并可以通过 `invocation`获得相应的对象信息(值，或者对象，或者实例等等)
* `doReturn`与`thenReturn`方法使用区别(when中的内容不同)：

 ```java
 	//when(实例 . 方法). thenReturn(设置结果)
 	PowerMockito.when(wechatPaymentHandler.createSign(params)).thenReturn(expectedValue);
 	//doReturn(设置结果).when(实例).方法
 	PowerMockito.doReturn(expectedValue).when(wechatPaymentHandler).createSign(params);
 ```
 
#### 有参构造函数待测类

* 如果待测类为有参构造函数，则需对类初始化时添加对应的参数信息，该项目暂时无此测试方式，具体参见我的另一个项目地址：
[https://github.com/apo-soft/payment-parent/blob/dev/wechat-public/wechat-public.md](https://github.com/apo-soft/payment-parent/blob/dev/wechat-public/wechat-public.md)
 
##Mybatis部分

**库表说明配置**

* mocktable : 配置mapper.xml映射文件进行操作
* user : 没有配置mapper.xml，通过注解进行数据操作
*  company : 配置mapper.xml映射文件进行操作
* 映射文件通用配置方式

```xml
<!--使用company和mocktable库表映射文件进行验证-->
 <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="DS" />
		<!--配置mybatis内容，比如sql输出等-->
		<property name="configLocation" value="classpath:mybatis-config.xml" />
	   <!--mybatis映射文件通用配置方式-->
		<property name="mapperLocations" value="classpath*:mapper/*Mapper.xml" />
   </bean>
```
 
 **添加自定义参数检查**
 
 ```xml
  <if test="@com.code.junit.mock.boot.util.MybatisParamsUtil@isNotEmpty(name)">
            where name=#{name}
     </if>
     MybatisParamsUtil：定义的参数校验类
        isNotEmpty(name)：要调用的函数名
        同时，dao层函数传参必须添加注解@Param，以保证参数会被mybatis通过getter拿到结果值
        public List<MockTable> selectByName(@Param("name") String name);
 ```
 
 
 **mybatis 分页插件配置**
 
 pom依赖配置
 
 ```xml
 <!--mybatis 分页插件 start-->
            <dependency>
                <groupId>com.github.pagehelper</groupId>
                <artifactId>pagehelper</artifactId>
                <version>5.1.4</version>
            </dependency>
            <dependency>
                <groupId>tk.mybatis</groupId>
                <artifactId>mapper-spring-boot-starter</artifactId>
                <version>2.0.3-beta1</version>
            </dependency>
            <!--mybatis 分页插件 end-->
 ```

 mybatis.xml配置
 
 ```xml
  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="DS"/>
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
        <!--mybatis映射文件通用配置方式-->
        <property name="mapperLocations" value="classpath*:mapper/*Mapper.xml"/>

        <property name="typeAliasesPackage" value="tk.mybatis.springboot.model"/>
        <property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageInterceptor">
                    <!-- 这里的几个配置主要演示如何使用，如果不理解，一定要去掉下面的配置 -->
                    <property name="properties">
                        <!--原来的 dialect 变成了 helperDialect，这是基于 PageHelper 方式的分页-->
                        <value>
                            helperDialect=mysql
                            reasonable=true
                            supportMethodsArguments=true
                            params=count=countSql
                            autoRuntimeDialect=true
                        </value>
                    </property>
                </bean>
            </array>
        </property>
    </bean>
 ```

 
 **代码部分**
 1. 分页设置代码必须写在SQL执行之前。
 2. SQL语句格式为select columeName from table where 1=1 and columName='value' order by id desc 即可，不需要添加limit 0,1 配置。
 3. 查询结果需要放入PageInfo类中。里面包含全部分页相关数值信息。

## springboot部分
* 单元测试注解部分最新配置

 ```java
 @Transactional(transactionManager="transactionManager")
@Rollback(value = true)//事务回滚使用独立注解进行操作
@SpringBootTest
 ```
 
* 多配置文件加载方式
 
 ```xml
  <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<!--自定义Tomcat配置-->
				<value>classpath:tomcat.properties</value>
				<!--1 引入属性文件，在配置中占位使用 -->
				<value>classpath*:app_dev.properties</value>
				<!--<value>file:/opt/demo/config/demo-remote.properties</value>-->
			</list>
		</property>
	</bean>
 ```
 
* 配置Tomcat自定义端口设置

 参考`TomcatConfig.java`类
 
* 事务采用标准的注解方式实现，即需要事务的方法上必须添加`@Transactional`注解才能生效

* 注解事务使用说明`@Transactional`，总结整理如下

 ```java
 
 @Transactional(readOnly = true)
public class DefaultFooService implements FooService {
 
  public Foo getFoo(String fooName) {
    // do something
  }
 
  // these settings have precedence for this method
  // 方法上注解属性会覆盖类注解上的相同属性
  @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
  public void updateFoo(Foo foo) {
    // do something
  }
}
 ```
  * 嵌套事务测试 - 内部try-catch, 无手动回滚 外部正常。**结果**：所有数据正常插入，没有回滚
  * 嵌套事务测试 - 内部try-catch, 手动回滚 外部正常。**结果**：所有数据全部回滚，没有插入
  * 嵌套事务测试 - 内部exception, 事务注解没有rollbackFor,外部正常。**结果**：所有数据正常回滚，没有插入
  * 嵌套事务测试 - 内部exception, 事务注解包含rollbackFor,外部正常。**结果**：所有数据正常回滚，没有插入
  * 嵌套事务测试 - 外部try-catch, 手动回滚 内部正常。**结果**：所有数据全部回滚，没有插入
  * 嵌套事务测试 - 外部Exception， 内部正常。**结果**：所有数据全部回滚
  * 在`@Transactional`注解中如果不配置`rollbackFor`属性,那么事物只会在遇到`RuntimeException(NullPointerException、IndexOutOfBoundsException等)`的时候才会回滚,加上`rollbackFor=Exception.class`,可以让事物在遇到`非运行时异常(SQLException,IOException以及用户自定义异常等)`时也回滚
  
 * **返回值fastjson类型中文乱码问题解决**
  
  ```xml
  <!-- 文件位置：application-bean.xml -->
    <mvc:annotation-driven>
        <!-- 消息转换器 -->
        <mvc:message-converters register-defaults="true">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter" /> <!--先进行string转换，保证最终的json格式里面没有转义字符和成对的双引号-->
            <bean id="fastJsonHttpMessageConverter" class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
                <property name="supportedMediaTypes">
                    <list>
                        <value>text/html;charset=UTF-8</value>
                        <value>application/json;charset=UTF-8</value>
                    </list>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
  ```

## 其他

#### lombok配置

* bean部分添加`lombok`依赖方式，并采用build设计模式进行参数赋值。

 ```
 注意：使用构造者模式必须添加构造函数声明的注解，必须包含无参构造函数和全参构造函数两个。
 @AllArgsConstructor  全参构造函数
@NoArgsConstructor  无参构造函数
 ```

#### smart-validate 参数校验
地址：[https://gitee.com/os-technology/smart-validate](https://gitee.com/os-technology/smart-validate)

添加了拦截器方式的配置，并测试通过