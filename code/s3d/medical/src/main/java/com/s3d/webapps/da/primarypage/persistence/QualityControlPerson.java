package com.s3d.webapps.da.primarypage.persistence;

/**
 * role name:
 * 1. ������ 2. ����(������)ҽʦ. 3����ҽʦ 4. סԺҽʦ 5 ���λ�ʿ 6����ҽʦ 7.ʵϰҽʦ 8.����Ա 9.�ʿ�ҽʦ 10.�ʿػ�ʿ
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:12:50
 */
public class QualityControlPerson {

	private int roleName;
	private String doctorName;

    public int getRoleName() {
        return roleName;
    }

    public void setRoleName(int roleName) {
        this.roleName = roleName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}