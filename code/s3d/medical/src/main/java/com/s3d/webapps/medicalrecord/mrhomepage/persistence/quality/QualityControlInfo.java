package com.s3d.webapps.medicalrecord.mrhomepage.persistence.quality;

import com.s3d.tech.data.persistence.AbstractGeneralProperties;

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
public class QualityControlInfo  extends AbstractGeneralProperties {

    @Column(name="quality_level")
	private Integer qualityLevel;

    @Column(name="quality_date")
	private Date qualityDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "qualityControlInfo")
    @JoinColumn(name="quality_control_info_id")
	public List<PersonInQualityControl> personsInQualityControl = new ArrayList<PersonInQualityControl>();

	public QualityControlInfo(){

	}

    public Integer getQualityLevel() {
        return qualityLevel;
    }

    public void setQualityLevel(Integer qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    public Date getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(Date qualityDate) {
        this.qualityDate = qualityDate;
    }

    public List<PersonInQualityControl> getPersonsInQualityControl() {
        return personsInQualityControl;
    }

    public void setPersonsInQualityControl(List<PersonInQualityControl> personsInQualityControl) {
        this.personsInQualityControl = personsInQualityControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QualityControlInfo)) return false;
        if (!super.equals(o)) return false;

        QualityControlInfo that = (QualityControlInfo) o;

        if (personsInQualityControl != null ? !personsInQualityControl.equals(that.personsInQualityControl) : that.personsInQualityControl != null)
            return false;
        if (qualityDate != null ? !qualityDate.equals(that.qualityDate) : that.qualityDate != null) return false;
        if (qualityLevel != null ? !qualityLevel.equals(that.qualityLevel) : that.qualityLevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (qualityLevel != null ? qualityLevel.hashCode() : 0);
        result = 31 * result + (qualityDate != null ? qualityDate.hashCode() : 0);
        result = 31 * result + (personsInQualityControl != null ? personsInQualityControl.hashCode() : 0);
        return result;
    }
}