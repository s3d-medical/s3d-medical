package com.s3d.auth.acl.vo;

import com.s3d.auth.acl.entity.User;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author  wind.chen
 * @since 2015/7/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBasicVO implements Serializable {
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

    public UserBasicVO(User user) {
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

    public UserBasicVO() {

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBasicVO)) return false;

        UserBasicVO that = (UserBasicVO) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (languageId != null ? !languageId.equals(that.languageId) : that.languageId != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (languageId != null ? languageId.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
