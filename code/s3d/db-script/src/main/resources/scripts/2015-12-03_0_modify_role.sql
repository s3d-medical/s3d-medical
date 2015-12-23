ALTER TABLE `auth_role`
MODIFY COLUMN `state`  tinyint(2) NULL DEFAULT 1 AFTER `desc`,
ADD COLUMN `creator`  varchar(30) NULL AFTER `state`,
ADD COLUMN `created_time`  datetime NULL AFTER `creator`,
ADD COLUMN `category_id`  int NULL AFTER `created_time`;

CREATE TABLE `auth_role_category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `desc` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

 ALTER TABLE `auth_role`
CHANGE COLUMN `creator` `creator_id`  int(11) NULL DEFAULT NULL AFTER `state`;
