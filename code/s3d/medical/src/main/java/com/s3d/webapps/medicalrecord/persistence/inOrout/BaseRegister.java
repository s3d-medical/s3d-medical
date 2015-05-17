package com.s3d.webapps.medicalrecord.persistence.inOrout;

import com.s3d.webapps.medicalrecord.persistence.AbstractGeneralProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @author  wind.chen
 * @date 2015/5/11.
 */

public class BaseRegister extends AbstractGeneralProperties {
    @Column(name="registered_time")
    protected Date registeredTime;

    @Column(name="depart")
    protected Integer depart;

    @Column(name="sick_room_no")
    protected String sickRoomNo;

    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Integer getDepart() {
        return depart;
    }

    public void setDepart(Integer depart) {
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
