-- CREATE SCHEMA `mockdata` DEFAULT CHARACTER SET utf8 ;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `company`;
DROP TABLE IF EXISTS `mocktable`;
DROP TABLE IF EXISTS `category`;

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


-- 三级类目mybatis查询方式
CREATE TABLE `category` (
  `id` varchar(12)   NOT NULL COMMENT '品类编号',
  `p_id` varchar(12)   NOT NULL DEFAULT '0' COMMENT '父编号',
  `level` int(1) DEFAULT '1' COMMENT '品类级别 1一级2二级3三级',
  `category_name` varchar(50)   NOT NULL DEFAULT '' COMMENT '品类名称',
  `category_code` varchar(20)   DEFAULT NULL COMMENT '类目类型',
  `img_url` varchar(100)   DEFAULT NULL COMMENT '品类图片',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:标品品类 2:到家服务品类',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态 1:可用 0:不可用',
  `sort` int(6) NOT NULL DEFAULT '0' COMMENT '排序值',
  `is_last` tinyint(2) DEFAULT '1' COMMENT '是否末级品类 1是0否',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_by` varchar(20)   NOT NULL DEFAULT '' COMMENT '创建者',
  `update_by` varchar(20)   NOT NULL DEFAULT '' COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB   COMMENT='品类字典表';

INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `img_url`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('0001', '0', '1', '家政保姆', 'DN', 'https://img1.qdingnet.com/image-833adee7-ef9a-4cf1-b385-18931bfe93ee.png', '2', '1', '1', '0', '2018-11-15 18:11:39', '2018-11-16 17:38:58', 'wgq', 'leigengchen');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('00010001', '0001', '2', '保洁服务', 'DN', '2', '1', '0', '0', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('000100010001', '00010001', '3', '日常保洁', 'DN', '2', '1', '0', '1', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('000100010002', '00010001', '3', '深度保洁', 'DN', '2', '1', '0', '1', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('000100010003', '00010001', '3', '开荒保洁', 'DN', '2', '1', '0', '1', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('00010002', '0001', '2', '保姆月嫂', 'DN', '2', '1', '0', '0', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('000100020001', '00010002', '3', '保姆', 'DN', '2', '1', '0', '1', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('000100020002', '00010002', '3', '月嫂', 'DN', '2', '1', '0', '1', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('000100020003', '00010002', '3', '育儿嫂', 'DN', '2', '1', '0', '1', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `img_url`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('0002', '0', '1', '洗护养护', 'WP', 'https://img1.qdingnet.com/image-5a96b77b-90fa-443c-b398-c1d1a569ca4f.png', '2', '1', '1', '0', '2018-11-15 18:11:39', '2018-11-16 17:37:09', 'wgq', 'leigengchen');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('00020001', '0', '2', '家电清洗', 'WP', '2', '1', '1', '0', '2018-11-15 18:11:39', '2018-12-04 16:40:18', 'wgq', 'leigengchen');
INSERT INTO `dataService`.`category` (`id`, `p_id`, `level`, `category_name`, `category_code`, `type`, `status`, `sort`, `is_last`, `create_at`, `update_at`, `create_by`, `update_by`) VALUES ('000200010001', '00020001', '3', '空调清洗', 'WP', '2', '1', '0', '1', '2018-11-15 18:11:39', '2018-11-15 18:11:39', 'wgq', 'wgq');



