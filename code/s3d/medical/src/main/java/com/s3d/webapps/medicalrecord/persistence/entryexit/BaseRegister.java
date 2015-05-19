package com.s3d.webapps.medicalrecord.persistence.entryexit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author  wind.chen
 * @date 2015/5/11.
 */
@MappedSuperclass
public abstract class BaseRegister implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name="registered_time")
    protected Date registeredTime;

    @Column(name="depart")
    protected String depart;

    @Column(name="sick_room_no")
    protected String sickRoomNo;

    public BaseRegister() {
    }

    public BaseRegister(Date registeredTime, String depart, String sickRoomNo) {
        this.registeredTime = registeredTime;
        this.depart = depart;
        this.sickRoomNo = sickRoomNo;
    }

    public void fill(Date registeredTime, String depart, String sickRoomNo) {
        this.registeredTime = registeredTime;
        this.depart = depart;
        this.sickRoomNo = sickRoomNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getSickRoomNo() {
        return sickRoomNo;
    }

    public void setSickRoomNo(String sickRoomNo) {
        this.sickRoomNo = sickRoomNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseRegister)) return false;
        if (!super.equals(o)) return false;

        BaseRegister that = (BaseRegister) o;

        if (depart != null ? !depart.equals(that.depart) : that.depart != null) return false;
        if (registeredTime != null ? !registeredTime.equals(that.registeredTime) : that.registeredTime != null)
            return false;
        if (sickRoomNo != null ? !sickRoomNo.equals(that.sickRoomNo) : that.sickRoomNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (registeredTime != null ? registeredTime.hashCode() : 0);
        result = 31 * result + (depart != null ? depart.hashCode() : 0);
        result = 31 * result + (sickRoomNo != null ? sickRoomNo.hashCode() : 0);
        return result;
    }
}
