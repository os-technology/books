#JunitMockTest

**说明：**本模块基于springboot+myBatis进行构建，仅能查询数据，增删改操作不可用。
####mock测试创建步骤如下
* 创建数据库
* 创建库表

	```sql
		
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
* 