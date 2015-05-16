package com.s3d.webapps.medicalrecord.persistence.quality;


import com.s3d.tech.data.po.AbstractGeneralProperties;

import javax.persistence.*;

/**
 * role name:
 * @author wind.chen
 * @version 1.0
 *
 */
@Entity
@Table(name="mr_person_in_quality_control")
public class PersonInQualityControl  extends AbstractGeneralProperties {

    /**
     * 1. 科主任 2. 主任(副主任)医师. 3主治医师 4. 住院医师
     * 5 责任护士 6进修医师 7.实习医师 8.编码员 9.质控医师 10.质控护士
     */
    @Column(name="worker_role")
	private Integer workerRole;
    @Column(name="doctor")
	private String doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quality_control_info_id", referencedColumnName = "id")
    private QualityControlInfo qualityControlInfo;

	public PersonInQualityControl(){

	}
    public Integer getWorkerRole() {
        return workerRole;
    }

    public void setWorkerRole(Integer workerRole) {
        this.workerRole = workerRole;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public QualityControlInfo getQualityControlInfo() {
        return qualityControlInfo;
    }

    public void setQualityControlInfo(QualityControlInfo qualityControlInfo) {
        this.qualityControlInfo = qualityControlInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonInQualityControl)) return false;
        if (!super.equals(o)) return false;

        PersonInQualityControl that = (PersonInQualityControl) o;

        if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null) return false;
        if (qualityControlInfo != null ? !qualityControlInfo.equals(that.qualityControlInfo) : that.qualityControlInfo != null)
            return false;
        if (workerRole != null ? !workerRole.equals(that.workerRole) : that.workerRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (workerRole != null ? workerRole.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (qualityControlInfo != null ? qualityControlInfo.hashCode() : 0);
        return result;
    }
}