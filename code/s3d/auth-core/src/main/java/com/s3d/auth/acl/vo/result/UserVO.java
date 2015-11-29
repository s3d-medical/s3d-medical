package com.s3d.auth.acl.vo.result;

import com.s3d.auth.acl.entity.User;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author  wind.chen
 * @since 2015/7/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVO implements Serializable {
    private static final long serialVersionUID = 6578526809587873686L;
    private Integer id;
    private String userName;
    private String sex;
    private String email;
    private String realName;
    private String code;
    private Integer departmentId;
    private String departmentName;
    private String phone;
    private String tel;
    private Integer languageId;
    private String key;
    private String remark;
    private Integer order;

    public UserVO(User user) {
        this.id = user.getId();
        this.userName = user.getLoginName();
        this.email = user.getEmail();
        this.realName = user.getFullName();
        this.code = user.getCode();
        this.departmentId = user.getOrgId();
        this.departmentName = user.getOrgName();
        this.phone = user.getPhone();
        this.tel = user.getTel();
        this.languageId = user.getLanguageId();
        this.key = user.getKey();
        this.remark = user.getRemark();
    }

    public UserVO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
