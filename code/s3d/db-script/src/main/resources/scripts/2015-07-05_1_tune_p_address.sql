ALTER TABLE `p_address`
MODIFY COLUMN `province`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER `address_type`,
MODIFY COLUMN `city`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER `province`,
MODIFY COLUMN `county`  varchar(60) NULL DEFAULT NULL AFTER `city`;