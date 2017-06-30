/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50146
Source Host           : 127.0.0.1:3306
Source Database       : testcrm

Target Server Type    : MYSQL
Target Server Version : 50146
File Encoding         : 65001

Date: 2017-01-13 08:42:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_gather
-- ----------------------------
DROP TABLE IF EXISTS `b_gather`;
CREATE TABLE `b_gather` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_usr` int(11) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `remark` longtext,
  `c_id` int(11) NOT NULL,
  `c_name` varchar(200) NOT NULL,
  `c_type` varchar(10) DEFAULT NULL,
  `payer` varchar(100) DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `pay_type` varchar(100) DEFAULT NULL,
  `bill_code` varchar(100) DEFAULT NULL,
  `handler` varchar(100) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `statusid` varchar(100) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `auditor` varchar(50) DEFAULT NULL,
  `audit_date` datetime DEFAULT NULL,
  `audit_idea` longtext,
  `code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_gather
-- ----------------------------

-- ----------------------------
-- Table structure for b_order
-- ----------------------------
DROP TABLE IF EXISTS `b_order`;
CREATE TABLE `b_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_usr` int(11) NOT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `remark` longtext,
  `code` varchar(100) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `c_id` int(11) NOT NULL,
  `c_name` varchar(100) DEFAULT NULL,
  `c_type` varchar(20) DEFAULT NULL,
  `linkman` varchar(100) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `seller` varchar(100) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `agio` double DEFAULT NULL,
  `agio_total` double DEFAULT NULL,
  `auditor` varchar(100) DEFAULT NULL,
  `audit_date` date DEFAULT NULL,
  `status_id` varchar(255) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `audit_reason` longtext,
  `custom1` varchar(100) DEFAULT NULL,
  `custom2` varchar(100) DEFAULT NULL,
  `custom3` varchar(100) DEFAULT NULL,
  `custom4` varchar(100) DEFAULT NULL,
  `choice1` varchar(100) DEFAULT NULL,
  `choice2` varchar(100) DEFAULT NULL,
  `choice3` varchar(100) DEFAULT NULL,
  `choice4` varchar(100) DEFAULT NULL,
  `time1` datetime DEFAULT NULL,
  `time2` datetime DEFAULT NULL,
  `share_flag` char(1) DEFAULT NULL,
  `share_ids` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_order
-- ----------------------------
INSERT INTO `b_order` VALUES ('1', '4', '张三', '2017-01-11 08:42:07', null, null, 'aaa', 'aaa', '2016-10-27', '1', '移动', 'aa', null, null, null, null, '100', '10', '90', null, null, null, '草稿', null, null, null, null, null, null, null, null, null, null, null, '1', null);


