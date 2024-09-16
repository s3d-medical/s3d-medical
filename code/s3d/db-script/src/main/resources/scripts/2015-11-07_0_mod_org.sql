ALTER TABLE `auth_org`
ADD COLUMN `status`  tinyint NULL DEFAULT 0 COMMENT '1可用， 2 已删除' AFTER `auth_parent_org_id`;

