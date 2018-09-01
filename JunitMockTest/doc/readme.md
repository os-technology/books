* 创建数据库
* 创建库表

	```sql
	CREATE TABLE `user` (
	  `id` int(11) NOT NULL AUTO_INCREMENT,
	  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
	  `userid` int(11) DEFAULT NULL,
	  `orgid` int(11) DEFAULT NULL,
	  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	  `dtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uni` (`userid`,`orgid`,`createtime`)
	) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
	#mock数据表
	CREATE TABLE `dataService`.`mocktable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL COMMENT '名称',
  `data` VARCHAR(45) NOT NULL COMMENT '数据',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`))
COMMENT = 'mock数据表';

	
	```	
* 调整模块的数据库名称
* 使用单元测试，测试数据是否能正常插入
* 