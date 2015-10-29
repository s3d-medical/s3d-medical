package com.s3d.webapps.record.entity.homepage;

import java.io.Serializable;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DoctorAndQualityRecord  implements Serializable {
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

    public DoctorAndQualityRecord() {
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
