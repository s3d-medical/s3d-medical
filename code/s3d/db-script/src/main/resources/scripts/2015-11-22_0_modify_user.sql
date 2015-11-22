ALTER TABLE `auth_user`
ADD COLUMN `full_name`  varchar(30) NULL AFTER `auth_org_id`,
ADD COLUMN `code`  varchar(30) NULL AFTER `full_name`,
ADD COLUMN `email`  varchar(40) NULL AFTER `code`,
ADD COLUMN `phone`  varchar(30) NULL AFTER `email`,
ADD COLUMN `tel`  varchar(30) NULL AFTER `phone`,
ADD COLUMN `key`  varchar(30) NULL AFTER `tel`,
ADD COLUMN `language_id`  int NULL AFTER `key`,
ADD COLUMN `remark`  varchar(50) NULL AFTER `language_id`;

