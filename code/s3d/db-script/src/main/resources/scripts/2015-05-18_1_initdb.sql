
-- ----------------------------
-- Table structure for da_config_area
-- ----------------------------
DROP TABLE IF EXISTS `da_config_area`;
CREATE TABLE `da_config_area` (
  `fd_id` varchar(36) NOT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_config_category
-- ----------------------------
DROP TABLE IF EXISTS `da_config_category`;
CREATE TABLE `da_config_category` (
  `fd_id` varchar(36) NOT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_code` varchar(36) DEFAULT NULL,
  `fd_shortcut` varchar(10) DEFAULT NULL,
  `fd_exclusive` varchar(36) DEFAULT NULL,
  `fd_status` int(11) NOT NULL,
  `fd_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_config_doctor
-- ----------------------------
DROP TABLE IF EXISTS `da_config_doctor`;
CREATE TABLE `da_config_doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital_id` varchar(36) COLLATE utf8_bin NOT NULL,
  `department_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `position` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `shortcut` varchar(64) COLLATE utf8_bin NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0: inactive 1: active',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_da_config_doctor_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for da_config_operation
-- ----------------------------
DROP TABLE IF EXISTS `da_config_operation`;
CREATE TABLE `da_config_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(36) COLLATE utf8_bin NOT NULL,
  `name` varchar(128) COLLATE utf8_bin NOT NULL,
  `grade` int(11) NOT NULL,
  `hospital_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `shortcut` varchar(64) COLLATE utf8_bin NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0: inactive 1: active',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_da_config_operation_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for da_config_ptemplate
-- ----------------------------
DROP TABLE IF EXISTS `da_config_ptemplate`;
CREATE TABLE `da_config_ptemplate` (
  `fd_id` varchar(36) NOT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_version` int(11) NOT NULL,
  `fd_create_time` datetime NOT NULL,
  `fd_list_modi_time` datetime DEFAULT NULL,
  `fd_html_content` longtext,
  PRIMARY KEY (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_config_rule
-- ----------------------------
DROP TABLE IF EXISTS `da_config_rule`;
CREATE TABLE `da_config_rule` (
  `fd_id` varchar(36) NOT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_order` int(11) DEFAULT NULL,
  `fd_exclusive` varchar(36) DEFAULT NULL,
  `fd_keyword` varchar(36) DEFAULT NULL,
  `fd_is_regex` bit(1) DEFAULT NULL,
  `fd_status` int(11) NOT NULL,
  `fd_category_id` varchar(36) NOT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `FK763F1D175F7795A1` (`fd_category_id`),
  CONSTRAINT `FK763F1D175F7795A1` FOREIGN KEY (`fd_category_id`) REFERENCES `da_config_category` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_config_set
-- ----------------------------
DROP TABLE IF EXISTS `da_config_set`;
CREATE TABLE `da_config_set` (
  `fd_id` varchar(36) NOT NULL,
  `fd_type` varchar(36) DEFAULT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_code` varchar(36) DEFAULT NULL,
  `fd_shortcut` varchar(10) DEFAULT NULL,
  `fd_exclusive` varchar(36) DEFAULT NULL,
  `fd_status` int(11) NOT NULL,
  PRIMARY KEY (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_customer_hospital
-- ----------------------------
DROP TABLE IF EXISTS `da_customer_hospital`;
CREATE TABLE `da_customer_hospital` (
  `fd_id` varchar(36) NOT NULL,
  `fd_org_type` int(11) NOT NULL DEFAULT '1',
  `fd_code` varchar(36) DEFAULT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_description` varchar(1500) DEFAULT NULL,
  `doc_create_time` datetime DEFAULT NULL,
  `fd_alter_time` datetime DEFAULT NULL,
  `fd_hierarchy_id` varchar(1500) DEFAULT NULL,
  `fd_parent_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `FK86035A3941CF92F1` (`fd_parent_id`),
  CONSTRAINT `FK86035A3941CF92F1` FOREIGN KEY (`fd_parent_id`) REFERENCES `da_customer_hospital` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_customer_label
-- ----------------------------
DROP TABLE IF EXISTS `da_customer_label`;
CREATE TABLE `da_customer_label` (
  `fd_id` varchar(36) NOT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_create_time` datetime DEFAULT NULL,
  `fd_file_count` int(11) DEFAULT NULL,
  `fd_from` varchar(10) DEFAULT NULL,
  `fd_to` varchar(10) DEFAULT NULL,
  `fd_status` int(11) NOT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `FKD9B5BB558A9A0208` (`fd_id`),
  CONSTRAINT `FKD9B5BB558A9A0208` FOREIGN KEY (`fd_id`) REFERENCES `da_customer_hospital` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_customer_picture
-- ----------------------------
DROP TABLE IF EXISTS `da_customer_picture`;
CREATE TABLE `da_customer_picture` (
  `fd_id` varchar(36) NOT NULL,
  `fd_pic_name` varchar(200) NOT NULL,
  `fd_pic_path` varchar(100) DEFAULT NULL,
  `fd_pic_type` varchar(36) DEFAULT NULL,
  `fd_create_time` datetime DEFAULT NULL,
  `fd_last_modified_time` datetime NOT NULL,
  `fd_md5_hash` varchar(36) DEFAULT NULL,
  `fd_thumb` longblob,
  `fd_file_no` varchar(36) DEFAULT NULL,
  `fd_label_id` varchar(36) NOT NULL,
  `fd_category_id` varchar(36) DEFAULT NULL,
  `fd_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `FK2489051F5F7795A1` (`fd_category_id`),
  KEY `FK2489051FD53A7673` (`fd_label_id`),
  CONSTRAINT `FK2489051F5F7795A1` FOREIGN KEY (`fd_category_id`) REFERENCES `da_config_category` (`fd_id`),
  CONSTRAINT `FK2489051FD53A7673` FOREIGN KEY (`fd_label_id`) REFERENCES `da_customer_hospital` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_customer_project
-- ----------------------------
DROP TABLE IF EXISTS `da_customer_project`;
CREATE TABLE `da_customer_project` (
  `fd_id` varchar(36) NOT NULL,
  `fd_code` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `FK3488F33A7F76782D` (`fd_id`),
  CONSTRAINT `FK3488F33A7F76782D` FOREIGN KEY (`fd_id`) REFERENCES `da_customer_hospital` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for da_customer_shouye
-- ----------------------------
DROP TABLE IF EXISTS `da_customer_shouye`;
CREATE TABLE `da_customer_shouye` (
  `fd_id` varchar(36) NOT NULL,
  `fd_create_time` datetime DEFAULT NULL,
  `fd_last_modified_time` datetime NOT NULL,
  `fd_file_no` varchar(36) DEFAULT NULL,
  `fd_label_id` varchar(36) NOT NULL,
  `fd_picture_id` varchar(36) NOT NULL,
  `fd_template_id` varchar(36) NOT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `FK695C67068B2A1C41` (`fd_template_id`),
  KEY `FK695C670656D8D7F3` (`fd_picture_id`),
  KEY `FK695C6706D53A7673` (`fd_label_id`),
  CONSTRAINT `FK695C670656D8D7F3` FOREIGN KEY (`fd_picture_id`) REFERENCES `da_customer_picture` (`fd_id`),
  CONSTRAINT `FK695C67068B2A1C41` FOREIGN KEY (`fd_template_id`) REFERENCES `da_config_ptemplate` (`fd_id`),
  CONSTRAINT `FK695C6706D53A7673` FOREIGN KEY (`fd_label_id`) REFERENCES `da_customer_hospital` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_auth_element
-- ----------------------------
DROP TABLE IF EXISTS `hr_auth_element`;
CREATE TABLE `hr_auth_element` (
  `fd_id` varchar(36) NOT NULL,
  `fd_org_type` int(11) NOT NULL,
  `fd_name` varchar(200) NOT NULL,
  `fd_is_available` bit(1) DEFAULT NULL,
  `fd_hierarchy_id` varchar(1500) DEFAULT NULL,
  `fd_create_time` datetime DEFAULT NULL,
  `fd_alter_time` datetime DEFAULT NULL,
  `fd_parent_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`fd_id`),
  KEY `FKA5E2D87AF2BA56DD` (`fd_parent_id`),
  CONSTRAINT `FKA5E2D87AF2BA56DD` FOREIGN KEY (`fd_parent_id`) REFERENCES `hr_auth_element` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `hr_auth_role`;
CREATE TABLE `hr_auth_role` (
  `fd_id` varchar(36) NOT NULL,
  `fd_name` varchar(100) NOT NULL,
  `fd_alias` varchar(100) DEFAULT NULL,
  `fd_description` varchar(1000) DEFAULT NULL,
  `fd_module_path` varchar(100) DEFAULT NULL,
  `fd_is_sys_role` bit(1) NOT NULL,
  PRIMARY KEY (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_auth_rra
-- ----------------------------
DROP TABLE IF EXISTS `hr_auth_rra`;
CREATE TABLE `hr_auth_rra` (
  `fd_roleid` varchar(36) NOT NULL,
  `fd_inhroleid` varchar(36) NOT NULL,
  KEY `FKA065E29FBBEF73B3` (`fd_inhroleid`),
  KEY `FKA065E29F32DF9EF2` (`fd_roleid`),
  CONSTRAINT `FKA065E29F32DF9EF2` FOREIGN KEY (`fd_roleid`) REFERENCES `hr_auth_role` (`fd_id`),
  CONSTRAINT `FKA065E29FBBEF73B3` FOREIGN KEY (`fd_inhroleid`) REFERENCES `hr_auth_role` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_auth_ura
-- ----------------------------
DROP TABLE IF EXISTS `hr_auth_ura`;
CREATE TABLE `hr_auth_ura` (
  `fd_roleid` varchar(36) NOT NULL,
  `fd_orgelementid` varchar(36) NOT NULL,
  KEY `FKA065EDE232DF9EF2` (`fd_roleid`),
  KEY `FKA065EDE2FEA5A4E2` (`fd_orgelementid`),
  CONSTRAINT `FKA065EDE232DF9EF2` FOREIGN KEY (`fd_roleid`) REFERENCES `hr_auth_role` (`fd_id`),
  CONSTRAINT `FKA065EDE2FEA5A4E2` FOREIGN KEY (`fd_orgelementid`) REFERENCES `hr_auth_element` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_auth_users
-- ----------------------------
DROP TABLE IF EXISTS `hr_auth_users`;
CREATE TABLE `hr_auth_users` (
  `user_id` varchar(36) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `user_password` varchar(254) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `user_phone` varchar(32) DEFAULT NULL,
  `user_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK1EA28F06F5CB6477` (`user_id`),
  CONSTRAINT `FK1EA28F06F5CB6477` FOREIGN KEY (`user_id`) REFERENCES `hr_auth_element` (`fd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------