package com.s3d.webapps.constant;

public interface SecurityElementConstant {
	/**
	 * 机构
	 */
	public final static int SEC_TYPE_ORG = 0x1;

	/**
	 * 部门
	 */
	public final static int SEC_TYPE_DEPT = 0x2;

	/**
	 * 岗位
	 */
	public final static int SEC_TYPE_POST = 0x4;

	/**
	 * 个人
	 */
	public final static int SEC_TYPE_PERSON = 0x8;

	/**
	 * 群组
	 */
	public final static int SEC_TYPE_GROUP = 0x10;

	/**
	 * 角色
	 */
	public final static int SEC_TYPE_ROLE = 0x20;

	/**
	 * 机构或部门
	 */
	public final static int SEC_TYPE_ORGORDEPT = SEC_TYPE_ORG | SEC_TYPE_DEPT;

	/**
	 * 岗位或个人
	 */
	public final static int SEC_TYPE_POSTORPERSON = SEC_TYPE_POST
			| SEC_TYPE_PERSON;

	/**
	 * 所有组织架构
	 */
	public final static int SEC_TYPE_ALLORG = SEC_TYPE_ORGORDEPT
			| SEC_TYPE_POSTORPERSON;

	/**
	 * 所有类型
	 */
	public final static int SEC_TYPE_ALL = SEC_TYPE_ALLORG | SEC_TYPE_GROUP;

	/**
	 * 组织架构类型默认值
	 */
	public final static int SEC_TYPE_DEFAULT = SEC_TYPE_ALL;

	// ========================组织架构标记========================
	/**
	 * 有效
	 */
	public final static int SEC_FLAG_AVAILABLEYES = 0x100;

	/**
	 * 无效
	 */
	public final static int SEC_FLAG_AVAILABLENO = 0x200;

	/**
	 * 不管是否有效
	 */
	public final static int SEC_FLAG_AVAILABLEALL = SEC_FLAG_AVAILABLEYES
			| SEC_FLAG_AVAILABLENO;

	/**
	 * 有效性的默认值
	 */
	public final static int SEC_FLAG_AVAILABLEDEFAULT = SEC_FLAG_AVAILABLEYES;

	/**
	 * 业务相关
	 */
	public final static int SEC_FLAG_BUSINESSYES = 0x400;

	/**
	 * 业务无关
	 */
	public final static int SEC_FLAG_BUSINESSNO = 0x800;

	/**
	 * 不管是否业务相关
	 */
	public final static int SEC_FLAG_BUSINESSALL = SEC_FLAG_BUSINESSYES
			| SEC_FLAG_BUSINESSNO;

	/**
	 * 是否业务相关的默认值
	 */
	public final static int SEC_FLAG_BUSINESSDEFAULT = SEC_FLAG_BUSINESSYES;

	/**
	 * 不管任何标记
	 */
	public final static int SEC_FLAG_ALL = SEC_FLAG_AVAILABLEALL
			| SEC_FLAG_BUSINESSALL;

	/**
	 * 标记默认值
	 */
	public final static int SEC_FLAG_DEFAULT = SEC_FLAG_AVAILABLEDEFAULT
			| SEC_FLAG_BUSINESSDEFAULT;

}
