package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @version 1.0
 *          parent holds public properties, other properties in subclass.
 */
@Entity
@Table(name = "mr_diagnosis")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseDiagnosis implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name = "name")
    protected String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "diagnosis")
    @Fetch(FetchMode.SUBSELECT)
    protected List<DiseaseCode> diseaseCodes = new ArrayList<DiseaseCode>();

    public BaseDiagnosis() {

    }

    public void fill(String name, List<String> codes) {
        this.name = name;
        this.diseaseCodes.clear();
        if (codes != null && codes.size() > 0) {
            for (String code : codes) {
                DiseaseCode diseaseCode = new DiseaseCode();
                diseaseCode.setDiagnosis(this);
                diseaseCode.setCode(code);
                this.diseaseCodes.add(diseaseCode);
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DiseaseCode> getDiseaseCodes() {
        return diseaseCodes;
    }

    public void setDiseaseCodes(List<DiseaseCode> diseaseCodes) {
        this.diseaseCodes = diseaseCodes;
    }

    public List<String> getStrDiseaseCodes() {
        List<String> codes = new ArrayList<String>();
        if (diseaseCodes != null && diseaseCodes.size() > 0) {
            for (DiseaseCode diseaseCode : diseaseCodes) {
                codes.add(diseaseCode.getCode());
            }
        }
        return codes;
    }
}