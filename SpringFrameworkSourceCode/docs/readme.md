**源码地址**：[https://github.com/spring-projects/spring-framework](https://github.com/spring-projects/spring-framework)  
**准备工作**：gradle环境，IDE，本笔记使用idea工具进行操作。
下载完成后，项目根目录下有个import-into-eclipse.md文件，打开，按照说明进行编译。

* 3.1 constructor-arg

 类的构造函数会全部进行实例化。参见`ConstructorArgJunitTest`测试类
 
 ApplicationContext的初始化和BeanFactory有一个重大的区别：BeanFactory在初始化容器时，并未实例化Bean，直到第一次访问某个Bean时才实例目标Bean；而ApplicationContext则在初始化应用上下文时就实例化所有单实例的Bean。因此ApplicationContext的初始化时间会比BeanFactory稍长一些，不过稍后的调用则没有"第一次惩罚"的问题。
 
 **ClassPathResource** : spring配置文件读取类
 
 spring profile 多环境配置管理
 [https://www.cnblogs.com/pangguoming/p/5888871.html](https://www.cnblogs.com/pangguoming/p/5888871.html)
 
 在`SimpleAliasRegistry `类中，`allowAliasOverriding()`方法，默认返回true。实际在`DefaultListableBeanFactory`中有覆写操作。详细代码如下：
 
 ```java
	 public class SimpleAliasRegistry implements AliasRegistry {
	
		/** Map from alias to canonical name */
		private final Map<String, String> aliasMap = new ConcurrentHashMap<String, String>(16);
	
	
		public void registerAlias(String name, String alias) {
			Assert.hasText(name, "'name' must not be empty");
			Assert.hasText(alias, "'alias' must not be empty");
			if (alias.equals(name)) {
				this.aliasMap.remove(alias);
			}
			else {
				if (!allowAliasOverriding()) {
					String registeredName = this.aliasMap.get(alias);
					if (registeredName != null && !registeredName.equals(name)) {
						throw new IllegalStateException("Cannot register alias '" + alias + "' for name '" +
								name + "': It is already registered for name '" + registeredName + "'.");
					}
				}
				checkForAliasCircle(name, alias);
				this.aliasMap.put(alias, name);
			}
		}
	
		/**
		 * Return whether alias overriding is allowed.
		 * Default is {@code true}.
		 */
		protected boolean allowAliasOverriding() {
			return true;
		}
	。。。
}
 ```
 
 ```java
 ublic class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
		implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, Serializable {
		...
		...
		...
		/** Whether to allow re-registration of a different definition with the same name */
	private boolean allowBeanDefinitionOverriding = true;
		...
		...
	/**
	 * Set whether it should be allowed to override bean definitions by registering
	 * a different definition with the same name, automatically replacing the former.
	 * If not, an exception will be thrown. This also applies to overriding aliases.
	 * <p>Default is "true".
	 * @see #registerBeanDefinition
	 */
	public void setAllowBeanDefinitionOverriding(boolean allowBeanDefinitionOverriding) {
		this.allowBeanDefinitionOverriding = allowBeanDefinitionOverriding;
	}
	...
	...
	@Override
	public void copyConfigurationFrom(ConfigurableBeanFactory otherFactory) {
		super.copyConfigurationFrom(otherFactory);
		if (otherFactory instanceof DefaultListableBeanFactory) {
			DefaultListableBeanFactory otherListableFactory = (DefaultListableBeanFactory) otherFactory;
			//此处也包含设置值的信息
			this.allowBeanDefinitionOverriding = otherListableFactory.allowBeanDefinitionOverriding;
			this.allowEagerClassLoading = otherListableFactory.allowEagerClassLoading;
			this.autowireCandidateResolver = otherListableFactory.autowireCandidateResolver;
			this.resolvableDependencies.putAll(otherListableFactory.resolvableDependencies);
		}
	}
	...
	...
	/**
	 * 此处进行了覆写操作
	 * Only allows alias overriding if bean definition overriding is allowed.
	 */
	@Override
	protected boolean allowAliasOverriding() {
		return this.allowBeanDefinitionOverriding;
	}
	。。。
 }
 ```
 两者关系图如下
 ![alt 关系类图](DefaultListableBeanFactory.png)