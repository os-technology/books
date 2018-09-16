-- CREATE SCHEMA `mockdata` DEFAULT CHARACTER SET utf8 ;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `mocktable`;
-- 延迟一秒钟之后执行库表语句创建操作
select sleep(1);
CREATE TABLE `user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(45) DEFAULT NULL COMMENT '用户名',
`userid` int(11) DEFAULT NULL,
`orgid` int(11) DEFAULT NULL,
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
UNIQUE KEY `uni` (`userid`,`orgid`,`create_time`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- # mock数据表

CREATE TABLE `mocktable` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL COMMENT '名称',
`data` VARCHAR(45) NOT NULL COMMENT '数据',
`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (`id`))
COMMENT = 'mock数据表';

INSERT INTO `mocktable` (`id`, `name`, `data`) VALUES ('1', '123', 'aa');