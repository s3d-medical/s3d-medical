package com.s3d.webapps.constant;

public interface HospitalOrgConstant {
	/**
	 * 医院
	 */
	public final static int HSP_TYPE_HOSPITAL = 0x1;

	/**
	 * 项目
	 */
	public final static int HSP_TYPE_PROJECT = 0x2;
	
	/**
	 * 盘号
	 */
	public final static int HSP_TYPE_LABEL = 0x8;

	
	/**
	 * 医院或项目
	 */
	public final static int HSP_TYPE_HOSORPRO = HSP_TYPE_HOSPITAL | HSP_TYPE_PROJECT;
	
	/**
	 * 所有组织架构
	 */
	public final static int HSP_TYPE_ALLORG = HSP_TYPE_HOSORPRO | HSP_TYPE_LABEL;
}
