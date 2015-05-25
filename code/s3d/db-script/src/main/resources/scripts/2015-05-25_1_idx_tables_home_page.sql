ALTER TABLE `mr_diagnosis_discharge`
ADD INDEX `idx_page_id` (`medical_record_home_page_id`) ;

ALTER TABLE `mr_doctor_in_charge`
ADD INDEX `idx_page_id` (`medical_record_home_page_id`) ;

ALTER TABLE `mr_expense_item`
ADD INDEX `idx_invoice_id` (`expense_invoice_id`) ;

ALTER TABLE `mr_home_page_basic_info`
ADD INDEX `idx_business_key` (`business_key`) ;

ALTER TABLE `mr_medical_record_home_page`
ADD INDEX `idx_page_basic_info_id` (`home_page_basic_info_id`) ;

ALTER TABLE `mr_operation`
ADD INDEX `idx_page_id` (`medical_record_home_page_id`) ;

