/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : rixin

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2019-05-09 10:02:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_area_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_area_info`;
CREATE TABLE `sys_area_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '地区ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `sname` varchar(255) NOT NULL COMMENT '简称',
  `pId` int(11) NOT NULL DEFAULT '0' COMMENT '父级ID',
  `level` tinyint(1) NOT NULL DEFAULT '0' COMMENT '层级 1: 省 2: 市 3: 区 4: 镇',
  `sort` int(11) NOT NULL COMMENT '排序',
  `status` tinyint(1) NOT NULL COMMENT '状态 0: 有效 1: 无效',
  `longitude` double(10,7) DEFAULT NULL COMMENT '经度',
  `latitude` double(10,7) DEFAULT NULL COMMENT '纬度',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='地区表';

-- ----------------------------
-- Records of sys_area_info
-- ----------------------------
INSERT INTO `sys_area_info` VALUES ('1', 's', 's', '0', '0', '1', '127', null, null, '2019-03-31 13:31:03', '2019-03-31 13:31:40');

-- ----------------------------
-- Table structure for `sys_category_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_category_info`;
CREATE TABLE `sys_category_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `level` tinyint(1) NOT NULL DEFAULT '1' COMMENT '等级 1: 一级分类 2: 二级分类',
  `parent` int(11) NOT NULL DEFAULT '0' COMMENT '父分类ID',
  `path` varchar(255) NOT NULL COMMENT '路径',
  `image` varchar(255) DEFAULT NULL COMMENT '图标',
  `fullName` varchar(255) NOT NULL COMMENT '分类全称',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0: 有效 1: 无效',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of sys_category_info
-- ----------------------------
INSERT INTO `sys_category_info` VALUES ('1', '家庭保洁', '1', '0', '', '', '', '1', '2019-03-17 16:31:11', '2019-03-17 16:40:33');
INSERT INTO `sys_category_info` VALUES ('2', '衣物清洗', '1', '0', '', '', '', '1', '2019-03-17 16:31:28', '2019-03-17 16:40:45');
INSERT INTO `sys_category_info` VALUES ('3', '洗衣', '2', '2', '', '', '', '1', '2019-03-17 16:35:12', '2019-03-17 16:35:15');
INSERT INTO `sys_category_info` VALUES ('4', '洗鞋', '2', '2', '', '', '', '1', '2019-03-17 16:35:36', '2019-03-17 16:35:40');
INSERT INTO `sys_category_info` VALUES ('5', '洗家纺', '2', '2', '', '', '', '1', '2019-03-17 16:36:19', '2019-03-17 16:36:21');

-- ----------------------------
-- Table structure for `sys_dept_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_info`;
CREATE TABLE `sys_dept_info` (
  `id` int(4) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '部门名称',
  `pId` int(11) NOT NULL DEFAULT '0' COMMENT '父级部门ID',
  `path` varchar(255) NOT NULL COMMENT '部门全路径',
  `level` tinyint(1) NOT NULL COMMENT '层级 0: 集团 1: 一级部门 2: 二级部门 3: 三级部门',
  `sort` int(11) NOT NULL COMMENT '排序',
  `isLeaf` tinyint(1) NOT NULL DEFAULT '0' COMMENT '叶子节点 0: 否 1: 是',
  `fullName` varchar(255) NOT NULL COMMENT '部门全称',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12345679 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept_info
-- ----------------------------
INSERT INTO `sys_dept_info` VALUES ('12345678', 'aa', '0', '2', '1', '0', '0', 'test', '2019-03-25 14:58:25', '2019-03-25 15:12:54');

-- ----------------------------
-- Table structure for `sys_item_comment`
-- ----------------------------
DROP TABLE IF EXISTS `sys_item_comment`;
CREATE TABLE `sys_item_comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `itemId` int(11) NOT NULL COMMENT '商品ID',
  `itemName` varchar(255) NOT NULL COMMENT '商品名称',
  `loginName` varchar(255) NOT NULL COMMENT '登录名',
  `head` varchar(255) NOT NULL COMMENT '头像',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `score` tinyint(4) NOT NULL COMMENT '评分',
  `comment` varchar(1024) NOT NULL COMMENT '评论',
  `images` text COMMENT '晒单',
  `pId` int(11) NOT NULL DEFAULT '0' COMMENT '父级评论ID',
  `level` tinyint(4) NOT NULL DEFAULT '0' COMMENT '深度 0: 商品评论 1: 回复评论',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`),
  KEY `idx_itemId` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品评论表';

-- ----------------------------
-- Records of sys_item_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_item_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_item_info`;
CREATE TABLE `sys_item_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `image` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `introduce` varchar(1024) NOT NULL COMMENT '介绍',
  `prices` double(11,2) NOT NULL COMMENT '价格',
  `discount` double(11,2) DEFAULT NULL COMMENT '折扣价',
  `catId` int(11) NOT NULL COMMENT '分类ID',
  `catPath` varchar(255) NOT NULL COMMENT '分类路径',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单品表';

-- ----------------------------
-- Records of sys_item_info
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_order_complain`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_complain`;
CREATE TABLE `sys_order_complain` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单售后表';

-- ----------------------------
-- Records of sys_order_complain
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_detail`;
CREATE TABLE `sys_order_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `orderNo` varchar(20) NOT NULL COMMENT '订单号',
  `itemId` varchar(255) NOT NULL COMMENT '商品ID',
  `itemName` varchar(255) NOT NULL COMMENT '商品名称',
  `itemImage` varchar(255) NOT NULL COMMENT '图片地址',
  `number` int(11) NOT NULL COMMENT '数量',
  `price` double(11,2) NOT NULL COMMENT '原价',
  `discount` double(11,2) NOT NULL COMMENT '折扣价',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`),
  KEY `idx_orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Records of sys_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_order_flow`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_flow`;
CREATE TABLE `sys_order_flow` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `orderNo` varchar(20) NOT NULL COMMENT '订单编号',
  `operator` varchar(255) NOT NULL COMMENT '操作人',
  `mobile` varchar(255) NOT NULL COMMENT '手机号',
  `status` tinyint(1) NOT NULL COMMENT '状态 -1: 订单取消 0: 用户下单 1: 完成支付 2: 订单完成 3: 完成取件',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单流程表';

-- ----------------------------
-- Records of sys_order_flow
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_order_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_info`;
CREATE TABLE `sys_order_info` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `openid` varchar(255) NOT NULL COMMENT 'openid',
  `fullName` varchar(255) NOT NULL COMMENT '用户名',
  `orderName` varchar(255) NOT NULL COMMENT '订单名称',
  `orderTime` datetime NOT NULL COMMENT '预约时间',
  `prices` double(11,2) NOT NULL COMMENT '原价',
  `discount` double(11,2) NOT NULL COMMENT '折扣价',
  `payWay` tinyint(1) DEFAULT NULL COMMENT '支付方式 0: 微信 1: 余额',
  `payment` double(11,2) DEFAULT NULL COMMENT '支付金额',
  `address` varchar(255) NOT NULL COMMENT '服务地址',
  `comment` varchar(511) DEFAULT NULL COMMENT '用户备注',
  `mobile` varchar(255) NOT NULL COMMENT '手机号',
  `status` tinyint(1) NOT NULL COMMENT '服务状态 -1: 订单取消 0: 完成下单 1: 完成支付 2: 订单完成 3: 服务中',
  `createTime` datetime NOT NULL COMMENT '创建日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单主表';

