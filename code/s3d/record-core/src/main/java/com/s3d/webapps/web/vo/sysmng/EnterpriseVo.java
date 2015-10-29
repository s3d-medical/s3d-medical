package com.s3d.webapps.web.vo.sysmng;

import com.s3d.webapps.web.vo.BaseEntityVO;

public class EnterpriseVo extends BaseEntityVO {
	protected String fdName; //名称
	/**
	 * @return 名称
	 */
	public String getFdName() {
		return fdName;
	}
	
	/**
	 * @param fdName 名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
	/**
	 * 英文名称
	 */
	protected String fdNameEn;
	
	/**
	 * @return 英文名称
	 */
	public String getFdNameEn() {
		return fdNameEn;
	}
	
	/**
	 * @param fdNameEn 英文名称
	 */
	public void setFdNameEn(String fdNameEn) {
		this.fdNameEn = fdNameEn;
	}
	
	/**
	 * 企业主代码
	 */
	protected String fdEnterpriseNo;
	
	/**
	 * @return 企业主代码
	 */
	public String getFdEnterpriseNo() {
		return fdEnterpriseNo;
	}
	
	/**
	 * @param fdEnterpriseNo 企业主代码
	 */
	public void setFdEnterpriseNo(String fdEnterpriseNo) {
		this.fdEnterpriseNo = fdEnterpriseNo;
	}
}
