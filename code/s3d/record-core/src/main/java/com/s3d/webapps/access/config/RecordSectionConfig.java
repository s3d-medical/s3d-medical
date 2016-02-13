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
public class RecordSectionConfig {
    private static Map<String, RecordSectionConfig> map = new HashMap<String, RecordSectionConfig>();
    private String optValue; //option vale
    private String optText; //option text
    private String name; //字段名称

    static{
        List<RecordSectionConfig> list = new ArrayList<RecordSectionConfig>();
        list.add(new RecordSectionConfig("1","primaryPage", "病案首页"));
        list.add( new RecordSectionConfig("2", "s2", "常规检查"));
        list.add(new RecordSectionConfig("3", "s3", "病理报告"));
        list.add(new RecordSectionConfig("4", "s4", "长期医嘱单"));
        list.add(new RecordSectionConfig("5", "s5" , "临时医嘱单"));
        list.add(new RecordSectionConfig("6", "s6", "护理记录"));
        list.add(new RecordSectionConfig("6", "s7", "特殊病情记录"));
        list.add(new RecordSectionConfig("7", "s8", "体温表"));
        list.add(new RecordSectionConfig("8", "s9", "转科记录"));
        for(RecordSectionConfig def : list){
            map.put(def.optValue, def);
        }
    }

    public RecordSectionConfig() {

    }

    public RecordSectionConfig(String code, String desc, String name) {
        this.optValue = code;
        this.optText = desc;
        this.name = name;
    }

    public static List<String> getSignFieldNames(List<String> fieldCodes) {
        List<String> names = new ArrayList<String>();
        if (!CollectionUtils.isEmpty(fieldCodes)) {
            for (String code : fieldCodes) {
                RecordSectionConfig field = map.get(code);
                if (field != null) {
                    names.add(field.getName());
                }
            }
        }
        return names;
    }

    public static String getSignFieldName(String code) {
        RecordSectionConfig field = map.get(code);
        if(field != null){
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
