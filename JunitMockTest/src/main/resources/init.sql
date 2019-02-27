-- CREATE SCHEMA `mockdata` DEFAULT CHARACTER SET utf8 ;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `company`;
DROP TABLE IF EXISTS `mocktable`;

-- 延迟一秒钟之后执行库表语句创建操作
select sleep(1);

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `company_id` int(11) DEFAULT NULL COMMENT '公司id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni` (`company_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- # mock数据表

CREATE TABLE `mocktable` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL COMMENT '名称',
`data` VARCHAR(45) NOT NULL COMMENT '数据',
`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`))
COMMENT = 'mock数据表';

CREATE TABLE `company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NOT NULL COMMENT '公司名称',
  `address` VARCHAR(200) NOT NULL COMMENT '公司地址',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`))
  comment='公司表';

INSERT INTO `user` (`username`, `company_id`) VALUES ('张三', '1');
INSERT INTO `user` (`username`, `company_id`) VALUES ('李四', '1');
INSERT INTO `company` (`company_name`, `address`) VALUES ('Junit测试公司', '中国');
INSERT INTO `mocktable` (`id`, `name`, `data`) VALUES ('1', '123', 'aa');