ALTER TABLE `mr_medical_record_home_page`
DROP COLUMN `business_key`;

ALTER TABLE `mr_home_page_basic_info`
ADD COLUMN `business_key`  varchar(40) NULL AFTER `id`;


