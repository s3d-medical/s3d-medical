/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : medical

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2015-11-03 22:20:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_action
-- ----------------------------
DROP TABLE IF EXISTS `auth_action`;
CREATE TABLE `auth_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `module_no` varchar(20) COLLATE utf8_bin DEFAULT '',
  `page_no` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `state` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_code_module
-- ----------------------------
DROP TABLE IF EXISTS `auth_code_module`;
CREATE TABLE `auth_code_module` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'module name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_code_page
-- ----------------------------
DROP TABLE IF EXISTS `auth_code_page`;
CREATE TABLE `auth_code_page` (
  `id` int(11) NOT NULL,
  `desc` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'page name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `desc` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_org
-- ----------------------------
DROP TABLE IF EXISTS `auth_org`;
CREATE TABLE `auth_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `desc` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `auth_parent_org_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_query` (`code`),
  KEY `fk_auth_org_auth_org1_idx` (`auth_parent_org_id`),
  CONSTRAINT `fk_auth_org_auth_org1` FOREIGN KEY (`auth_parent_org_id`) REFERENCES `auth_org` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `desc` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `state` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_query` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_role_action
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_action`;
CREATE TABLE `auth_role_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `updator_id` int(11) DEFAULT NULL,
  `auth_action_id` int(11) NOT NULL,
  `auth_role_id` mediumint(9) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auth_role_action_auth_action1_idx` (`auth_action_id`),
  KEY `fk_auth_role_action_auth_role1_idx` (`auth_role_id`),
  CONSTRAINT `fk_auth_role_action_auth_action1` FOREIGN KEY (`auth_action_id`) REFERENCES `auth_action` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_auth_role_action_auth_role1` FOREIGN KEY (`auth_role_id`) REFERENCES `auth_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `registered_time` datetime DEFAULT NULL COMMENT 'registered time',
  `last_login_time` datetime DEFAULT NULL COMMENT 'last login time',
  `state` tinyint(4) DEFAULT '1',
  `auth_org_id` int(11) NOT NULL COMMENT 'org belonged',
  PRIMARY KEY (`id`),
  KEY `fk_auth_user_auth_org1_idx` (`auth_org_id`),
  CONSTRAINT `fk_auth_user_auth_org1` FOREIGN KEY (`auth_org_id`) REFERENCES `auth_org` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_user_action
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_action`;
CREATE TABLE `auth_user_action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT NULL,
  `auth_user_id` int(11) NOT NULL,
  `auth_action_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auth_user_action_auth_user1_idx` (`auth_user_id`),
  KEY `fk_auth_user_action_auth_action1_idx` (`auth_action_id`),
  CONSTRAINT `fk_auth_user_action_auth_action1` FOREIGN KEY (`auth_action_id`) REFERENCES `auth_action` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_auth_user_action_auth_user1` FOREIGN KEY (`auth_user_id`) REFERENCES `auth_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `auth_user_id` int(11) NOT NULL,
  `auth_role_id` mediumint(9) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auth_user_role_auth_user1_idx` (`auth_user_id`),
  KEY `fk_auth_user_role_auth_role1_idx` (`auth_role_id`),
  CONSTRAINT `fk_auth_user_role_auth_role1` FOREIGN KEY (`auth_role_id`) REFERENCES `auth_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_auth_user_role_auth_user1` FOREIGN KEY (`auth_user_id`) REFERENCES `auth_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
