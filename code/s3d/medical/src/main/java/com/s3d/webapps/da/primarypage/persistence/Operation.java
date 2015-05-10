package com.s3d.webapps.da.primarypage.persistence;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:12:30
 */
public class Operation {

	private String name;
	private String code;
	private Date operatedDate;
	private int level;
	private String healedInGrade;
	private String anesthesiaType;
	private String anesthesiaDoctor;
	private String majorOperator;
	private String assistant1;
	private String assistant2;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getHealedInGrade() {
        return healedInGrade;
    }

    public void setHealedInGrade(String healedInGrade) {
        this.healedInGrade = healedInGrade;
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
}