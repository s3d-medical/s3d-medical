SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for da_config_place
-- ----------------------------
DROP TABLE IF EXISTS `da_config_operation`;
CREATE TABLE medical.da_config_operation (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(36) NOT NULL,
  `name` varchar(128) NOT NULL,
  `grade` int NOT NULL,
  `hospital_id` VARCHAR(36) NULL,
  `shortcut` varchar(64) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '0: inactive 1: active',
  PRIMARY KEY (id),
  UNIQUE INDEX UK_da_config_operation_id (id)
) ENGINE = INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
