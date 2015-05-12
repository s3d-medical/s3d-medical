package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.
 */
@Entity
@Table(name="mr_diagnosis_discharge")
@PrimaryKeyJoinColumn(name="discharge_id")
public class DiagnosisDischarge extends Diagnose {

    @Column(name="category")
	private Integer category;

    @Column(name="illness_state")
	private Integer illnessState;

    public DiagnosisDischarge(String name, String code, Integer category, Integer illnessState) {
        super(name, code);
        this.category = category;
        this.illnessState = illnessState;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getIllnessState() {
        return illnessState;
    }

    public void setIllnessState(Integer illnessState) {
        this.illnessState = illnessState;
    }
}