-- ----------------------------
-- Table structure for b_product_type
-- ----------------------------
DROP TABLE IF EXISTS `b_product_type`;
CREATE TABLE `b_product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `fcode` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `remark` longtext,
  `sort` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_product_type
-- ----------------------------
INSERT INTO `b_product_type` VALUES ('1', '0', null, '001', '电器', '001', null, null);
INSERT INTO `b_product_type` VALUES ('2', '1', null, '002', '电冰箱', '002', null, null);
INSERT INTO `b_product_type` VALUES ('3', '1', null, '00333', '洗衣机', '003', null, null);
INSERT INTO `b_product_type` VALUES ('4', '3', null, '004', '滚筒洗衣机3', '004', null, null);
INSERT INTO `b_product_type` VALUES ('6', '3', null, '006', '波轮洗衣机', '006', null, null);
INSERT INTO `b_product_type` VALUES ('7', '0', null, '007', '服装', '007', null, null);
INSERT INTO `b_product_type` VALUES ('8', '7', null, '008', '男装', '008', null, null);
INSERT INTO `b_product_type` VALUES ('9', '7', null, '009', '女装', 'aaa', null, null);
INSERT INTO `b_product_type` VALUES ('10', '7', null, '0010', '童装', '111', null, null);
INSERT INTO `b_product_type` VALUES ('11', '1', null, '23456', '电视', 'aaa', null, null);
INSERT INTO `b_product_type` VALUES ('12', '11', null, 'qwertyu', '黑白电视', 'asads', null, null);
INSERT INTO `b_product_type` VALUES ('13', '11', null, '8888', '液晶电视', '234325', null, null);
INSERT INTO `b_product_type` VALUES ('16', '0', null, 'bbb', 'aaa', 'ccc', null, null);
INSERT INTO `b_product_type` VALUES ('17', '0', null, 'ddd', 'bbb', 'aaa', null, null);
INSERT INTO `b_product_type` VALUES ('18', '16', null, '333', '333', '333', null, null);
INSERT INTO `b_product_type` VALUES ('19', '16', null, '444', '444', '444', null, null);
INSERT INTO `b_product_type` VALUES ('20', '16', null, '555', '555', '555', null, null);
INSERT INTO `b_product_type` VALUES ('21', '16', null, '666', '666', '666', null, null);
INSERT INTO `b_product_type` VALUES ('22', '3', null, '004', '滚筒洗衣机2', '004', null, null);
INSERT INTO `b_product_type` VALUES ('23', '16', null, '666', '666', '777', null, null);

-- ----------------------------
-- Table structure for c3p0testtable
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c3p0testtable
-- ----------------------------

-- ----------------------------
-- Table structure for s_access_group
-- ----------------------------
DROP TABLE IF EXISTS `s_access_group`;
CREATE TABLE `s_access_group` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `dpte` longtext,
  `remark` longtext,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_access_group
-- ----------------------------
INSERT INTO `s_access_group` VALUES ('1', '全部查看权限', '2,3,', null);
INSERT INTO `s_access_group` VALUES ('2', '人力资源总监', '', null);
INSERT INTO `s_access_group` VALUES ('3', '可查看市场部', null, null);
INSERT INTO `s_access_group` VALUES ('4', '可查看开发部', null, null);
INSERT INTO `s_access_group` VALUES ('5', '查询权限1', null, null);
INSERT INTO `s_access_group` VALUES ('6', '查询权限2', null, null);
INSERT INTO `s_access_group` VALUES ('7', '查询权限3', null, null);
INSERT INTO `s_access_group` VALUES ('8', '查询权限4', null, null);

-- ----------------------------
-- Table structure for s_dictionary_class
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionary_class`;
CREATE TABLE `s_dictionary_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` longtext,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `chineseTableName` varchar(100) DEFAULT NULL,
  `englishTableName` varchar(100) DEFAULT NULL,
  `available` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_dictionary_class
-- ----------------------------
INSERT INTO `s_dictionary_class` VALUES ('1', 'aaa1', 'aaa2', 'aaa3', 'aaa4', 'aaa5', 'aaa6');

-- ----------------------------
-- Table structure for s_dictionary_detail
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionary_detail`;
CREATE TABLE `s_dictionary_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort` int(11) DEFAULT NULL,
  `remark` longtext,
  `value` varchar(200) DEFAULT NULL,
  `sysFlag` char(1) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9AD3C34E5403E6AD` (`pid`),
  CONSTRAINT `FK9AD3C34E5403E6AD` FOREIGN KEY (`pid`) REFERENCES `s_dictionary_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_dictionary_detail
-- ----------------------------
INSERT INTO `s_dictionary_detail` VALUES ('3', '1', 'aaa', 'bbb', '1', '1');

-- ----------------------------
-- Table structure for s_popedom
-- ----------------------------
DROP TABLE IF EXISTS `s_popedom`;
CREATE TABLE `s_popedom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` longtext,
  `pid` int(11) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `istable` varchar(100) DEFAULT NULL,
  `actionName` varchar(100) DEFAULT NULL,
  `methodName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_popedom
