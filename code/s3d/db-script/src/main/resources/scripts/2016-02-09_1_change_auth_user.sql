set FOREIGN_KEY_CHECKS= 0;

drop  table  if exists  auth_user;
CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `registered_time` datetime DEFAULT NULL COMMENT 'registered time',
  `last_login_time` datetime DEFAULT NULL COMMENT 'last login time',
  `state` tinyint(4) DEFAULT '1',
  `auth_org_id` int(11) DEFAULT NULL COMMENT 'org belonged',
  `full_name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `key` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `language_id` int(11) DEFAULT NULL,
  `remark` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `area_code` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auth_user_auth_org1_idx` (`auth_org_id`),
  CONSTRAINT `fk_auth_user_auth_org1` FOREIGN KEY (`auth_org_id`) REFERENCES `auth_org` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

