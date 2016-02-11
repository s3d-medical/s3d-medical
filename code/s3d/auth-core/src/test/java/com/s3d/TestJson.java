package com.s3d;

import com.s3d.auth.record.access.vo.RecordAccessConfigItemVO;
import com.s3d.auth.record.access.vo.RecordAccessConfigVO;
import com.s3d.tech.utils.JacksonParser;

/**
 * @author Administrator
 * @desc com.s3d
 * @date 2016/2/10 23:20
 */
public class TestJson {

    public static void main(String args[]){
        RecordAccessConfigVO config = new RecordAccessConfigVO();
        config.setRemark("设置公司领导");
        config.setAuthObjType(1);
        config.getUserIds().add(1);
        config.getUserIds().add(2);
        RecordAccessConfigItemVO item = new RecordAccessConfigItemVO();
        item.setDepartAssignedType(1);
        item.setBrowseType(1);
        item.getDepartNos().add("00010001");
        item.getDepartNos().add("00010002");
        item.getSignFields().add("0");
        item.getSignFields().add("1");
        item.getSectionNos().add("0");
        item.getSectionNos().add("1");
        config.addItem(item);
        String json = JacksonParser.convertToJSONString(config);
        System.out.println(json);
    }
}
