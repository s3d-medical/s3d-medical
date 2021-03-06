package com.s3d.webapps.medicalrecord.vo.homepage;

import com.s3d.tech.utils.DateUtils;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.doctor.DoctorInCharge;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.quality.QualityControlInfo;

import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DoctorAndQualityRecordVO {
    private String director;
    private String deputyDirector;
    private String attendingDoctor;
    private String residentDoctor;
    private String primaryNurse;
    private String refresherDoctor;
    private String intern;
    private String coder;

    private String caseQuality;
    private String qualityDoctor;
    private String qualityNurse;
    private Integer qualityYear;
    private Integer qualityMonth;
    private Integer qualityDay;

    public DoctorAndQualityRecordVO() {
    }

    public void fill(List<DoctorInCharge> doctorInChargeList, QualityControlInfo qualityControlInfo) {
        this.director = doctorInChargeList.get(0).getDoctor();
        this.deputyDirector = doctorInChargeList.get(1).getDoctor();
        this.attendingDoctor = doctorInChargeList.get(2).getDoctor();
        this.residentDoctor = doctorInChargeList.get(3).getDoctor();
        this.primaryNurse = doctorInChargeList.get(4).getDoctor();
        this.refresherDoctor = doctorInChargeList.get(5).getDoctor();
        this.intern = doctorInChargeList.get(6).getDoctor();
        this.coder = doctorInChargeList.get(7).getDoctor();

        this.caseQuality = qualityControlInfo.getCaseQuality();
        this.qualityDoctor = qualityControlInfo.getQualityDoctor();
        this.qualityNurse = qualityControlInfo.getQualityNurse();
        this.qualityYear = DateUtils.getYear(qualityControlInfo.getQualityDate());
        this.qualityMonth = DateUtils.getMonth(qualityControlInfo.getQualityDate());
        this.qualityDay = DateUtils.getDayInMonth(qualityControlInfo.getQualityDate());
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDeputyDirector() {
        return deputyDirector;
    }

    public void setDeputyDirector(String deputyDirector) {
        this.deputyDirector = deputyDirector;
    }

    public String getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(String attendingDoctor) {
        this.attendingDoctor = attendingDoctor;
    }

    public String getResidentDoctor() {
        return residentDoctor;
    }

    public void setResidentDoctor(String residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public String getPrimaryNurse() {
        return primaryNurse;
    }

    public void setPrimaryNurse(String primaryNurse) {
        this.primaryNurse = primaryNurse;
    }

    public String getRefresherDoctor() {
        return refresherDoctor;
    }

    public void setRefresherDoctor(String refresherDoctor) {
        this.refresherDoctor = refresherDoctor;
    }

    public String getIntern() {
        return intern;
    }

    public void setIntern(String intern) {
        this.intern = intern;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public String getCaseQuality() {
        return caseQuality;
    }

    public void setCaseQuality(String caseQuality) {
        this.caseQuality = caseQuality;
    }

    public String getQualityDoctor() {
        return qualityDoctor;
    }

    public void setQualityDoctor(String qualityDoctor) {
        this.qualityDoctor = qualityDoctor;
    }

    public String getQualityNurse() {
        return qualityNurse;
    }

    public void setQualityNurse(String qualityNurse) {
        this.qualityNurse = qualityNurse;
    }

    public Integer getQualityYear() {
        return qualityYear;
    }

    public void setQualityYear(Integer qualityYear) {
        this.qualityYear = qualityYear;
    }

    public Integer getQualityMonth() {
        return qualityMonth;
    }

    public void setQualityMonth(Integer qualityMonth) {
        this.qualityMonth = qualityMonth;
    }

    public Integer getQualityDay() {
        return qualityDay;
    }

    public void setQualityDay(Integer qualityDay) {
        this.qualityDay = qualityDay;
    }
}
