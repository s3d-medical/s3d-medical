package com.s3d.webapps.web.vo.sysmng;

import com.s3d.webapps.web.vo.BaseEntityVO;

public class UpdateUserVo extends BaseEntityVO{
		
	protected String fdName;
	
	protected String fdPassword;

	protected String fdEmail;
	
	protected Integer fdGender;
	
	protected String fdPhone;
	
	protected Boolean fdIsActived;

	public String getFdName() {
		return fdName;
	}

	public void setFdName(String fdName) {
		this.fdName = fdName;
	}

	public String getFdPassword() {
		return fdPassword;
	}

	public void setFdPassword(String fdPassword) {
		this.fdPassword = fdPassword;
	}

	public String getFdEmail() {
		return fdEmail;
	}

	public void setFdEmail(String fdEmail) {
		this.fdEmail = fdEmail;
	}

	public Integer getFdGender() {
		return fdGender;
	}

	public void setFdGender(Integer fdGender) {
		this.fdGender = fdGender;
	}

	public String getFdPhone() {
		return fdPhone;
	}

	public void setFdPhone(String fdPhone) {
		this.fdPhone = fdPhone;
	}

	public Boolean getFdIsActived() {
		return fdIsActived;
	}

	public void setFdIsActived(Boolean fdIsActived) {
		this.fdIsActived = fdIsActived;
	}
}
