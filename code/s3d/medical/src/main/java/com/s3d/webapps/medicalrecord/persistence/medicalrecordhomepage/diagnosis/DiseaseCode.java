package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wind.chen
 * @date 2015/6/20.
 */
@Entity
@Table(name="mr_disease_code")
public class DiseaseCode implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="code")
    private String code;

    @ManyToOne()
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
    private BaseDiagnosis diagnosis;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BaseDiagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(BaseDiagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

}
