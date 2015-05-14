package com.s3d.webapps.medicalrecord.mrhomepage.persistence;

import com.s3d.tech.data.persistence.AbstractGeneralProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name = "mr_operation")
public class Operation  extends AbstractGeneralProperties {

    @Column(name="name")
    private String name;

    @Column(name="code")
    private String code;

    @Column(name="operate_date")
    private Date operatedDate;

    @Column(name ="level")
    private String level;

    @Column(name="healed_in_grade")
    private String healedInGrade;

    @Column(name="major_operator")
    private String majorOperator;

    @Column(name="assistant1")
    private String assistant1;

    @Column(name="assistant2")
    private String assistant2;

    @Column(name="anesthesia_type")
    private String anesthesiaType;

    @Column(name="anesthesia_doctor")
    private String anesthesiaDoctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medical_record_home_page_id", referencedColumnName = "id")
    private MedicalRecordHomePage medicalRecordHomePage;

    public Operation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getOperatedDate() {
        return operatedDate;
    }

    public void setOperatedDate(Date operatedDate) {
        this.operatedDate = operatedDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHealedInGrade() {
        return healedInGrade;
    }

    public void setHealedInGrade(String healedInGrade) {
        this.healedInGrade = healedInGrade;
    }

    public String getMajorOperator() {
        return majorOperator;
    }

    public void setMajorOperator(String majorOperator) {
        this.majorOperator = majorOperator;
    }

    public String getAssistant1() {
        return assistant1;
    }

    public void setAssistant1(String assistant1) {
        this.assistant1 = assistant1;
    }

    public String getAssistant2() {
        return assistant2;
    }

    public void setAssistant2(String assistant2) {
        this.assistant2 = assistant2;
    }

    public String getAnesthesiaType() {
        return anesthesiaType;
    }

    public void setAnesthesiaType(String anesthesiaType) {
        this.anesthesiaType = anesthesiaType;
    }

    public String getAnesthesiaDoctor() {
        return anesthesiaDoctor;
    }

    public void setAnesthesiaDoctor(String anesthesiaDoctor) {
        this.anesthesiaDoctor = anesthesiaDoctor;
    }

    public MedicalRecordHomePage getMedicalRecordHomePage() {
        return medicalRecordHomePage;
    }

    public void setMedicalRecordHomePage(MedicalRecordHomePage medicalRecordHomePage) {
        this.medicalRecordHomePage = medicalRecordHomePage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;

        Operation operation = (Operation) o;

        if (anesthesiaDoctor != null ? !anesthesiaDoctor.equals(operation.anesthesiaDoctor) : operation.anesthesiaDoctor != null)
            return false;
        if (anesthesiaType != null ? !anesthesiaType.equals(operation.anesthesiaType) : operation.anesthesiaType != null)
            return false;
        if (assistant1 != null ? !assistant1.equals(operation.assistant1) : operation.assistant1 != null) return false;
        if (assistant2 != null ? !assistant2.equals(operation.assistant2) : operation.assistant2 != null) return false;
        if (code != null ? !code.equals(operation.code) : operation.code != null) return false;
        if (healedInGrade != null ? !healedInGrade.equals(operation.healedInGrade) : operation.healedInGrade != null)
            return false;
        if (level != null ? !level.equals(operation.level) : operation.level != null) return false;
        if (majorOperator != null ? !majorOperator.equals(operation.majorOperator) : operation.majorOperator != null)
            return false;
        if (medicalRecordHomePage != null ? !medicalRecordHomePage.equals(operation.medicalRecordHomePage) : operation.medicalRecordHomePage != null)
            return false;
        if (name != null ? !name.equals(operation.name) : operation.name != null) return false;
        if (operatedDate != null ? !operatedDate.equals(operation.operatedDate) : operation.operatedDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (operatedDate != null ? operatedDate.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (healedInGrade != null ? healedInGrade.hashCode() : 0);
        result = 31 * result + (majorOperator != null ? majorOperator.hashCode() : 0);
        result = 31 * result + (assistant1 != null ? assistant1.hashCode() : 0);
        result = 31 * result + (assistant2 != null ? assistant2.hashCode() : 0);
        result = 31 * result + (anesthesiaType != null ? anesthesiaType.hashCode() : 0);
        result = 31 * result + (anesthesiaDoctor != null ? anesthesiaDoctor.hashCode() : 0);
        result = 31 * result + (medicalRecordHomePage != null ? medicalRecordHomePage.hashCode() : 0);
        return result;
    }
}