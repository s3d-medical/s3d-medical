ALTER TABLE `mr_diagnosis`
DROP COLUMN `code`;

drop  table  if exists  mr_disease_code;
CREATE TABLE `mr_disease_code` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `diagnosis_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