-- ----------------------------
INSERT INTO `s_popedom` VALUES ('1', 'aaa1', '0', 'aaa2', '测试', 'aa', 'test', 'testList');
INSERT INTO `s_popedom` VALUES ('3', 'bbb1', '0', 'load4Visit', '客户拜访', 'bb', 'company', 'companyList');
INSERT INTO `s_popedom` VALUES ('4', 'ccc1', '0', 'load4LinkManMain', '联系人列表', 'cc', 'companyLinkmanAction', 'load4LinkManMain');
INSERT INTO `s_popedom` VALUES ('5', 'ddd1', '0', 'load4CompanyTouchMain', '联系记录列表', 'dd', 'aaaa', 'bbb');
INSERT INTO `s_popedom` VALUES ('6', 'eee1', '3', 'eee2', '新建', 'table', 'eee5', 'eee6');
INSERT INTO `s_popedom` VALUES ('7', 'fff', '3', 'fff2', '删除', 'table', '', 'fff5');

-- ----------------------------
-- Table structure for s_province
-- ----------------------------
DROP TABLE IF EXISTS `s_province`;
CREATE TABLE `s_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `pycode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_province
-- ----------------------------

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` longtext,
  `name` varchar(100) DEFAULT NULL,
  `popedom` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', null, '管理员', '3,load4Visit,company,companyList:4,load4LinkManMain,companyLinkmanAction,load4LinkManMain:5,load4CompanyTouchMain,aaaa,bbb:');
INSERT INTO `s_role` VALUES ('2', null, '部门经理', null);
INSERT INTO `s_role` VALUES ('3', null, '普通员工', null);
INSERT INTO `s_role` VALUES ('4', null, '业务员', null);
INSERT INTO `s_role` VALUES ('5', null, '审计员', null);
INSERT INTO `s_role` VALUES ('6', null, '角色2', null);
INSERT INTO `s_role` VALUES ('7', null, '角色3', null);

-- ----------------------------
-- Table structure for s_user_group
-- ----------------------------
DROP TABLE IF EXISTS `s_user_group`;
CREATE TABLE `s_user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` longtext,
  `name` varchar(100) DEFAULT NULL,
  `principal` varchar(50) DEFAULT NULL,
  `incumbent` varchar(200) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  `fcode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_group
-- ----------------------------
INSERT INTO `s_user_group` VALUES ('1', null, 'admin', null, null, '0', null);
INSERT INTO `s_user_group` VALUES ('2', 'test', '研发部', '董正', '软件研发', '0', null);
INSERT INTO `s_user_group` VALUES ('3', '无', '市场部', '张三', '市场相关', '0', null);
INSERT INTO `s_user_group` VALUES ('4', 'aaa3', '部门1', 'aaa', 'aaa2', '3', null);
INSERT INTO `s_user_group` VALUES ('5', 'bbb3', '部门2', 'bbb', 'bbb2', '3', null);
INSERT INTO `s_user_group` VALUES ('6', 'ccc3', '部门3', 'ccc', 'ccc2', '3', null);
INSERT INTO `s_user_group` VALUES ('7', 'aaa', '人力资源部', '李四', 'test', '0', null);


-- ----------------------------
-- Table structure for b_need_gather
-- ----------------------------
DROP TABLE IF EXISTS `b_need_gather`;
CREATE TABLE `b_need_gather` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_id` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `owner_usr` int(11) DEFAULT NULL,
  `shareId` longtext,
  `read_shareId` longtext,
  `creator` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `remark` longtext,
  `c_id` int(11) NOT NULL,
  `c_name` varchar(200) NOT NULL,
  `c_type` varchar(10) DEFAULT NULL,
  `build_date` datetime DEFAULT NULL,
  `sale_code` varchar(100) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `payed` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `over_flag` char(1) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEE08F9675C892D95` (`pid`),
  KEY `FKEE08F967BCDAE372` (`sale_id`),
  CONSTRAINT `FKEE08F9675C892D95` FOREIGN KEY (`pid`) REFERENCES `b_gather` (`id`),
  CONSTRAINT `FKEE08F967BCDAE372` FOREIGN KEY (`sale_id`) REFERENCES `b_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_need_gather
-- ----------------------------

-- ----------------------------
-- Table structure for b_product
-- ----------------------------
DROP TABLE IF EXISTS `b_product`;
CREATE TABLE `b_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ptype_id` int(11) NOT NULL,
  `sort` int(11) DEFAULT NULL,
  `creater` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updater` varchar(100) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `remark` longtext,
  `status` char(1) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `model` varchar(100) DEFAULT NULL,
  `spec` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `product_size` varchar(100) DEFAULT NULL,
  `bar_code` varchar(100) DEFAULT NULL,
  `provider` varchar(200) DEFAULT NULL,
  `stock` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `buy_price` double DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `pycode` varchar(30) DEFAULT NULL,
  `custom1` varchar(100) DEFAULT NULL,
  `custom2` varchar(100) DEFAULT NULL,
  `custom3` varchar(100) DEFAULT NULL,
  `custom4` varchar(100) DEFAULT NULL,
  `choice1` varchar(100) DEFAULT NULL,
  `choice2` varchar(100) DEFAULT NULL,
  `choice3` varchar(100) DEFAULT NULL,
  `choice4` varchar(100) DEFAULT NULL,
  `time1` datetime DEFAULT NULL,
  `time2` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3C4FF21274E695EA` (`ptype_id`),
  CONSTRAINT `FK3C4FF21274E695EA` FOREIGN KEY (`ptype_id`) REFERENCES `b_product_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_product
