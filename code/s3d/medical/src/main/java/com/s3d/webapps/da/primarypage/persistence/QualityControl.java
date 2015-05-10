package com.s3d.webapps.da.primarypage.persistence;

import java.util.Date;
import java.util.List;

/**
 * �����Σ� ����ҽʦ�� סԺҽʦ..
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:12:46
 */
public class QualityControl {

	private int qualityLevel;
	private Date qualityDate;
	private List<QualityControlPerson> qualityControlPersons;

    public int getQualityLevel() {
        return qualityLevel;
    }

    public void setQualityLevel(int qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    public Date getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(Date qualityDate) {
        this.qualityDate = qualityDate;
    }

    public List<QualityControlPerson> getQualityControlPersons() {
        return qualityControlPersons;
    }

    public void setQualityControlPersons(List<QualityControlPerson> qualityControlPersons) {
        this.qualityControlPersons = qualityControlPersons;
    }
}