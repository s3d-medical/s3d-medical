package com.s3d.webapps.sys.security.persistence;

import com.s3d.webapps.constant.SecurityElementConstant;


/**
 * 个人
 * 
 * @author 
 * @version 1.0 2013-05-05
 */
public class User extends BaseSecurityElement {
	public User() {
		super();
		setFdOrgType(new Integer(SecurityElementConstant.SEC_TYPE_PERSON));
	}
	public boolean isAnonymous() {
		if (fdLoginName == null)
			return false;
		return fdLoginName.equals("anonymous");
	}
	/**
	 * 会员帐号
	 */
	protected String fdLoginName;
	/**
	 * 会员密码
	 */
	protected String fdPassword;

	/**
	 * 邮箱
	 */
	protected String fdEmail;
	
		
	protected String fdDefaultLang;
	
	protected Integer fdGender;
	
	protected String fdPhone;
	
	protected Boolean fdIsActived;
	
	/**
	 * 用户是否已激活
	 */
	public Boolean getFdIsActived() {
		if(null==fdIsActived)
			return false;
		return fdIsActived;
	}
	
	public void setFdIsActived(Boolean fdIsActived) {
		this.fdIsActived = fdIsActived;
	}
	public String getFdPhone() {
		return fdPhone;
	}
	
	public void setFdPhone(String fdPhone) {
		this.fdPhone = fdPhone;
	}
	
	/**
	 * @return 会员帐号
	 */
	public String getFdLoginName() {
		return fdLoginName;
	}
	
	/**
	 * @param fdLoginName 会员帐号
	 */
	public void setFdLoginName(String fdLoginName) {
		this.fdLoginName = fdLoginName;
	}
	
	
	/**
	 * @return 会员密码
	 */
	public String getFdPassword() {
		return fdPassword;
	}
	
	/**
	 * @param fdPassword 会员密码
	 */
	public void setFdPassword(String fdPassword) {
		this.fdPassword = fdPassword;
	}
	
	
	/**
	 * @return 邮箱
	 */
	public String getFdEmail() {
		return fdEmail;
	}
	
	/**
	 * @param fdEmail 邮箱
	 */
	public void setFdEmail(String fdEmail) {
		this.fdEmail = fdEmail;
	}

	public String getFdDefaultLang() {
		return fdDefaultLang;
	}

	public void setFdDefaultLang(String fdDefaultLang) {
		this.fdDefaultLang = fdDefaultLang;
	}
	
	public Integer getFdGender() {
		return fdGender;
	}
	
	public void setFdGender(Integer fdGender) {
		this.fdGender = fdGender;
	}
}
