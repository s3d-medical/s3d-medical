package com.s3d.webapps.record.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.webapps.record.dto
 * @date 2016/2/11 17:31
 */
public class QRecordAccess {
    private String departNo;
    private List<String> signFields = new ArrayList<String>();

    public List<String> getSignFields() {
        return signFields;
    }

    public void setSignFields(List<String> signFields) {
        this.signFields = signFields;
    }

    public String getDepartNo() {
        return departNo;
    }

    public void setDepartNo(String departNo) {
        this.departNo = departNo;
    }

}
