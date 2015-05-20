/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : medical

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2015-05-19 20:45:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mr_comma_info
-- ----------------------------
DROP TABLE IF EXISTS `mr_comma_info`;
CREATE TABLE `mr_comma_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `days_before_admission` smallint(6) DEFAULT NULL,
  `hours_before_admission` smallint(6) DEFAULT NULL,
  `minutes_before_admission` smallint(6) DEFAULT NULL,
  `days_in_hospital` smallint(6) DEFAULT NULL,
  `hours_in_hospital` smallint(6) DEFAULT NULL,
  `minutes_in_hospital` smallint(6) DEFAULT NULL,
  `medical_record_home_page_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_diagnosis
-- ----------------------------
DROP TABLE IF EXISTS `mr_diagnosis`;
CREATE TABLE `mr_diagnosis` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_diagnosis_clinic
-- ----------------------------
DROP TABLE IF EXISTS `mr_diagnosis_clinic`;
CREATE TABLE `mr_diagnosis_clinic` (
  `clinic_id` int(10) NOT NULL COMMENT 'Use it as forgein key and pk to join parent table diagnosis',
  PRIMARY KEY (`clinic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_diagnosis_discharge
-- ----------------------------
DROP TABLE IF EXISTS `mr_diagnosis_discharge`;
CREATE TABLE `mr_diagnosis_discharge` (
  `discharge_id` int(10) NOT NULL COMMENT 'Use it as forgein key and pk to join parent table diagnosis',
  `illness_state` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `medical_record_home_page_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`discharge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_diagnosis_external_reason
-- ----------------------------
DROP TABLE IF EXISTS `mr_diagnosis_external_reason`;
CREATE TABLE `mr_diagnosis_external_reason` (
  `external_reason_id` int(11) NOT NULL COMMENT 'Use it as forgein key and pk to join parent table diagnosis',
  PRIMARY KEY (`external_reason_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_diagnosis_pathology
-- ----------------------------
DROP TABLE IF EXISTS `mr_diagnosis_pathology`;
CREATE TABLE `mr_diagnosis_pathology` (
  `pathology_id` int(11) NOT NULL COMMENT 'Use it as forgein key and pk to join parent table diagnosis',
  `pathology_no` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`pathology_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_doctor_in_charge
-- ----------------------------
DROP TABLE IF EXISTS `mr_doctor_in_charge`;
CREATE TABLE `mr_doctor_in_charge` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `worker_role` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `doctor` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `medical_record_home_page_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_expense_invoice
-- ----------------------------
DROP TABLE IF EXISTS `mr_expense_invoice`;
CREATE TABLE `mr_expense_invoice` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `total_amount` decimal(16,2) DEFAULT NULL,
  `self_paying_amount` decimal(16,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_expense_item
-- ----------------------------
DROP TABLE IF EXISTS `mr_expense_item`;
CREATE TABLE `mr_expense_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `item_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `amount` decimal(16,2) DEFAULT NULL,
  `expense_invoice_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_home_page_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `mr_home_page_basic_info`;
CREATE TABLE `mr_home_page_basic_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `payment_type` tinyint(4) DEFAULT NULL,
  `health_card_no` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `hospitalized_times` mediumint(9) DEFAULT NULL,
  `seq_no` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `depart_changes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `if_drug_allergy` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `allergy_drug` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `if_autopsy` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `blood_type` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `if_rh` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_medical_record_home_page
-- ----------------------------
DROP TABLE IF EXISTS `mr_medical_record_home_page`;
CREATE TABLE `mr_medical_record_home_page` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `business_key` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `home_page_basic_info_id` int(11) DEFAULT NULL,
  `patient_info_id` int(11) DEFAULT NULL,
  `register_admission_id` int(11) DEFAULT NULL,
  `register_discharge_id` int(11) DEFAULT NULL,
  `diagnosis_clinic_id` int(11) DEFAULT NULL,
  `diagnosis_external_reason_id` int(11) DEFAULT NULL,
  `diagnosis_pathology_id` int(11) DEFAULT NULL,
  `quality_control_info_id` int(11) DEFAULT NULL,
  `expense_invoice_id` int(11) DEFAULT NULL,
  `comma_info_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_operation
-- ----------------------------
DROP TABLE IF EXISTS `mr_operation`;
CREATE TABLE `mr_operation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `operate_date` datetime DEFAULT NULL,
  `level` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `healed_in_grade` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `major_operator` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `assistant1` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `assistant2` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `anestesia_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `anestesia_doctor` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `medical_record_home_page_id` int(11) DEFAULT NULL,
  `anesthesia_doctor` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `anesthesia_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_quality_control_info
-- ----------------------------
DROP TABLE IF EXISTS `mr_quality_control_info`;
CREATE TABLE `mr_quality_control_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `case_quality` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `quality_date` datetime DEFAULT NULL,
  `quality_doctor` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `quality_nurse` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for mr_register_admission
-- ----------------------------
DROP TABLE IF EXISTS `mr_register_admission`;
CREATE TABLE `mr_register_admission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `registered_time` datetime DEFAULT NULL,
  `depart` varchar(36) DEFAULT NULL,
  `sick_room_no` varchar(20) DEFAULT NULL,
  `approach` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mr_register_discharge
-- ----------------------------
DROP TABLE IF EXISTS `mr_register_discharge`;
CREATE TABLE `mr_register_discharge` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `registered_time` datetime DEFAULT NULL,
  `depart` varchar(36) DEFAULT NULL,
  `sick_room_no` varchar(20) DEFAULT NULL,
  `total_days` mediumint(8) unsigned DEFAULT NULL,
  `discharge_type` varchar(36) DEFAULT NULL,
  `accepting_agency_name` varchar(200) DEFAULT NULL,
  `has_readmission_plan` varchar(36) DEFAULT NULL,
  `readmission_goal` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for p_address
-- ----------------------------
DROP TABLE IF EXISTS `p_address`;
CREATE TABLE `p_address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `address_type` varchar(50) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `county` mediumint(4) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  `phone_no` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for p_company
-- ----------------------------
DROP TABLE IF EXISTS `p_company`;
CREATE TABLE `p_company` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone_no` varchar(30) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for p_contact_person
-- ----------------------------
DROP TABLE IF EXISTS `p_contact_person`;
CREATE TABLE `p_contact_person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) DEFAULT NULL,
  `relationship` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone_no` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for p_patient_info
-- ----------------------------
DROP TABLE IF EXISTS `p_patient_info`;
CREATE TABLE `p_patient_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `full_name` varchar(40) DEFAULT NULL,
  `sex` varchar(36) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `age_year` tinyint(3) DEFAULT NULL,
  `age_month` tinyint(3) DEFAULT NULL,
  `nationality` varchar(36) DEFAULT NULL,
  `weight_of_birth` int(12) DEFAULT NULL,
  `weight_of_admission` int(12) DEFAULT NULL,
  `race` varchar(36) DEFAULT NULL,
  `id_card_no` varchar(40) DEFAULT NULL,
  `career` varchar(36) DEFAULT NULL,
  `marital_status` varchar(36) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `contact_person_id` int(11) DEFAULT NULL,
  `native_place_id` int(11) DEFAULT NULL,
  `present_address_id` int(11) DEFAULT NULL,
  `registered_residence_id` int(11) DEFAULT NULL,
  `birth_place_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
