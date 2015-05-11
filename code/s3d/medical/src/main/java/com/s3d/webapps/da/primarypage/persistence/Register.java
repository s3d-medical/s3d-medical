package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author  wind.chen
 * @date 2015/5/11.
 */
public class Register implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="registered_time")
    private Date registeredTime;

    @Column(name="depart")
    private Integer depart;

    @Column(name="sick_room_no")
    private String sickRoomNo;

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
}
