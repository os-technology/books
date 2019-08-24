1. 基本的boot环境，允许访问数据库
2. 手写mybatis知识(`com.notes.boot.dict.mybatis`)
3. 静态代理(`com.notes.boot.dict.staticproxy`)
	* 违反了开闭原则(扩展能力差，可维护性差。如果张三的老婆需要女性情趣用品，则lison需要实现女性接口，李四有需求，则需要实现李四的接口，而且不同类型的产品都需要单独实现方法，耦合度会很高)
4. 动态代理(`com.notes.boot.dict.dynamic`)
5. 单元测试环境添加jdk-xml转换为对象操作，测试通过

### threadlocal包

20190805_大师演绎并发精髓，不可不知的ThreadLocal底层原理.mp4

ThreadLocal在jdk中的实现？

1. ThreadLocalMap 在ThreadLocal类中定义，但是是在Thread类中进行实例化使用
2. 当线程通过ThreadLocal变量进行赋值时，ThreadLocal会检查当前线程的 ThreadLocalMap 是否为空，不为空，则进行赋值操作，否则，创建 ThreadLocalMap，然后进行赋值操作。
这样，每个线程在使用ThreadLocal进行赋值时，都会有自己独立的ThreadLocal变量

ThreadLocal 存在内存泄露的问题

什么是引用？

* 强引用  new Object()
* 软引用(SoftReference)
* 弱引用(WeakReference)
* 虚引用