package com.s3d.webapps.access.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.doc.access.vo
 * @date 2016/2/10 22:14
 */
public class RecordAccessConfigItemVO {
    private Integer departAssignedType;
    private List<String> departNos = new ArrayList<String>();
    private List<String> signFields = new ArrayList<String>();
    private Integer browseType;
    private List<String> sectionNos = new ArrayList<String>();

    public List<String> getDepartNos() {
        return departNos;
    }

    public void setDepartNos(List<String> departNos) {
        this.departNos = departNos;
    }

    public List<String> getSignFields() {
        return signFields;
    }

    public void setSignFields(List<String> signFields) {
        this.signFields = signFields;
    }

    public List<String> getSectionNos() {
        return sectionNos;
    }

    public void setSectionNos(List<String> sectionNos) {
        this.sectionNos = sectionNos;
    }

    public Integer getDepartAssignedType() {
        return departAssignedType;
    }

    public void setDepartAssignedType(Integer departAssignedType) {
        this.departAssignedType = departAssignedType;
    }

    public Integer getBrowseType() {
        return browseType;
    }

    public void setBrowseType(Integer browseType) {
        this.browseType = browseType;
    }
}
