package com.s3d.webapps.web.vo.sysmng;

import com.s3d.webapps.web.vo.BaseEntityVO;

public class ChangePwdVO extends BaseEntityVO{
	private String fdPassword;
	private String fdConfirmPassword;
	public String getFdPassword() {
		return fdPassword;
	}
	public void setFdPassword(String fdPassword) {
		this.fdPassword = fdPassword;
	}
	public String getFdConfirmPassword() {
		return fdConfirmPassword;
	}
	public void setFdConfirmPassword(String fdConfirmPassword) {
		this.fdConfirmPassword = fdConfirmPassword;
	}
}
