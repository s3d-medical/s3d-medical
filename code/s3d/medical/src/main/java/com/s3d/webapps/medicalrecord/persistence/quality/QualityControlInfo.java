package com.s3d.webapps.medicalrecord.persistence.quality;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * quality level:
 1.甲 2.乙 3.丙
 * @author Administrator
 * @version 1.0
 * @updated 13-����-2015 16:43:26
 */
@Entity
@Table(name="mr_quality_control_info")
public class QualityControlInfo{
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name="case_quality")
	private String caseQuality;

    @Column(name="quality_date")
	private Date qualityDate;

    @Column(name="quality_doctor")
    private String qualityDoctor;

    @Column(name="quality_nurse")
    private String qualityNurse;

	public QualityControlInfo(){

	}

    public void fill(String caseQuality, String qualityDoctor, String qualityNurse, Date qualityDate) {
        this.caseQuality = caseQuality;
        this.qualityDate = qualityDate;
        this.qualityDoctor = qualityDoctor;
        this.qualityNurse = qualityNurse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(Date qualityDate) {
        this.qualityDate = qualityDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QualityControlInfo)) return false;
        if (!super.equals(o)) return false;

        QualityControlInfo that = (QualityControlInfo) o;

        if (caseQuality != null ? !caseQuality.equals(that.caseQuality) : that.caseQuality != null) return false;
        if (qualityDate != null ? !qualityDate.equals(that.qualityDate) : that.qualityDate != null) return false;
        if (qualityDoctor != null ? !qualityDoctor.equals(that.qualityDoctor) : that.qualityDoctor != null)
            return false;
        if (qualityNurse != null ? !qualityNurse.equals(that.qualityNurse) : that.qualityNurse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (caseQuality != null ? caseQuality.hashCode() : 0);
        result = 31 * result + (qualityDate != null ? qualityDate.hashCode() : 0);
        result = 31 * result + (qualityDoctor != null ? qualityDoctor.hashCode() : 0);
        result = 31 * result + (qualityNurse != null ? qualityNurse.hashCode() : 0);
        return result;
    }
}