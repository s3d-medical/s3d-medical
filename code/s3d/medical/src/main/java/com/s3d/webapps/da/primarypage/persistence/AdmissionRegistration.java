package com.s3d.webapps.da.primarypage.persistence;

import java.util.Date;

/**
 * @author wind.chen
 * @version 1.0
 * @created 10-����-2015 14:11:34
 */
public class AdmissionRegistration {

	private int approach;
	private Date admissionTime;
	private String admissionDepart;
	private String sickRoomNo;

    public int getApproach() {
        return approach;
    }

    public void setApproach(int approach) {
        this.approach = approach;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getAdmissionDepart() {
        return admissionDepart;
    }

    public void setAdmissionDepart(String admissionDepart) {
        this.admissionDepart = admissionDepart;
    }

    public String getSickRoomNo() {
        return sickRoomNo;
    }

    public void setSickRoomNo(String sickRoomNo) {
        this.sickRoomNo = sickRoomNo;
    }
}