-- ----------------------------
-- Records of sys_order_info
-- ----------------------------
INSERT INTO `sys_order_info` VALUES ('00000000001', 'o-EdD5t-mIJ7GiQ-osvqB0MK3CFI', '戴然', '洗衣', '2019-05-04 18:19:18', '125.00', '125.00', null, null, '宿迁 宿城区 恒大华府 1207', null, '18610875668', '0', '2019-05-04 18:19:18', '2019-05-04 18:19:19');
INSERT INTO `sys_order_info` VALUES ('00000000002', 'o-EdD5t-mIJ7GiQ-osvqB0MK3CFI', '树先生', '洗衣', '2019-05-04 19:57:48', '125.00', '125.00', null, null, '宿迁 宿城区 恒大华府 1207', null, '18610875668', '0', '2019-05-04 19:57:48', '2019-05-04 19:57:48');

-- ----------------------------
-- Table structure for `sys_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '角色名',
  `status` tinyint(1) NOT NULL COMMENT '状态 0: 可用 1: 禁用',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职务表';

-- ----------------------------
-- Records of sys_role_info
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_address`;
CREATE TABLE `sys_user_address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `openid` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL COMMENT '登录名',
  `sex` int(11) NOT NULL COMMENT '性别 0: 未知 1: 男性 2: 女性',
  `mobile` varchar(255) NOT NULL COMMENT '手机号',
  `city` varchar(255) NOT NULL COMMENT '市',
  `district` varchar(255) NOT NULL COMMENT '区',
  `community` varchar(255) NOT NULL COMMENT '镇',
  `detail` varchar(255) NOT NULL COMMENT '详细地址',
  `isDefault` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否默认地址 0: 是 1: 否',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`),
  KEY `idx_loginName` (`fullName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户地址表';

-- ----------------------------
-- Records of sys_user_address
-- ----------------------------
INSERT INTO `sys_user_address` VALUES ('1', 'o-EdD5t-mIJ7GiQ-osvqB0MK3CFI', '戴然', '1', '18610875668', '宿迁', '宿城区', '恒大华府', '1207', '0', '2019-05-04 14:08:07', '2019-05-04 14:46:31');
INSERT INTO `sys_user_address` VALUES ('2', 'o-EdD5t-mIJ7GiQ-osvqB0MK3CFI', '戴然', '1', '18610875668', '宿迁', '宿城区', '恒大华府', '1207', '0', '2019-05-04 14:11:01', '2019-05-04 14:46:33');
INSERT INTO `sys_user_address` VALUES ('3', 'o-EdD5t-mIJ7GiQ-osvqB0MK3CFI', '树先生', '1', '18610875668', '宿迁', '宿城区', '恒大华府', '1207', '0', '2019-05-04 14:55:36', '2019-05-04 19:34:48');

-- ----------------------------
-- Table structure for `sys_user_balance`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_balance`;
CREATE TABLE `sys_user_balance` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户余额表';

-- ----------------------------
-- Records of sys_user_balance
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_coupon`;
CREATE TABLE `sys_user_coupon` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户优惠券表';

-- ----------------------------
-- Records of sys_user_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `id` int(6) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `realname` varchar(255) NOT NULL COMMENT '真实姓名',
  `sex` tinyint(1) NOT NULL COMMENT '性别 0: 女 1: 男',
  `email` varchar(255) NOT NULL COMMENT '邮箱地址',
  `mobile` varchar(255) NOT NULL COMMENT '手机号',
  `idCard` varchar(255) NOT NULL COMMENT '身份证号码',
  `image` varchar(255) NOT NULL COMMENT '头像地址',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `roleName` varchar(255) NOT NULL COMMENT '角色名称',
  `deptId` int(11) NOT NULL COMMENT '部门ID',
  `deptName` varchar(255) NOT NULL COMMENT '部门名称',
  `deptPath` varchar(255) NOT NULL COMMENT '部门全路径',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0: 正常 1: 异常',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`) USING BTREE,
  UNIQUE KEY `uniq_mobile` (`mobile`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_login`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_login`;
CREATE TABLE `sys_user_login` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nickName` varchar(255) NOT NULL COMMENT '昵称',
  `loginName` varchar(255) NOT NULL COMMENT '登录名',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NOT NULL COMMENT '状态 0: 正常 1: 异常',
  `createTime` datetime NOT NULL COMMENT '修改日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_loginName` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录表';

-- ----------------------------
-- Records of sys_user_login
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `wx_access_token`;
CREATE TABLE `wx_access_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `access_token` varchar(600) NOT NULL COMMENT '凭证密钥',
  `expires_in` int(11) NOT NULL COMMENT '凭证有效日期',
  `appId` varchar(255) NOT NULL COMMENT '应用ID',
  `appSecret` varchar(255) NOT NULL COMMENT '应用密码',
  `createTime` datetime NOT NULL COMMENT '添加日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`),
  KEY `idx_app` (`appId`,`appSecret`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='微信凭证表';

-- ----------------------------
-- Records of wx_access_token
-- ----------------------------
INSERT INTO `wx_access_token` VALUES ('1', '21_7xCV-_snIbs-DqQWX6bhZarWQmFU8jgXPqBe4nRM6yY-VjVrsQmVC0ae_y7_7GGkTFmEQv2vDir713pK4zcM-gCqu-NwwCoS4lHxvkU_OJvV9T4Var_w27IzCvbpUzLG_YSf83RZUoKMbsjwEYUdAJAPJF', '7200', 'wx6dee7e3164702a51', '46475e840293c5ad9773a748c267ae13', '2019-05-01 13:50:43', '2019-05-01 13:50:42');

-- ----------------------------
-- Table structure for `wx_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `wx_user_info`;
CREATE TABLE `wx_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `openid` varchar(255) NOT NULL COMMENT '用户标识',
  `unionid` varchar(255) DEFAULT NULL COMMENT '用户标识',
  `nickname` varchar(255) NOT NULL COMMENT '用户昵称',
  `sex` int(11) NOT NULL COMMENT '性别 0: 未知 1: 男性 2: 女性',
  `headimgurl` varchar(600) DEFAULT NULL COMMENT '头像',
  `country` varchar(255) DEFAULT NULL COMMENT '所在国家',
  `province` varchar(255) DEFAULT NULL COMMENT '所在省份',
  `city` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `language` varchar(255) DEFAULT NULL COMMENT '所用语言',
  `groupid` int(11) DEFAULT NULL COMMENT '所在分组ID',
  `tagid_list` varchar(255) DEFAULT NULL COMMENT '标签ID列表',
  `remark` varchar(600) DEFAULT NULL COMMENT '备注',
  `subscribe` int(11) DEFAULT NULL COMMENT '是否关注 0: 没有 1: 有',
  `subscribe_time` datetime DEFAULT NULL COMMENT '关注日期',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_openid` (`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='微信用户信息表';

-- ----------------------------
-- Records of wx_user_info
-- ----------------------------
INSERT INTO `wx_user_info` VALUES ('1', 'o-EdD5t-mIJ7GiQ-osvqB0MK3CFI', null, 'Monkey.Dai', '1', 'http://thirdwx.qlogo.cn/mmopen/l5b2pZI5g4R9mib69BgoQ8Kvfl3V7oKytmeXiaaKqsEuRibKyMVUd6Jz5AK9XmueT9HRBciaBM5jKpr2K1zMu1kxrd3QOIWQaqUo/132', '中国', '北京', '通州', 'zh_CN', '0', null, '', '1', '2019-04-21 15:45:16', '2019-04-21 20:28:18');
