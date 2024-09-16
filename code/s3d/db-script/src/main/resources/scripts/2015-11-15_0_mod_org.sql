ALTER TABLE `auth_org`
CHANGE COLUMN `desc` `remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL AFTER `name`,
ADD COLUMN `pos`  int NULL AFTER `status`;
