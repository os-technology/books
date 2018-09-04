#### 分支说明

 * dev:持续性更新分支
 * dev_1.7:该部分内容尽量以jdk1.7版本为基础进行操作。已经封版，不再维护。
 * master:发布分支，用于里程碑方式打包发布。
 * wechat_tmp:微信支付临时分支，作为一次性分支，记录微信demo信息。
 * cloud:springcloud专用分支，将springcloud模块更新为最新版本，目前eureka-comsumer模块启动失败，其他模块正常。
 
 
#### 各模块功能说明：

|module名称|说明|
|---|---|
|**HeadFirstDesign**| 《head first design》demo|
|**JavaTutorial**| 平时练习使用，以及一些常用工具类|
|**Spring4**| web模块，练习使用|
|**springmvc**| web模块，练习使用|
|**dubbo-parent**| dubbo-demo|
|**compress**|图片压缩demo|
|**createBeans**| 通过数据库或者Excel创建bean操作|
|**springcloud**| springcloud学习记录，包含web层的单元测试学习|
|**springboot**| springboot学习记录|
|**jmetertest**| jmeter学习记录，实际项目需要执行压测时，可以用作参考|
|**springbootApplication**| springboot书籍学习|
|**SpringFrameworkSourceCode**| spring源码学习记录|
|**JunitMockTest**| Junit和mock单元测试，基于springboot+mybatis|


运行单元测试条件：

* 启动zookeeper dubbo使用
* 启动consul springcloud模块
* redis disconf使用
* nginx disconf使用