-- ----------------------------
INSERT INTO `b_product` VALUES ('1', '1', null, null, null, null, null, 'aaa', null, 'aaa1', 'U盘', 'aaa2', 'aaa3', 'aaa4', 'red', '40*15*12', 'aaa5', 'aaa6', '23', '35', null, null, 'aaa', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `b_product` VALUES ('2', '2', null, null, null, null, null, 'bbb', null, 'bbb1', '硬盘', 'bbb2', 'bbb3', 'bbb4', 'black', '100*50*12', 'bbb5', 'bbb6', '111', '450', null, null, 'bbb', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `b_product` VALUES ('3', '1', null, null, null, null, null, 'ccc', null, 'ccc1', 'cccc', 'ccc2', 'ccc3', 'ccc4', 'ccafd', '3234', 'ccc5', 'ccc6', '22', '22', null, null, 'ccc', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `b_product` VALUES ('5', '1', null, '', '2016-07-27 10:32:22', '', null, '', null, '', 'aaa', '', '', '', '', '', '', '', null, null, null, null, '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `b_product` VALUES ('6', '1', null, '', '2016-07-27 10:42:47', '', null, '', null, 'bbb2', 'bbb', '', '', '', '', '', '', '', null, null, null, '2016/7/6.jpg', 'bbb3', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `b_product` VALUES ('7', '1', null, '', '2016-07-27 14:35:25', '', null, '', null, 'ddd2', 'ddd', '', '', '', '', '', '', '', null, null, null, '2016/7/7.jpg', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `b_product` VALUES ('8', '6', null, '', '2016-07-27 15:09:31', '', null, '', null, 'eee2', 'eee', '', '', '', '', '', '', '', null, null, null, '2016/7/8.jpg', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `b_product` VALUES ('9', '3', null, '', '2016-11-04 14:17:27', '', null, '', null, '9991', '999', '9993', '9994', '', '', '', '', '', null, null, null, '2016/11/9.jpg', '992', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `b_product` VALUES ('10', '1', null, '', '2016-12-02 15:01:30', '', null, '', null, '', '1234', '', '', '', '', '', '', '', null, null, null, '2016/12/10.jpg', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `b_product` VALUES ('11', '1', null, '', '2016-12-21 09:11:41', '', null, '', null, '', '123', '', '', '', '', '', '', '', null, null, null, null, '', '', '', '', '', '', '', '', '', null, null);

-- ----------------------------
-- Table structure for s_city
-- ----------------------------
DROP TABLE IF EXISTS `s_city`;
CREATE TABLE `s_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pycode` varchar(50) DEFAULT NULL,
  `postcode` varchar(50) DEFAULT NULL,
  `areacode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9A6A1B75399121B` (`pid`),
  CONSTRAINT `FKC9A6A1B75399121B` FOREIGN KEY (`pid`) REFERENCES `s_province` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_city
-- ----------------------------

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creator` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updater` varchar(100) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `remark` longtext,
  `name` varchar(100) DEFAULT NULL,
  `cnname` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `telephone` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `beginDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `access_fileLevel` varchar(50) DEFAULT NULL,
  `menus` longtext,
  `popedom` longtext,
  `status` varchar(10) DEFAULT NULL,
  `commendman` varchar(50) DEFAULT NULL,
  `movetelephone` varchar(20) DEFAULT NULL,
  `nowaddress` varchar(200) DEFAULT NULL,
  `nowtelephone` varchar(20) DEFAULT NULL,
  `identitycode` varchar(20) DEFAULT NULL,
  `insurancecode` varchar(20) DEFAULT NULL,
  `instancylinkman` varchar(50) DEFAULT NULL,
  `instancytelephone` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `personneltype` varchar(50) DEFAULT NULL,
  `duty` varchar(50) DEFAULT NULL,
  `workdate` date DEFAULT NULL,
  `highschool` varchar(100) DEFAULT NULL,
  `finishschool` varchar(100) DEFAULT NULL,
  `finishschooldate` date DEFAULT NULL,
  `consortname` varchar(100) DEFAULT NULL,
  `youngonename` varchar(100) DEFAULT NULL,
  `officetelephone` varchar(20) DEFAULT NULL,
  `consorttelephone` varchar(20) DEFAULT NULL,
  `avocation` longtext,
  `consortcompany` varchar(200) DEFAULT NULL,
  `strongsuit` longtext,
  `communicate` longtext,
  `bringup` longtext,
  `organise` longtext,
  `analyse` longtext,
  `planing` longtext,
  `empolder` longtext,
  `relation` longtext,
  `role_id` int(11) DEFAULT NULL,
  `group_Id` int(11) DEFAULT NULL,
  `access_group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9AEF417F26BFB5A` (`role_id`),
  KEY `FKC9AEF417710BAEEF` (`group_Id`),
  KEY `FKC9AEF417400C2171` (`access_group_id`),
  CONSTRAINT `FKC9AEF417400C2171` FOREIGN KEY (`access_group_id`) REFERENCES `s_access_group` (`Id`),
  CONSTRAINT `FKC9AEF417710BAEEF` FOREIGN KEY (`group_Id`) REFERENCES `s_user_group` (`id`),
  CONSTRAINT `FKC9AEF417F26BFB5A` FOREIGN KEY (`role_id`) REFERENCES `s_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('3', 'admin', '2010-05-24 15:23:59', null, '2010-05-25 14:17:28', null, 'admin', 'admin', '123456', null, null, null, '2016-05-01', '2017-03-14', null, null, '3,load4Visit,company,companyList:4,load4LinkManMain,companyLinkmanAction,load4LinkManMain:5,load4CompanyTouchMain,aaaa,bbb:', '启用', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1');
INSERT INTO `s_user` VALUES ('4', null, null, null, null, null, 'zhangsan', '张三', '123456', null, null, null, '1960-09-01', '2016-11-02', null, null, null, '启用', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, '2');
INSERT INTO `s_user` VALUES ('5', null, null, null, null, null, 'test', '测试', '123456', null, null, null, '2016-09-01', '2018-09-05', null, null, '3,load4Visit,company,companyList:4,load4LinkManMain,companyLinkmanAction,load4LinkManMain:5,load4CompanyTouchMain,aaaa,bbb:', '启用', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '1');
INSERT INTO `s_user` VALUES ('6', null, null, null, null, null, 'lisi', '李四', '123456', null, null, null, null, null, null, null, null, '启用', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2', '2');
INSERT INTO `s_user` VALUES ('7', null, null, null, null, null, 'wangwu', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2');
INSERT INTO `s_user` VALUES ('8', null, null, null, null, null, 'zhaoliu', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for b_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `b_order_detail`;
CREATE TABLE `b_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(100) DEFAULT NULL,
  `spec` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `agio` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1D34F31F9758EB0B` (`order_id`),
  KEY `FK1D34F31F2D6ECC0A` (`p_id`),
  CONSTRAINT `FK1D34F31F2D6ECC0A` FOREIGN KEY (`p_id`) REFERENCES `b_product` (`id`),
  CONSTRAINT `FK1D34F31F9758EB0B` FOREIGN KEY (`order_id`) REFERENCES `b_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for c_company
-- ----------------------------
DROP TABLE IF EXISTS `c_company`;
CREATE TABLE `c_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `pycode` varchar(100) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `grade` varchar(100) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `c_type` varchar(10) NOT NULL,
  `m_type` varchar(10) NOT NULL,
  `region_id` int(11) DEFAULT NULL,
  `region_name` varchar(100) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `postcode` varchar(50) DEFAULT NULL,
  `tel1` varchar(50) DEFAULT NULL,
  `tel2` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `web` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `dealing` varchar(100) DEFAULT NULL,
  `scale` varchar(100) DEFAULT NULL,
  `register_money` varchar(50) DEFAULT NULL,
  `kind` varchar(100) DEFAULT NULL,
  `trade` varchar(100) DEFAULT NULL,
  `legal_person` varchar(50) DEFAULT NULL,
  `bank` varchar(100) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `tax_code` varchar(100) DEFAULT NULL,
  `buy_flag` char(1) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `remark` longtext,
  `next_touch_date` datetime DEFAULT NULL,
  `next_service_date` datetime DEFAULT NULL,
  `first_touch_date` datetime DEFAULT NULL,
  `last_touch_date` datetime DEFAULT NULL,
  `next_touch_aim` longtext,
  `dispense_person` varchar(50) DEFAULT NULL,
  `dispense_date` datetime DEFAULT NULL,
  `apply_user_id` int(11) DEFAULT NULL,
  `s_person` varchar(50) DEFAULT NULL,
  `s_reason` longtext,
  `s_date` datetime DEFAULT NULL,
  `plan_callback_reason` longtext,
  `plan_callback_date` datetime DEFAULT NULL,
  `cur_link_flag` char(1) DEFAULT NULL,
  `cur_buy_flag` char(1) DEFAULT NULL,
  `freeze_leave_day` int(11) DEFAULT NULL,
  `custom1` varchar(100) DEFAULT NULL,
  `custom2` varchar(100) DEFAULT NULL,
  `custom3` varchar(100) DEFAULT NULL,
  `custom4` varchar(100) DEFAULT NULL,
  `choice1` varchar(100) DEFAULT NULL,
  `choice2` varchar(100) DEFAULT NULL,
  `choice3` varchar(100) DEFAULT NULL,
  `choice4` varchar(100) DEFAULT NULL,
  `time1` datetime DEFAULT NULL,
  `time2` datetime DEFAULT NULL,
  `share_flag` char(1) DEFAULT NULL,
  `share_ids` longtext,
  `quality` varchar(100) DEFAULT NULL,
  `owner_usr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1BADD0A1A16E2733` (`owner_usr`),
  CONSTRAINT `FK1BADD0A1A16E2733` FOREIGN KEY (`owner_usr`) REFERENCES `s_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_company
-- ----------------------------
INSERT INTO `c_company` VALUES ('1', '移动', null, null, '一级', null, 'aa', 'aaa', null, null, null, null, null, null, '13333333', null, null, 'test0@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-12-17 00:00:00', null, null, '2016-07-01 15:12:49', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, 'aaa', '3');
INSERT INTO `c_company` VALUES ('2', 'test1', null, null, 'bbb2', null, 'bbb3', 'bbb4', null, null, null, null, null, null, '232432153', null, null, 'test1@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-12-01 00:00:00', null, null, '2016-07-01 15:46:53', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, 'bbb', '3');
INSERT INTO `c_company` VALUES ('3', 'test2', null, null, 'ccc2', null, 'ccc3', 'ccc4', null, null, null, null, null, null, '245672345', null, null, 'test2@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-12-01 00:00:00', null, null, '2016-06-08 15:47:01', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, 'ccc', '3');
INSERT INTO `c_company` VALUES ('4', 'test3', null, null, 'ddd2', null, 'ddd3', 'ddd4', null, null, null, null, null, null, '23456', null, null, 'test3@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-08-10 15:47:08', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, 'ddd', null);
INSERT INTO `c_company` VALUES ('5', 'test4', null, null, 'eee2', null, 'eee3', 'eee4', null, null, null, null, null, null, '23456', null, null, 'test4@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-07-12 15:47:13', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'eee', null);
INSERT INTO `c_company` VALUES ('6', 'test5', null, null, 'fff2', null, 'fff3', 'fff4', null, null, null, null, null, null, '56789', null, null, 'test5@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2016-07-09 15:47:16', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'ffff', null);

-- ----------------------------
-- Table structure for c_company_linkman
-- ----------------------------
DROP TABLE IF EXISTS `c_company_linkman`;
CREATE TABLE `c_company_linkman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `pycode` varchar(50) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `duty` varchar(100) DEFAULT NULL,
  `office_tel` varchar(50) DEFAULT NULL,
  `home_tel` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `qq_num` varchar(50) DEFAULT NULL,
  `qq_name` varchar(50) DEFAULT NULL,
  `postcode` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `other_link` varchar(200) DEFAULT NULL,
  `hobby` varchar(200) DEFAULT NULL,
  `taboo` varchar(200) DEFAULT NULL,
  `main_flag` char(1) DEFAULT NULL,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` longtext,
  `custom1` varchar(100) DEFAULT NULL,
  `custom2` varchar(100) DEFAULT NULL,
  `custom3` varchar(100) DEFAULT NULL,
  `custom4` varchar(100) DEFAULT NULL,
  `choice1` varchar(100) DEFAULT NULL,
  `choice2` varchar(100) DEFAULT NULL,
  `choice3` varchar(100) DEFAULT NULL,
  `choice4` varchar(100) DEFAULT NULL,
  `time1` datetime DEFAULT NULL,
  `time2` datetime DEFAULT NULL,
  `m_type` varchar(10) DEFAULT NULL,
  `share_flag` char(1) DEFAULT NULL,
  `share_ids` longtext,
  `c_id` int(11) DEFAULT NULL,
  `owner_usr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8F058182A16E2733` (`owner_usr`),
  KEY `FK8F058182E0637FA4` (`c_id`),
  CONSTRAINT `FK8F058182A16E2733` FOREIGN KEY (`owner_usr`) REFERENCES `s_user` (`id`),
  CONSTRAINT `FK8F058182E0637FA4` FOREIGN KEY (`c_id`) REFERENCES `c_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_company_linkman
-- ----------------------------

-- ----------------------------
-- Table structure for c_company_touch
-- ----------------------------
DROP TABLE IF EXISTS `c_company_touch`;
CREATE TABLE `c_company_touch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL,
  `link_man` varchar(50) DEFAULT NULL,
  `link_fashion` varchar(100) DEFAULT NULL,
  `link_type` varchar(100) DEFAULT NULL,
  `link_time` datetime DEFAULT NULL,
  `content` longtext,
  `user_name` varchar(50) DEFAULT NULL,
  `next_touch_date` datetime DEFAULT NULL,
  `next_touch_aim` longtext,
  `creater` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `updater` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` longtext,
  `custom1` varchar(100) DEFAULT NULL,
  `custom2` varchar(100) DEFAULT NULL,
  `custom3` varchar(100) DEFAULT NULL,
  `custom4` varchar(100) DEFAULT NULL,
  `choice1` varchar(100) DEFAULT NULL,
  `choice2` varchar(100) DEFAULT NULL,
  `choice3` varchar(100) DEFAULT NULL,
  `choice4` varchar(100) DEFAULT NULL,
  `time1` datetime DEFAULT NULL,
  `time2` datetime DEFAULT NULL,
  `m_type` varchar(10) DEFAULT NULL,
  `share_flag` char(1) DEFAULT NULL,
  `share_ids` longtext,
  `owner_usr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE3905621A16E2733` (`owner_usr`),
  KEY `FKE3905621E0637FA4` (`c_id`),
  CONSTRAINT `FKE3905621A16E2733` FOREIGN KEY (`owner_usr`) REFERENCES `s_user` (`id`),
  CONSTRAINT `FKE3905621E0637FA4` FOREIGN KEY (`c_id`) REFERENCES `c_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_company_touch
-- ----------------------------

