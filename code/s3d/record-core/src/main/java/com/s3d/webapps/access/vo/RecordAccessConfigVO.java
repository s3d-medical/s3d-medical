package com.s3d.webapps.access.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @desc com.s3d.auth.doc.permission.vo
 * @date 2016/2/10 16:04
 */
public class RecordAccessConfigVO {

    private Integer authObjType;
    private List<Integer> userIds = new ArrayList<Integer>();
    private String remark;
    private List<RecordAccessConfigItemVO> items = new ArrayList<RecordAccessConfigItemVO>();

    public Integer getAuthObjType() {
        return authObjType;
    }

    public void setAuthObjType(Integer authObjType) {
        this.authObjType = authObjType;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<RecordAccessConfigItemVO> getItems() {
        return items;
    }

    public void setItems(List<RecordAccessConfigItemVO> items) {
        this.items = items;
    }

    public void addItem(RecordAccessConfigItemVO item){
        if(this.items == null){
            this.items = new ArrayList<RecordAccessConfigItemVO>();
        }
        if(item != null){
            this.items.add(item);
        }
    }
}
