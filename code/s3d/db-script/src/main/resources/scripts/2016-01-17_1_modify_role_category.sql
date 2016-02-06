 ALTER TABLE `auth_role_category`
CHANGE COLUMN `desc` `remark`  VARCHAR(50) NULL DEFAULT NULL AFTER `name`;
