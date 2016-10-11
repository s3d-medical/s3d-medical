package com.s3d.webapps.access.config;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @desc com.s3d.record.config
 * @date 2016/2/13 11:18
 */
public class DoctorSignFieldConfig {
    private static Map<String, DoctorSignFieldConfig> map = new HashMap<String, DoctorSignFieldConfig>();
    private String optValue; //option vale
    private String optText; //option text
    private String name; //字段名称

    static {
        List<DoctorSignFieldConfig> list = new ArrayList<DoctorSignFieldConfig>();
        list.add(new DoctorSignFieldConfig("1", "doctorAndQualityRecord.director", "科主任"));
        list.add(new DoctorSignFieldConfig("2", "doctorAndQualityRecord.deputyDirector", "主任医生(副主任)医师"));
        list.add(new DoctorSignFieldConfig("3", "doctorAndQualityRecord.attendingDoctor", "主治医师"));
        list.add(new DoctorSignFieldConfig("4", "doctorAndQualityRecord.residentDoctor", "住院医师"));
        list.add(new DoctorSignFieldConfig("5", "doctorAndQualityRecord.primaryNurse", "责任护士"));
        list.add(new DoctorSignFieldConfig("6", "doctorAndQualityRecord.refresherDoctor", "进修医师"));
        list.add(new DoctorSignFieldConfig("7", "doctorAndQualityRecord.intern", "实习医师"));
        list.add(new DoctorSignFieldConfig("8", "doctorAndQualityRecord.qualityDoctor", "质控医师"));
        list.add(new DoctorSignFieldConfig("9", "doctorAndQualityRecord.qualityNurse", "质控护士"));
        list.add(new DoctorSignFieldConfig("10", "doctorAndQualityRecord.coder", "编码员"));
        for (DoctorSignFieldConfig def : list) {
            map.put(def.optValue, def);
        }
    }

    public DoctorSignFieldConfig() {

    }

    public DoctorSignFieldConfig(String optValue, String name, String desc) {
        this.optValue = optValue;
        this.optText = desc;
        this.name = name;
    }

    public static List<String> getSignFieldNames(List<String> fieldCodes) {
        List<String> names = new ArrayList<String>();
        if (!CollectionUtils.isEmpty(fieldCodes)) {
            for (String code : fieldCodes) {
                DoctorSignFieldConfig field = map.get(code);
                if (field != null) {
                    names.add(field.getName());
                }
            }
        }
        return names;
    }

    public static String getSignFieldName(String code) {
        DoctorSignFieldConfig field = map.get(code);
        if (field != null) {
            return field.getName();
        }
        return null;
    }

    public String getOptValue() {
        return optValue;
    }

    public void setOptValue(String optValue) {
        this.optValue = optValue;
    }

    public String getOptText() {
        return optText;
    }

    public void setOptText(String optText) {
        this.optText = optText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
