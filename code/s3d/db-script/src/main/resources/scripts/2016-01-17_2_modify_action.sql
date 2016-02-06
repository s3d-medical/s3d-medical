 ALTER TABLE `auth_action`
ADD COLUMN `remark`  VARCHAR(50) NULL DEFAULT NULL AFTER `action_name`;
