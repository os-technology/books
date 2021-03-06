书籍链接：http://tutorials.jenkov.com/java-concurrency/index.html

本教程链接：http://ifeve.com/java-7-concurrency-cookbook/

https://github.com/Snailclimb/JavaGuide/blob/master/Java%E7%9B%B8%E5%85%B3/%E5%A4%9A%E7%BA%BF%E7%A8%8B%E7%B3%BB%E5%88%97.md

学习位置：https://blog.csdn.net/qq_34337272/article/details/79655194

### 使用多线程常见的三种方式

1. 继承Thread类
2. 实现Runnable接口
3. 使用线程池

 共享数据，如果想要依次递减，单纯的线程共享方式是行不通的(参见`com.thread.tutorial.start.github.one.MyThread.java`)
 
 **那么有没有什么解决办法呢？**

 答案是：当然有，而且很简单。给大家提供两种解决办法：一种是利用 `synchronized` 关键字（保证任意时刻只能有一个线程执行该方法），一种是利用 `AtomicInteger` 类（JUC 中的 Atomic 原子类）。大家如果之前没有接触 Java 多线程的话，可能对这两个概念不太熟悉，不过不要担心我后面会一一向你介绍到！这里不能用 `volatile` 关键字，因为 volatile 关键字不能保证复合操作的原子性。
 
### 线程的优先级

 * 每个线程都具有各自的优先级，<font color=red>线程的优先级可以在程序中表明该线程的重要性，如果有很多线程处于就绪状态，系统会根据优先级来决定首先使哪个线程进入运行状态。</font>但这个并不意味着低优先级的线程得不到运行，而只是它运行的几率比较小，如垃圾回收机制线程的优先级就比较低。所以很多垃圾得不到及时的回收处理。
* 线程优先级具有继承特性比如A线程启动B线程，则B线程的优先级和A是一样的。
* 线程优先级具有随机性也就是说线程优先级高的不一定每一次都先执行完。

### Java多线程分类

* **用户线程**：运行在前台，执行具体的任务，如程序的主线程、连接网络的子线程等都是用户线程
* **守护线程**：运行在后台，为其他前台线程服务.也可以说守护线程是JVM中非守护线程的 “佣人”。
* **特点**：一旦所有用户线程都结束运行，守护线程会随JVM一起结束工作
* **应用**：数据库连接池中的检测线程，JVM虚拟机启动后的检测线程
* **最常见的守护线程**：垃圾回收线程

### 守护线程
可以通过调用Thead类的setDaemon(true)方法设置当前的线程为守护线程

注意事项：

1.  setDaemon(true)必须在start（）方法前执行，否则会抛出IllegalThreadStateException异常
2. 在守护线程中产生的新线程也是守护线程
3. 不是所有的任务都可以分配给守护线程来执行，比如读写操作或者计算逻辑

