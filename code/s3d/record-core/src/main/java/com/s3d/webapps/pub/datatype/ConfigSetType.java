package com.s3d.webapps.pub.datatype;

/**
 * @author wind.chen
 * @date 2015/5/23.
 */
public enum ConfigSetType {
    MEDICAL_RECORD_TYPE("medicalRecordType", "FL", "病案分类"),
    DEPARTMENT("departments", "KS", "科室设置"),
    COUNTRY("countries", "GJ", "国家"),
    NATIONS("nations", "MZ", "民族"),
    CREDENTIAL_TYPE("credentialType", "ZJ", "证件类型"),
    RELATIONSHIP("relationships", "GX", "关系设置"),
    MARRIAGE_STATUS("marriages", "HY", "婚姻状况"),
    JOB("jobs", "ZY", "职业"),
    LOCATION("locations", "SS", "省市县"),
    SICK_CODES("sickCodes", "JB", "疾病编码"),
    HOSPITALIZED_TYPES("inTypes", "RYTJ", "入院途径"),
    DISCHARGED_TYPES("outTypes", "LYFS", "离院方式"),
    IN_SICK_Level("inSickLevel", "RYJC", "入院病况等级"),
    IN_SICK_STATES("inSickStates", "RYBQ", "入院病情"),
    DISCHARGE_STATES("outState", "CYQK", "出院情况"),
    DISCHARGE_DOCTORS("doctors", "YS", "医生"),
    DISCHARGE_OPERATIONS("operations", "SSBM", "手术编码");

    ConfigSetType(String name, String code, String desc) {
        this.name = name;
        this.code = code;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private String name;
    private String code;
    private String desc;
}
