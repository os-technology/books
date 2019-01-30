--
-- -- CREATE SCHEMA `bootgroup` DEFAULT CHARACTER SET utf8 ;
--
-- DROP TABLE IF EXISTS `student_info`;
-- DROP TABLE IF EXISTS `address`;
-- -- 延迟一秒钟之后执行库表语句创建操作
-- select sleep(1);
--
--
-- CREATE TABLE `student_info` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `student_name` varchar(45) NOT NULL COMMENT '学生名字',
--   `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
--   `grade` varchar(45) DEFAULT NULL COMMENT '年级',
--   `address_id` int(11) NOT NULL COMMENT '家庭住址id',
--   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--
--
-- CREATE TABLE `address` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `address_name` varchar(100) DEFAULT NULL COMMENT '住址名称',
--   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- CREATE TABLE `bless_record` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `username` varchar(45) DEFAULT NULL COMMENT '用户名',
--   `content` varchar(300) DEFAULT NULL COMMENT '祝福内容',
--   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='祝福记录表';


-- -- 插入初始数据操作
-- INSERT INTO `address` (`address_name`) VALUES ('北京市昌平区小辛庄');
-- select sleep(1);
-- INSERT INTO `address` (`address_name`) VALUES ('北京市海淀区丹棱SOHO');
--
-- INSERT INTO `student_info` (`student_name`, `age`, `grade`, `address_id`) VALUES ('小红', '12', '5', '1');
-- select sleep(1);
-- INSERT INTO `student_info` (`student_name`, `age`, `grade`, `address_id`) VALUES ('张明', '14', '7', '2');
-- select sleep(1);
-- INSERT INTO `student_info` (`student_name`, `age`, `grade`, `address_id`) VALUES ('张玲丽', '13', '6', '2');
--
