/*
Navicat MySQL Data Transfer

Source Server         : 阿里云MySQL
Source Server Version : 50720
Source Host           : rm-wz9jezta3ntmwg02dso.mysql.rds.aliyuncs.com:3306
Source Database       : spring_boot_project

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-11-11 11:43:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for l_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `l_role_resource`;
CREATE TABLE `l_role_resource` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `resource_id` varchar(32) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Records of l_role_resource
-- ----------------------------
INSERT INTO `l_role_resource` VALUES ('1', '1', '1');
INSERT INTO `l_role_resource` VALUES ('2', '1', '2');

-- ----------------------------
-- Table structure for l_user_role
-- ----------------------------
DROP TABLE IF EXISTS `l_user_role`;
CREATE TABLE `l_user_role` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of l_user_role
-- ----------------------------
INSERT INTO `l_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for t_resources
-- ----------------------------
DROP TABLE IF EXISTS `t_resources`;
CREATE TABLE `t_resources` (
  `resource_id` varchar(32) NOT NULL COMMENT '资源ID(UUID)',
  `resource_code` varchar(50) DEFAULT NULL COMMENT '资源代码',
  `resource_name` varchar(50) DEFAULT NULL COMMENT '资源名',
  `resource_url` varchar(255) DEFAULT NULL COMMENT '资源URL',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_person` varchar(50) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_person` varchar(50) DEFAULT NULL COMMENT '更新人',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of t_resources
-- ----------------------------
INSERT INTO `t_resources` VALUES ('1', 'UserIndex', '个人中心', '/user/index.html', '2019-11-03 22:29:09', 'system', '2019-11-03 22:29:15', 'system', '1');
INSERT INTO `t_resources` VALUES ('2', 'BookList', '图书列表', '/book/list', '2019-11-03 22:29:51', 'system', null, null, '1');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` varchar(32) NOT NULL COMMENT '角色ID(UUID)',
  `role_code` varchar(100) NOT NULL COMMENT '角色编码(如:admin)',
  `role_name` varchar(50) NOT NULL COMMENT '角色名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_person` varchar(50) NOT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_person` varchar(50) DEFAULT NULL COMMENT '更新人',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'ADMIN', '管理员', '2019-11-03 22:28:29', 'system', null, null, '1');

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID(UUID)',
  `login_name` varchar(50) NOT NULL COMMENT '登录名',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `user_status` int(2) NOT NULL DEFAULT '1' COMMENT '用户状态(1-正常,99-删除)',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '上次更新时间',
  `last_update_person` varchar(50) DEFAULT NULL COMMENT '上次更新人',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_system_user
-- ----------------------------
INSERT INTO `t_system_user` VALUES ('1', 'admin', '管理员', '$2a$10$xYvtiDFW8OlvBe8RGTWWoeksYWQotKqwq2XtaPByiA4rBusuGdbWG', '1', '2019-11-03 22:27:25', '2019-11-03 22:27:29', '2019-11-03 22:27:32', 'admin', '1');

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL COMMENT '测试文字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('1', '测试内容1');
INSERT INTO `t_test` VALUES ('2', '测试内容2');
INSERT INTO `t_test` VALUES ('3', '测试内容3');
INSERT INTO `t_test` VALUES ('4', '测试内容4');
