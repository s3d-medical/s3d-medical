
drop table if exists `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `name` varchar(222) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

