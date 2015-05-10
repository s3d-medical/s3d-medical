package com.s3d.webapps.da.primarypage.persistence;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:12:26
 */
public class DischargeDiagnosis extends Diagnose {

	private String category;
	private int illnessState;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIllnessState() {
        return illnessState;
    }
    public void setIllnessState(int illnessState) {
        this.illnessState = illnessState;
    }
}