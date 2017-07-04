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

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_gather
-- ----------------------------
DROP TABLE IF EXISTS `b_gather`;
CREATE TABLE `b_gather` (
  `id`         INT(11)      NOT NULL AUTO_INCREMENT,
  `owner_usr`  INT(11)               DEFAULT NULL,
  `creater`    VARCHAR(50)           DEFAULT NULL,
  `createTime` DATETIME              DEFAULT NULL,
  `updater`    VARCHAR(50)           DEFAULT NULL,
  `updateTime` DATETIME              DEFAULT NULL,
  `remark`     LONGTEXT,
  `c_id`       INT(11)      NOT NULL,
  `c_name`     VARCHAR(200) NOT NULL,
  `c_type`     VARCHAR(10)           DEFAULT NULL,
  `payer`      VARCHAR(100)          DEFAULT NULL,
  `pay_date`   DATETIME              DEFAULT NULL,
  `pay_type`   VARCHAR(100)          DEFAULT NULL,
  `bill_code`  VARCHAR(100)          DEFAULT NULL,
  `handler`    VARCHAR(100)          DEFAULT NULL,
  `total`      DOUBLE                DEFAULT NULL,
  `statusid`   VARCHAR(100)          DEFAULT NULL,
  `status`     VARCHAR(10)           DEFAULT NULL,
  `auditor`    VARCHAR(50)           DEFAULT NULL,
  `audit_date` DATETIME              DEFAULT NULL,
  `audit_idea` LONGTEXT,
  `code`       VARCHAR(100)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of b_gather
-- ----------------------------

-- ----------------------------
-- Table structure for b_order
-- ----------------------------
DROP TABLE IF EXISTS `b_order`;
CREATE TABLE `b_order` (
  `id`           INT(11) NOT NULL AUTO_INCREMENT,
  `owner_usr`    INT(11) NOT NULL,
  `creater`      VARCHAR(50)      DEFAULT NULL,
  `createTime`   DATETIME         DEFAULT NULL,
  `updater`      VARCHAR(50)      DEFAULT NULL,
  `updateTime`   DATETIME         DEFAULT NULL,
  `remark`       LONGTEXT,
  `code`         VARCHAR(100)     DEFAULT NULL,
  `order_date`   DATE             DEFAULT NULL,
  `c_id`         INT(11) NOT NULL,
  `c_name`       VARCHAR(100)     DEFAULT NULL,
  `c_type`       VARCHAR(20)      DEFAULT NULL,
  `linkman`      VARCHAR(100)     DEFAULT NULL,
  `telephone`    VARCHAR(100)     DEFAULT NULL,
  `address`      VARCHAR(200)     DEFAULT NULL,
  `seller`       VARCHAR(100)     DEFAULT NULL,
  `total`        DOUBLE           DEFAULT NULL,
  `agio`         DOUBLE           DEFAULT NULL,
  `agio_total`   DOUBLE           DEFAULT NULL,
  `auditor`      VARCHAR(100)     DEFAULT NULL,
  `audit_date`   DATE             DEFAULT NULL,
  `status_id`    VARCHAR(255)     DEFAULT NULL,
  `status`       VARCHAR(20)      DEFAULT NULL,
  `audit_reason` LONGTEXT,
  `custom1`      VARCHAR(100)     DEFAULT NULL,
  `custom2`      VARCHAR(100)     DEFAULT NULL,
  `custom3`      VARCHAR(100)     DEFAULT NULL,
  `custom4`      VARCHAR(100)     DEFAULT NULL,
  `choice1`      VARCHAR(100)     DEFAULT NULL,
  `choice2`      VARCHAR(100)     DEFAULT NULL,
  `choice3`      VARCHAR(100)     DEFAULT NULL,
  `choice4`      VARCHAR(100)     DEFAULT NULL,
  `time1`        DATETIME         DEFAULT NULL,
  `time2`        DATETIME         DEFAULT NULL,
  `share_flag`   CHAR(1)          DEFAULT NULL,
  `share_ids`    LONGTEXT,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of b_order
-- ----------------------------
INSERT INTO `b_order` VALUES
  ('1', '4', '张三', '2017-01-11 08:42:07', NULL, NULL, 'aaa', 'aaa', '2016-10-27', '1', '移动', 'aa', NULL, NULL, NULL,
                                                                                             NULL, '100', '10', '90',
                                                                                             NULL, NULL, NULL, '草稿',
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
   NULL, NULL, NULL, '1', NULL);

-- ----------------------------
-- Table structure for b_product_type
-- ----------------------------
DROP TABLE IF EXISTS `b_product_type`;
CREATE TABLE `b_product_type` (
  `id`          INT(11)      NOT NULL AUTO_INCREMENT,
  `pid`         INT(11)      NOT NULL,
  `fcode`       VARCHAR(100)          DEFAULT NULL,
  `code`        VARCHAR(100)          DEFAULT NULL,
  `name`        VARCHAR(100) NOT NULL,
  `remark`      LONGTEXT,
  `sort`        INT(11)               DEFAULT NULL,
  `create_time` DATETIME              DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 24
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of b_product_type
-- ----------------------------
INSERT INTO `b_product_type` VALUES ('1', '0', NULL, '001', '电器', '001', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('2', '1', NULL, '002', '电冰箱', '002', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('3', '1', NULL, '00333', '洗衣机', '003', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('4', '3', NULL, '004', '滚筒洗衣机3', '004', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('6', '3', NULL, '006', '波轮洗衣机', '006', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('7', '0', NULL, '007', '服装', '007', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('8', '7', NULL, '008', '男装', '008', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('9', '7', NULL, '009', '女装', 'aaa', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('10', '7', NULL, '0010', '童装', '111', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('11', '1', NULL, '23456', '电视', 'aaa', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('12', '11', NULL, 'qwertyu', '黑白电视', 'asads', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('13', '11', NULL, '8888', '液晶电视', '234325', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('16', '0', NULL, 'bbb', 'aaa', 'ccc', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('17', '0', NULL, 'ddd', 'bbb', 'aaa', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('18', '16', NULL, '333', '333', '333', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('19', '16', NULL, '444', '444', '444', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('20', '16', NULL, '555', '555', '555', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('21', '16', NULL, '666', '666', '666', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('22', '3', NULL, '004', '滚筒洗衣机2', '004', NULL, NULL);
INSERT INTO `b_product_type` VALUES ('23', '16', NULL, '666', '666', '777', NULL, NULL);

-- ----------------------------
-- Table structure for c3p0testtable
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable` (
  `a` CHAR(1) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of c3p0testtable
-- ----------------------------

-- ----------------------------
-- Table structure for s_access_group
-- ----------------------------
DROP TABLE IF EXISTS `s_access_group`;
CREATE TABLE `s_access_group` (
  `Id`     INT(11) NOT NULL AUTO_INCREMENT,
  `name`   VARCHAR(255)     DEFAULT NULL,
  `dpte`   LONGTEXT,
  `remark` LONGTEXT,
  PRIMARY KEY (`Id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_access_group
-- ----------------------------
INSERT INTO `s_access_group` VALUES ('1', '全部查看权限', '2,3,', NULL);
INSERT INTO `s_access_group` VALUES ('2', '人力资源总监', '', NULL);
INSERT INTO `s_access_group` VALUES ('3', '可查看市场部', NULL, NULL);
INSERT INTO `s_access_group` VALUES ('4', '可查看开发部', NULL, NULL);
INSERT INTO `s_access_group` VALUES ('5', '查询权限1', NULL, NULL);
INSERT INTO `s_access_group` VALUES ('6', '查询权限2', NULL, NULL);
INSERT INTO `s_access_group` VALUES ('7', '查询权限3', NULL, NULL);
INSERT INTO `s_access_group` VALUES ('8', '查询权限4', NULL, NULL);

-- ----------------------------
-- Table structure for s_dictionary_class
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionary_class`;
CREATE TABLE `s_dictionary_class` (
  `id`               INT(11) NOT NULL AUTO_INCREMENT,
  `remark`           LONGTEXT,
  `code`             VARCHAR(100)     DEFAULT NULL,
  `name`             VARCHAR(100)     DEFAULT NULL,
  `chineseTableName` VARCHAR(100)     DEFAULT NULL,
  `englishTableName` VARCHAR(100)     DEFAULT NULL,
  `available`        VARCHAR(10)      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_dictionary_class
-- ----------------------------
INSERT INTO `s_dictionary_class` VALUES ('1', 'aaa1', 'aaa2', 'aaa3', 'aaa4', 'aaa5', 'aaa6');

-- ----------------------------
-- Table structure for s_dictionary_detail
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionary_detail`;
CREATE TABLE `s_dictionary_detail` (
  `id`      INT(11) NOT NULL AUTO_INCREMENT,
  `sort`    INT(11)          DEFAULT NULL,
  `remark`  LONGTEXT,
  `value`   VARCHAR(200)     DEFAULT NULL,
  `sysFlag` CHAR(1)          DEFAULT NULL,
  `pid`     INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9AD3C34E5403E6AD` (`pid`),
  CONSTRAINT `FK9AD3C34E5403E6AD` FOREIGN KEY (`pid`) REFERENCES `s_dictionary_class` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_dictionary_detail
-- ----------------------------
INSERT INTO `s_dictionary_detail` VALUES ('3', '1', 'aaa', 'bbb', '1', '1');

-- ----------------------------
-- Table structure for s_popedom
-- ----------------------------
DROP TABLE IF EXISTS `s_popedom`;
CREATE TABLE `s_popedom` (
  `id`         INT(11) NOT NULL AUTO_INCREMENT,
  `remark`     LONGTEXT,
  `pid`        INT(11) NOT NULL,
  `code`       VARCHAR(50)      DEFAULT NULL,
  `name`       VARCHAR(200)     DEFAULT NULL,
  `istable`    VARCHAR(100)     DEFAULT NULL,
  `actionName` VARCHAR(100)     DEFAULT NULL,
  `methodName` VARCHAR(50)      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_popedom
-- ----------------------------
INSERT INTO `s_popedom` VALUES ('1', 'aaa1', '0', 'aaa2', '测试', 'aa', 'test', 'testList');
INSERT INTO `s_popedom` VALUES ('3', 'bbb1', '0', 'load4Visit', '客户拜访', 'bb', 'company', 'companyList');
INSERT INTO `s_popedom`
VALUES ('4', 'ccc1', '0', 'load4LinkManMain', '联系人列表', 'cc', 'companyLinkmanAction', 'load4LinkManMain');
INSERT INTO `s_popedom` VALUES ('5', 'ddd1', '0', 'load4CompanyTouchMain', '联系记录列表', 'dd', 'aaaa', 'bbb');
INSERT INTO `s_popedom` VALUES ('6', 'eee1', '3', 'eee2', '新建', 'table', 'eee5', 'eee6');
INSERT INTO `s_popedom` VALUES ('7', 'fff', '3', 'fff2', '删除', 'table', '', 'fff5');

-- ----------------------------
-- Table structure for s_province
-- ----------------------------
DROP TABLE IF EXISTS `s_province`;
CREATE TABLE `s_province` (
  `id`     INT(11) NOT NULL AUTO_INCREMENT,
  `name`   VARCHAR(100)     DEFAULT NULL,
  `pycode` VARCHAR(50)      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_province
-- ----------------------------

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id`      INT(11) NOT NULL AUTO_INCREMENT,
  `remark`  LONGTEXT,
  `name`    VARCHAR(100)     DEFAULT NULL,
  `popedom` LONGTEXT,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', NULL, '管理员',
                             '3,load4Visit,company,companyList:4,load4LinkManMain,companyLinkmanAction,load4LinkManMain:5,load4CompanyTouchMain,aaaa,bbb:');
INSERT INTO `s_role` VALUES ('2', NULL, '部门经理', NULL);
INSERT INTO `s_role` VALUES ('3', NULL, '普通员工', NULL);
INSERT INTO `s_role` VALUES ('4', NULL, '业务员', NULL);
INSERT INTO `s_role` VALUES ('5', NULL, '审计员', NULL);
INSERT INTO `s_role` VALUES ('6', NULL, '角色2', NULL);
INSERT INTO `s_role` VALUES ('7', NULL, '角色3', NULL);

-- ----------------------------
-- Table structure for s_user_group
-- ----------------------------
DROP TABLE IF EXISTS `s_user_group`;
CREATE TABLE `s_user_group` (
  `id`        INT(11) NOT NULL AUTO_INCREMENT,
  `remark`    LONGTEXT,
  `name`      VARCHAR(100)     DEFAULT NULL,
  `principal` VARCHAR(50)      DEFAULT NULL,
  `incumbent` VARCHAR(200)     DEFAULT NULL,
  `pid`       INT(11) NOT NULL,
  `fcode`     VARCHAR(50)      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_user_group
-- ----------------------------
INSERT INTO `s_user_group` VALUES ('1', NULL, 'admin', NULL, NULL, '0', NULL);
INSERT INTO `s_user_group` VALUES ('2', 'test', '研发部', '董正', '软件研发', '0', NULL);
INSERT INTO `s_user_group` VALUES ('3', '无', '市场部', '张三', '市场相关', '0', NULL);
INSERT INTO `s_user_group` VALUES ('4', 'aaa3', '部门1', 'aaa', 'aaa2', '3', NULL);
INSERT INTO `s_user_group` VALUES ('5', 'bbb3', '部门2', 'bbb', 'bbb2', '3', NULL);
INSERT INTO `s_user_group` VALUES ('6', 'ccc3', '部门3', 'ccc', 'ccc2', '3', NULL);
INSERT INTO `s_user_group` VALUES ('7', 'aaa', '人力资源部', '李四', 'test', '0', NULL);

-- ----------------------------
-- Table structure for b_need_gather
-- ----------------------------
DROP TABLE IF EXISTS `b_need_gather`;
CREATE TABLE `b_need_gather` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT,
  `sale_id`      INT(11)      NOT NULL,
  `pid`          INT(11)               DEFAULT NULL,
  `owner_usr`    INT(11)               DEFAULT NULL,
  `shareId`      LONGTEXT,
  `read_shareId` LONGTEXT,
  `creator`      VARCHAR(50)           DEFAULT NULL,
  `createTime`   DATETIME              DEFAULT NULL,
  `updater`      VARCHAR(50)           DEFAULT NULL,
  `updateTime`   DATETIME              DEFAULT NULL,
  `remark`       LONGTEXT,
  `c_id`         INT(11)      NOT NULL,
  `c_name`       VARCHAR(200) NOT NULL,
  `c_type`       VARCHAR(10)           DEFAULT NULL,
  `build_date`   DATETIME              DEFAULT NULL,
  `sale_code`    VARCHAR(100)          DEFAULT NULL,
  `total`        DOUBLE                DEFAULT NULL,
  `payed`        DOUBLE                DEFAULT NULL,
  `balance`      DOUBLE                DEFAULT NULL,
  `over_flag`    CHAR(1)               DEFAULT NULL,
  `status`       VARCHAR(20)           DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEE08F9675C892D95` (`pid`),
  KEY `FKEE08F967BCDAE372` (`sale_id`),
  CONSTRAINT `FKEE08F9675C892D95` FOREIGN KEY (`pid`) REFERENCES `b_gather` (`id`),
  CONSTRAINT `FKEE08F967BCDAE372` FOREIGN KEY (`sale_id`) REFERENCES `b_order` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of b_need_gather
-- ----------------------------

-- ----------------------------
-- Table structure for b_product
-- ----------------------------
DROP TABLE IF EXISTS `b_product`;
CREATE TABLE `b_product` (
  `id`           INT(11)      NOT NULL AUTO_INCREMENT,
  `ptype_id`     INT(11)      NOT NULL,
  `sort`         INT(11)               DEFAULT NULL,
  `creater`      VARCHAR(100)          DEFAULT NULL,
  `createTime`   DATETIME              DEFAULT NULL,
  `updater`      VARCHAR(100)          DEFAULT NULL,
  `updateTime`   DATETIME              DEFAULT NULL,
  `remark`       LONGTEXT,
  `status`       CHAR(1)               DEFAULT NULL,
  `code`         VARCHAR(50)           DEFAULT NULL,
  `name`         VARCHAR(100) NOT NULL,
  `model`        VARCHAR(100)          DEFAULT NULL,
  `spec`         VARCHAR(100)          DEFAULT NULL,
  `unit`         VARCHAR(100)          DEFAULT NULL,
  `color`        VARCHAR(100)          DEFAULT NULL,
  `product_size` VARCHAR(100)          DEFAULT NULL,
  `bar_code`     VARCHAR(100)          DEFAULT NULL,
  `provider`     VARCHAR(200)          DEFAULT NULL,
  `stock`        DOUBLE                DEFAULT NULL,
  `price`        DOUBLE                DEFAULT NULL,
  `buy_price`    DOUBLE                DEFAULT NULL,
  `picture`      VARCHAR(200)          DEFAULT NULL,
  `pycode`       VARCHAR(30)           DEFAULT NULL,
  `custom1`      VARCHAR(100)          DEFAULT NULL,
  `custom2`      VARCHAR(100)          DEFAULT NULL,
  `custom3`      VARCHAR(100)          DEFAULT NULL,
  `custom4`      VARCHAR(100)          DEFAULT NULL,
  `choice1`      VARCHAR(100)          DEFAULT NULL,
  `choice2`      VARCHAR(100)          DEFAULT NULL,
  `choice3`      VARCHAR(100)          DEFAULT NULL,
  `choice4`      VARCHAR(100)          DEFAULT NULL,
  `time1`        DATETIME              DEFAULT NULL,
  `time2`        DATETIME              DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3C4FF21274E695EA` (`ptype_id`),
  CONSTRAINT `FK3C4FF21274E695EA` FOREIGN KEY (`ptype_id`) REFERENCES `b_product_type` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of b_product
-- ----------------------------
INSERT INTO `b_product` VALUES
  ('1', '1', NULL, NULL, NULL, NULL, NULL, 'aaa', NULL, 'aaa1', 'U盘', 'aaa2', 'aaa3', 'aaa4', 'red', '40*15*12', 'aaa5',
                                                                      'aaa6', '23', '35', NULL, NULL, 'aaa', NULL, NULL,
                                                                                                NULL, NULL, NULL, NULL,
                                                                                                NULL, NULL, NULL, NULL);
INSERT INTO `b_product` VALUES
  ('2', '2', NULL, NULL, NULL, NULL, NULL, 'bbb', NULL, 'bbb1', '硬盘', 'bbb2', 'bbb3', 'bbb4', 'black', '100*50*12',
                                                                      'bbb5', 'bbb6', '111', '450', NULL, NULL, 'bbb',
                                                                                                          NULL, NULL,
                                                                                                          NULL, NULL,
                                                                                                          NULL, NULL,
                                                                                                          NULL, NULL,
   NULL, NULL);
INSERT INTO `b_product` VALUES
  ('3', '1', NULL, NULL, NULL, NULL, NULL, 'ccc', NULL, 'ccc1', 'cccc', 'ccc2', 'ccc3', 'ccc4', 'ccafd', '3234', 'ccc5',
                                                                        'ccc6', '22', '22', NULL, NULL, 'ccc', NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL);
INSERT INTO `b_product` VALUES
  ('5', '1', NULL, '', '2016-07-27 10:32:22', '', NULL, '', NULL, '', 'aaa', '', '', '', '', '', '', '', NULL, NULL,
                                                                             NULL, NULL, '', '', '', '', '', '', '', '',
                                                                                   '', NULL, NULL);
INSERT INTO `b_product` VALUES
  ('6', '1', NULL, '', '2016-07-27 10:42:47', '', NULL, '', NULL, 'bbb2', 'bbb', '', '', '', '', '', '', '', NULL, NULL,
                                                                                 NULL, '2016/7/6.jpg', 'bbb3', '', '',
                                                                                       '', '', '', '', '', '', NULL,
   NULL);
INSERT INTO `b_product` VALUES
  ('7', '1', NULL, '', '2016-07-27 14:35:25', '', NULL, '', NULL, 'ddd2', 'ddd', '', '', '', '', '', '', '', NULL, NULL,
                                                                                 NULL, '2016/7/7.jpg', '', '', '', '',
                                                                                       '', '', '', '', '', NULL, NULL);
INSERT INTO `b_product` VALUES
  ('8', '6', NULL, '', '2016-07-27 15:09:31', '', NULL, '', NULL, 'eee2', 'eee', '', '', '', '', '', '', '', NULL, NULL,
                                                                                 NULL, '2016/7/8.jpg', '', '', '', '',
                                                                                       '', '', '', '', '', NULL, NULL);
INSERT INTO `b_product` VALUES
  ('9', '3', NULL, '', '2016-11-04 14:17:27', '', NULL, '', NULL, '9991', '999', '9993', '9994', '', '', '', '', '',
                                                                                 NULL, NULL, NULL, '2016/11/9.jpg',
                                                                                                   '992', '', '', '',
                                                                                                   '', '', '', '', '',
   NULL, NULL);
INSERT INTO `b_product` VALUES
  ('10', '1', NULL, '', '2016-12-02 15:01:30', '', NULL, '', NULL, '', '1234', '', '', '', '', '', '', '', NULL, NULL,
                                                                               NULL, '2016/12/10.jpg', '', '', '', '',
                                                                                     '', '', '', '', '', NULL, NULL);
INSERT INTO `b_product` VALUES
  ('11', '1', NULL, '', '2016-12-21 09:11:41', '', NULL, '', NULL, '', '123', '', '', '', '', '', '', '', NULL, NULL,
                                                                              NULL, NULL, '', '', '', '', '', '', '',
                                                                                    '', '', NULL, NULL);

-- ----------------------------
-- Table structure for s_city
-- ----------------------------
DROP TABLE IF EXISTS `s_city`;
CREATE TABLE `s_city` (
  `id`       INT(11) NOT NULL AUTO_INCREMENT,
  `pid`      INT(11)          DEFAULT NULL,
  `name`     VARCHAR(100)     DEFAULT NULL,
  `pycode`   VARCHAR(50)      DEFAULT NULL,
  `postcode` VARCHAR(50)      DEFAULT NULL,
  `areacode` VARCHAR(50)      DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9A6A1B75399121B` (`pid`),
  CONSTRAINT `FKC9A6A1B75399121B` FOREIGN KEY (`pid`) REFERENCES `s_province` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_city
-- ----------------------------

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id`                INT(11) NOT NULL AUTO_INCREMENT,
  `creator`           VARCHAR(100)     DEFAULT NULL,
  `createTime`        DATETIME         DEFAULT NULL,
  `updater`           VARCHAR(100)     DEFAULT NULL,
  `updateTime`        DATETIME         DEFAULT NULL,
  `remark`            LONGTEXT,
  `name`              VARCHAR(100)     DEFAULT NULL,
  `cnname`            VARCHAR(100)     DEFAULT NULL,
  `password`          VARCHAR(100)     DEFAULT NULL,
  `address`           VARCHAR(200)     DEFAULT NULL,
  `telephone`         VARCHAR(100)     DEFAULT NULL,
  `email`             VARCHAR(100)     DEFAULT NULL,
  `beginDate`         DATE             DEFAULT NULL,
  `endDate`           DATE             DEFAULT NULL,
  `access_fileLevel`  VARCHAR(50)      DEFAULT NULL,
  `menus`             LONGTEXT,
  `popedom`           LONGTEXT,
  `status`            VARCHAR(10)      DEFAULT NULL,
  `commendman`        VARCHAR(50)      DEFAULT NULL,
  `movetelephone`     VARCHAR(20)      DEFAULT NULL,
  `nowaddress`        VARCHAR(200)     DEFAULT NULL,
  `nowtelephone`      VARCHAR(20)      DEFAULT NULL,
  `identitycode`      VARCHAR(20)      DEFAULT NULL,
  `insurancecode`     VARCHAR(20)      DEFAULT NULL,
  `instancylinkman`   VARCHAR(50)      DEFAULT NULL,
  `instancytelephone` VARCHAR(50)      DEFAULT NULL,
  `sex`               VARCHAR(10)      DEFAULT NULL,
  `birthday`          DATE             DEFAULT NULL,
  `personneltype`     VARCHAR(50)      DEFAULT NULL,
  `duty`              VARCHAR(50)      DEFAULT NULL,
  `workdate`          DATE             DEFAULT NULL,
  `highschool`        VARCHAR(100)     DEFAULT NULL,
  `finishschool`      VARCHAR(100)     DEFAULT NULL,
  `finishschooldate`  DATE             DEFAULT NULL,
  `consortname`       VARCHAR(100)     DEFAULT NULL,
  `youngonename`      VARCHAR(100)     DEFAULT NULL,
  `officetelephone`   VARCHAR(20)      DEFAULT NULL,
  `consorttelephone`  VARCHAR(20)      DEFAULT NULL,
  `avocation`         LONGTEXT,
  `consortcompany`    VARCHAR(200)     DEFAULT NULL,
  `strongsuit`        LONGTEXT,
  `communicate`       LONGTEXT,
  `bringup`           LONGTEXT,
  `organise`          LONGTEXT,
  `analyse`           LONGTEXT,
  `planing`           LONGTEXT,
  `empolder`          LONGTEXT,
  `relation`          LONGTEXT,
  `role_id`           INT(11)          DEFAULT NULL,
  `group_Id`          INT(11)          DEFAULT NULL,
  `access_group_id`   INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC9AEF417F26BFB5A` (`role_id`),
  KEY `FKC9AEF417710BAEEF` (`group_Id`),
  KEY `FKC9AEF417400C2171` (`access_group_id`),
  CONSTRAINT `FKC9AEF417400C2171` FOREIGN KEY (`access_group_id`) REFERENCES `s_access_group` (`Id`),
  CONSTRAINT `FKC9AEF417710BAEEF` FOREIGN KEY (`group_Id`) REFERENCES `s_user_group` (`id`),
  CONSTRAINT `FKC9AEF417F26BFB5A` FOREIGN KEY (`role_id`) REFERENCES `s_role` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES
  ('3', 'admin', '2010-05-24 15:23:59', NULL, '2010-05-25 14:17:28', NULL, 'admin', 'admin', '123456', NULL, NULL, NULL,
                                                                                                                   '2016-05-01',
                                                                                                                   '2017-03-14',
                                                                                                                   NULL,
                                                                                                                   NULL,
                                                                                                                   '3,load4Visit,company,companyList:4,load4LinkManMain,companyLinkmanAction,load4LinkManMain:5,load4CompanyTouchMain,aaaa,bbb:',
                                                                                                                   '启用',
                                                                                                                   NULL,
                                                                                                                   NULL,
                                                                                                                   NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1',
                                                                      '1', '1');
INSERT INTO `s_user` VALUES
  ('4', NULL, NULL, NULL, NULL, NULL, 'zhangsan', '张三', '123456', NULL, NULL, NULL, '1960-09-01', '2016-11-02', NULL,
                                                                              NULL, NULL, '启用', NULL, NULL, NULL, NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
                                                                                                                  NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', NULL,
                                                                '2');
INSERT INTO `s_user` VALUES
  ('5', NULL, NULL, NULL, NULL, NULL, 'test', '测试', '123456', NULL, NULL, NULL, '2016-09-01', '2018-09-05', NULL, NULL,
                                                                          '3,load4Visit,company,companyList:4,load4LinkManMain,companyLinkmanAction,load4LinkManMain:5,load4CompanyTouchMain,aaaa,bbb:',
                                                                          '启用', NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1', '1');
INSERT INTO `s_user` VALUES
  ('6', NULL, NULL, NULL, NULL, NULL, 'lisi', '李四', '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '启用',
                                                                          NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                            NULL, NULL, NULL, NULL,
                                                                                            NULL, NULL, NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2', '2', '2');
INSERT INTO `s_user` VALUES
  ('7', NULL, NULL, NULL, NULL, NULL, 'wangwu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                        NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                    NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                                            NULL, NULL,
                                                                                                            NULL, NULL,
                                                                                                            NULL, NULL,
                                                                                                            NULL, NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2');
INSERT INTO `s_user` VALUES
  ('8', NULL, NULL, NULL, NULL, NULL, 'zhaoliu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                         NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                     NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                                             NULL, NULL,
                                                                                                             NULL, NULL,
                                                                                                             NULL, NULL,
                                                                                                             NULL, NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for b_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `b_order_detail`;
CREATE TABLE `b_order_detail` (
  `id`       INT(11) NOT NULL AUTO_INCREMENT,
  `p_name`   VARCHAR(100)     DEFAULT NULL,
  `spec`     VARCHAR(100)     DEFAULT NULL,
  `unit`     VARCHAR(100)     DEFAULT NULL,
  `amount`   DOUBLE           DEFAULT NULL,
  `price`    DOUBLE           DEFAULT NULL,
  `agio`     DOUBLE           DEFAULT NULL,
  `total`    DOUBLE           DEFAULT NULL,
  `remark`   VARCHAR(200)     DEFAULT NULL,
  `order_id` INT(11) NOT NULL,
  `p_id`     INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1D34F31F9758EB0B` (`order_id`),
  KEY `FK1D34F31F2D6ECC0A` (`p_id`),
  CONSTRAINT `FK1D34F31F2D6ECC0A` FOREIGN KEY (`p_id`) REFERENCES `b_product` (`id`),
  CONSTRAINT `FK1D34F31F9758EB0B` FOREIGN KEY (`order_id`) REFERENCES `b_order` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of b_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for c_company
-- ----------------------------
DROP TABLE IF EXISTS `c_company`;
CREATE TABLE `c_company` (
  `id`                   INT(11)      NOT NULL AUTO_INCREMENT,
  `name`                 VARCHAR(100) NOT NULL,
  `pycode`               VARCHAR(100)          DEFAULT NULL,
  `code`                 VARCHAR(50)           DEFAULT NULL,
  `grade`                VARCHAR(100)          DEFAULT NULL,
  `source`               VARCHAR(100)          DEFAULT NULL,
  `c_type`               VARCHAR(10)  NOT NULL,
  `m_type`               VARCHAR(10)  NOT NULL,
  `region_id`            INT(11)               DEFAULT NULL,
  `region_name`          VARCHAR(100)          DEFAULT NULL,
  `province`             VARCHAR(50)           DEFAULT NULL,
  `city`                 VARCHAR(50)           DEFAULT NULL,
  `fax`                  VARCHAR(50)           DEFAULT NULL,
  `postcode`             VARCHAR(50)           DEFAULT NULL,
  `tel1`                 VARCHAR(50)           DEFAULT NULL,
  `tel2`                 VARCHAR(50)           DEFAULT NULL,
  `mobile`               VARCHAR(50)           DEFAULT NULL,
  `email`                VARCHAR(100)          DEFAULT NULL,
  `web`                  VARCHAR(200)          DEFAULT NULL,
  `address`              VARCHAR(200)          DEFAULT NULL,
  `dealing`              VARCHAR(100)          DEFAULT NULL,
  `scale`                VARCHAR(100)          DEFAULT NULL,
  `register_money`       VARCHAR(50)           DEFAULT NULL,
  `kind`                 VARCHAR(100)          DEFAULT NULL,
  `trade`                VARCHAR(100)          DEFAULT NULL,
  `legal_person`         VARCHAR(50)           DEFAULT NULL,
  `bank`                 VARCHAR(100)          DEFAULT NULL,
  `account`              VARCHAR(100)          DEFAULT NULL,
  `tax_code`             VARCHAR(100)          DEFAULT NULL,
  `buy_flag`             CHAR(1)               DEFAULT NULL,
  `creater`              VARCHAR(50)           DEFAULT NULL,
  `create_time`          DATETIME              DEFAULT NULL,
  `updater`              VARCHAR(50)           DEFAULT NULL,
  `update_time`          DATETIME              DEFAULT NULL,
  `status`               VARCHAR(10)           DEFAULT NULL,
  `remark`               LONGTEXT,
  `next_touch_date`      DATETIME              DEFAULT NULL,
  `next_service_date`    DATETIME              DEFAULT NULL,
  `first_touch_date`     DATETIME              DEFAULT NULL,
  `last_touch_date`      DATETIME              DEFAULT NULL,
  `next_touch_aim`       LONGTEXT,
  `dispense_person`      VARCHAR(50)           DEFAULT NULL,
  `dispense_date`        DATETIME              DEFAULT NULL,
  `apply_user_id`        INT(11)               DEFAULT NULL,
  `s_person`             VARCHAR(50)           DEFAULT NULL,
  `s_reason`             LONGTEXT,
  `s_date`               DATETIME              DEFAULT NULL,
  `plan_callback_reason` LONGTEXT,
  `plan_callback_date`   DATETIME              DEFAULT NULL,
  `cur_link_flag`        CHAR(1)               DEFAULT NULL,
  `cur_buy_flag`         CHAR(1)               DEFAULT NULL,
  `freeze_leave_day`     INT(11)               DEFAULT NULL,
  `custom1`              VARCHAR(100)          DEFAULT NULL,
  `custom2`              VARCHAR(100)          DEFAULT NULL,
  `custom3`              VARCHAR(100)          DEFAULT NULL,
  `custom4`              VARCHAR(100)          DEFAULT NULL,
  `choice1`              VARCHAR(100)          DEFAULT NULL,
  `choice2`              VARCHAR(100)          DEFAULT NULL,
  `choice3`              VARCHAR(100)          DEFAULT NULL,
  `choice4`              VARCHAR(100)          DEFAULT NULL,
  `time1`                DATETIME              DEFAULT NULL,
  `time2`                DATETIME              DEFAULT NULL,
  `share_flag`           CHAR(1)               DEFAULT NULL,
  `share_ids`            LONGTEXT,
  `quality`              VARCHAR(100)          DEFAULT NULL,
  `owner_usr`            INT(11)               DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1BADD0A1A16E2733` (`owner_usr`),
  CONSTRAINT `FK1BADD0A1A16E2733` FOREIGN KEY (`owner_usr`) REFERENCES `s_user` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of c_company
-- ----------------------------
INSERT INTO `c_company` VALUES
  ('1', '移动', NULL, NULL, '一级', NULL, 'aa', 'aaa', NULL, NULL, NULL, NULL, NULL, NULL, '13333333', NULL, NULL,
                                                                     'test0@163.com', NULL, NULL, NULL, NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
    NULL, NULL, NULL, NULL, NULL, '2016-12-17 00:00:00', NULL, NULL, '2016-07-01 15:12:49', NULL, NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
   NULL, '1', NULL, 'aaa', '3');
INSERT INTO `c_company` VALUES
  ('2', 'test1', NULL, NULL, 'bbb2', NULL, 'bbb3', 'bbb4', NULL, NULL, NULL, NULL, NULL, NULL, '232432153', NULL, NULL,
                                                                             'test1@163.com', NULL, NULL, NULL, NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
    NULL, NULL, NULL, NULL, NULL, '2016-12-01 00:00:00', NULL, NULL, '2016-07-01 15:46:53', NULL, NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
   NULL, '1', NULL, 'bbb', '3');
INSERT INTO `c_company` VALUES
  ('3', 'test2', NULL, NULL, 'ccc2', NULL, 'ccc3', 'ccc4', NULL, NULL, NULL, NULL, NULL, NULL, '245672345', NULL, NULL,
                                                                             'test2@163.com', NULL, NULL, NULL, NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
    NULL, NULL, NULL, NULL, NULL, '2016-12-01 00:00:00', NULL, NULL, '2016-06-08 15:47:01', NULL, NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                  NULL, NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
                                                                                                        NULL, NULL,
   NULL, '1', NULL, 'ccc', '3');
INSERT INTO `c_company` VALUES
  ('4', 'test3', NULL, NULL, 'ddd2', NULL, 'ddd3', 'ddd4', NULL, NULL, NULL, NULL, NULL, NULL, '23456', NULL, NULL,
                                                                             'test3@163.com', NULL, NULL, NULL, NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-08-10 15:47:08', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                 NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
   NULL, '1', NULL, 'ddd', NULL);
INSERT INTO `c_company` VALUES
  ('5', 'test4', NULL, NULL, 'eee2', NULL, 'eee3', 'eee4', NULL, NULL, NULL, NULL, NULL, NULL, '23456', NULL, NULL,
                                                                             'test4@163.com', NULL, NULL, NULL, NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-07-12 15:47:13', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                 NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
   NULL, NULL, NULL, 'eee', NULL);
INSERT INTO `c_company` VALUES
  ('6', 'test5', NULL, NULL, 'fff2', NULL, 'fff3', 'fff4', NULL, NULL, NULL, NULL, NULL, NULL, '56789', NULL, NULL,
                                                                             'test5@163.com', NULL, NULL, NULL, NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
                                                                                                                NULL,
    NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-07-09 15:47:16', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                 NULL, NULL, NULL, NULL, NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
                                                                                                         NULL, NULL,
   NULL, NULL, NULL, 'ffff', NULL);

-- ----------------------------
-- Table structure for c_company_linkman
-- ----------------------------
DROP TABLE IF EXISTS `c_company_linkman`;
CREATE TABLE `c_company_linkman` (
  `id`          INT(11)      NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(100) NOT NULL,
  `pycode`      VARCHAR(50)           DEFAULT NULL,
  `code`        VARCHAR(100)          DEFAULT NULL,
  `sex`         VARCHAR(10)           DEFAULT NULL,
  `birthday`    DATE                  DEFAULT NULL,
  `department`  VARCHAR(100)          DEFAULT NULL,
  `duty`        VARCHAR(100)          DEFAULT NULL,
  `office_tel`  VARCHAR(50)           DEFAULT NULL,
  `home_tel`    VARCHAR(50)           DEFAULT NULL,
  `mobile`      VARCHAR(50)           DEFAULT NULL,
  `email`       VARCHAR(100)          DEFAULT NULL,
  `qq_num`      VARCHAR(50)           DEFAULT NULL,
  `qq_name`     VARCHAR(50)           DEFAULT NULL,
  `postcode`    VARCHAR(50)           DEFAULT NULL,
  `address`     VARCHAR(200)          DEFAULT NULL,
  `fax`         VARCHAR(50)           DEFAULT NULL,
  `other_link`  VARCHAR(200)          DEFAULT NULL,
  `hobby`       VARCHAR(200)          DEFAULT NULL,
  `taboo`       VARCHAR(200)          DEFAULT NULL,
  `main_flag`   CHAR(1)               DEFAULT NULL,
  `creater`     VARCHAR(50)           DEFAULT NULL,
  `create_time` DATETIME              DEFAULT NULL,
  `updater`     VARCHAR(50)           DEFAULT NULL,
  `update_time` DATETIME              DEFAULT NULL,
  `remark`      LONGTEXT,
  `custom1`     VARCHAR(100)          DEFAULT NULL,
  `custom2`     VARCHAR(100)          DEFAULT NULL,
  `custom3`     VARCHAR(100)          DEFAULT NULL,
  `custom4`     VARCHAR(100)          DEFAULT NULL,
  `choice1`     VARCHAR(100)          DEFAULT NULL,
  `choice2`     VARCHAR(100)          DEFAULT NULL,
  `choice3`     VARCHAR(100)          DEFAULT NULL,
  `choice4`     VARCHAR(100)          DEFAULT NULL,
  `time1`       DATETIME              DEFAULT NULL,
  `time2`       DATETIME              DEFAULT NULL,
  `m_type`      VARCHAR(10)           DEFAULT NULL,
  `share_flag`  CHAR(1)               DEFAULT NULL,
  `share_ids`   LONGTEXT,
  `c_id`        INT(11)               DEFAULT NULL,
  `owner_usr`   INT(11)               DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8F058182A16E2733` (`owner_usr`),
  KEY `FK8F058182E0637FA4` (`c_id`),
  CONSTRAINT `FK8F058182A16E2733` FOREIGN KEY (`owner_usr`) REFERENCES `s_user` (`id`),
  CONSTRAINT `FK8F058182E0637FA4` FOREIGN KEY (`c_id`) REFERENCES `c_company` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of c_company_linkman
-- ----------------------------

-- ----------------------------
-- Table structure for c_company_touch
-- ----------------------------
DROP TABLE IF EXISTS `c_company_touch`;
CREATE TABLE `c_company_touch` (
  `id`              INT(11) NOT NULL AUTO_INCREMENT,
  `c_id`            INT(11) NOT NULL,
  `link_man`        VARCHAR(50)      DEFAULT NULL,
  `link_fashion`    VARCHAR(100)     DEFAULT NULL,
  `link_type`       VARCHAR(100)     DEFAULT NULL,
  `link_time`       DATETIME         DEFAULT NULL,
  `content`         LONGTEXT,
  `user_name`       VARCHAR(50)      DEFAULT NULL,
  `next_touch_date` DATETIME         DEFAULT NULL,
  `next_touch_aim`  LONGTEXT,
  `creater`         VARCHAR(50)      DEFAULT NULL,
  `create_time`     DATETIME         DEFAULT NULL,
  `updater`         VARCHAR(50)      DEFAULT NULL,
  `update_time`     DATETIME         DEFAULT NULL,
  `remark`          LONGTEXT,
  `custom1`         VARCHAR(100)     DEFAULT NULL,
  `custom2`         VARCHAR(100)     DEFAULT NULL,
  `custom3`         VARCHAR(100)     DEFAULT NULL,
  `custom4`         VARCHAR(100)     DEFAULT NULL,
  `choice1`         VARCHAR(100)     DEFAULT NULL,
  `choice2`         VARCHAR(100)     DEFAULT NULL,
  `choice3`         VARCHAR(100)     DEFAULT NULL,
  `choice4`         VARCHAR(100)     DEFAULT NULL,
  `time1`           DATETIME         DEFAULT NULL,
  `time2`           DATETIME         DEFAULT NULL,
  `m_type`          VARCHAR(10)      DEFAULT NULL,
  `share_flag`      CHAR(1)          DEFAULT NULL,
  `share_ids`       LONGTEXT,
  `owner_usr`       INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE3905621A16E2733` (`owner_usr`),
  KEY `FKE3905621E0637FA4` (`c_id`),
  CONSTRAINT `FKE3905621A16E2733` FOREIGN KEY (`owner_usr`) REFERENCES `s_user` (`id`),
  CONSTRAINT `FKE3905621E0637FA4` FOREIGN KEY (`c_id`) REFERENCES `c_company` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of c_company_touch
-- ----------------------------

