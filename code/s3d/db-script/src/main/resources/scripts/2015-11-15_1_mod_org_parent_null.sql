
-- change foreign key.
ALTER TABLE `auth_org` DROP FOREIGN KEY `fk_auth_org_auth_org1`;

ALTER TABLE `auth_org`
MODIFY COLUMN `auth_parent_org_id`  int(11) NULL AFTER `remark`;

ALTER TABLE `auth_org` ADD CONSTRAINT `fk_auth_org_auth_org1` FOREIGN KEY (`auth_parent_org_id`) REFERENCES `auth_org` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

