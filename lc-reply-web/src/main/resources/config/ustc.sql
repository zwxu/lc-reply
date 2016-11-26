/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : ustc

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-11-26 17:36:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` int(11) NOT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rid` int(10) DEFAULT '3',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES ('1', 'haha', '123456', '3', '2016-09-22 17:15:27');
INSERT INTO `t_account` VALUES ('2', 'sss', '123456', '3', '2016-09-22 17:15:27');
INSERT INTO `t_account` VALUES ('3', 'sss', 'haha', '3', '2016-09-23 18:12:00');
INSERT INTO `t_account` VALUES ('4', 'sss', 'haha', '3', '2016-09-23 18:12:00');
INSERT INTO `t_account` VALUES ('5', 'sss', 'haha', '3', '2016-09-23 18:12:00');
INSERT INTO `t_account` VALUES ('6', 'sss', 'haha', '3', '2016-09-23 18:12:00');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '学生列表', '/userList', '1', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `gmt_created` datetime NOT NULL,
  `gmt_modify` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '管理员', '2016-11-23 14:04:52', '2016-11-23 14:04:56');
INSERT INTO `t_role` VALUES ('2', 'teacher', '答辩老师', '2016-11-23 14:05:17', '2016-11-23 14:05:20');
INSERT INTO `t_role` VALUES ('3', 'student', '答辩学生', '2016-11-23 14:05:39', '2016-11-23 14:05:43');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `groupid` int(10) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `pass_count` int(10) DEFAULT NULL,
  `reject_count` int(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '张三', '软件学院', 'SA16001', null, '1', null, null, null, '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('2', '李四', '软件学院', 'SA16002', null, '2', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('3', '王五', '软件学院', 'SA16003', null, '3', null, null, '', '2016-09-23 18:12:00');
INSERT INTO `t_student` VALUES ('4', '刘翔', '软件学院', 'SA16004', null, '4', null, null, '', '2016-09-23 18:12:00');
INSERT INTO `t_student` VALUES ('5', '孙杨', '软件学院', 'SA16005', null, '5', null, null, '', '2016-09-23 18:12:00');
INSERT INTO `t_student` VALUES ('6', '宁泽涛', '软件学院', 'SA16006', null, '6', null, null, '', '2016-09-23 18:12:00');
INSERT INTO `t_student` VALUES ('7', '科比', '软件学院', 'SA16007', null, '7', null, null, null, '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('8', '麦蒂', '软件学院', 'SA16008', null, '8', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('9', '姚明', '软件学院', 'SA16009', null, '9', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('10', '易建联', '软件学院', 'SA16010', null, '10', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('11', '林书豪', '软件学院', 'SA16011', null, '11', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('12', '林丹', '软件学院', 'SA16012', null, '12', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('13', '邓超', '软件学院', 'SA16013', null, '13', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('14', '李晨', '软件学院', 'SA16014', null, '14', null, null, '', '2016-09-22 17:15:27');
INSERT INTO `t_student` VALUES ('15', '杨颖', '软件学院', 'SA16015', null, '15', null, null, '', '2016-09-22 17:15:27');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `deparment` varchar(255) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '管理员1', '教学部', null, '2016-11-24 10:45:01');
INSERT INTO `t_teacher` VALUES ('2', '老师1', '计算机学院', null, '2016-11-24 10:45:24');
