SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for da_config_place
-- ----------------------------
DROP TABLE IF EXISTS `da_config_doctor`;
CREATE TABLE medical.da_config_doctor (
  `id` int NOT NULL AUTO_INCREMENT,
  `hospital_id` VARCHAR(36) NOT NULL,
  `department_id` VARCHAR(36) NULL,
  `position` VARCHAR(36) NULL,
  `name` varchar(128) NOT NULL,
  `shortcut` varchar(64) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '0: inactive 1: active',
  PRIMARY KEY (id),
  UNIQUE INDEX UK_da_config_doctor_id (id)
) ENGINE = INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
