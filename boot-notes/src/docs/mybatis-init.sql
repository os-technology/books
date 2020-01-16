CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `company_id` int(11) DEFAULT NULL COMMENT '公司id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni` (`company_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES
(1,'张三',1,'2018-09-18 20:56:31','2018-09-18 20:56:31'),
(2,'李四',1,'2018-09-19 15:50:02','2018-09-19 15:50:02'),
(3,'测试111',3,'2019-02-27 18:50:23','2019-02-27 18:50:23'),
(4,'测试-1157793070',21,'2019-02-27 18:54:40','2019-02-27 18:54:39');

