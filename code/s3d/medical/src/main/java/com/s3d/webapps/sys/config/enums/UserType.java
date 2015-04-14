package com.s3d.webapps.sys.config.enums;


public enum UserType implements BaseEnum<Integer>
{
	Common_Member("普通会员", 1),Enterprise_Member("企业会员",2),VIP_Member("企业VIP会员", 3);
	
	private String desc;
	private Integer code;
	
	private UserType(String desc, Integer code)
	{
		this.desc = desc;
		this.code = code;
	}
	
	public Integer getCode()
	{
		return this.code;
	}
	
	public String getDesc()
	{
		return this.desc;
	}
}
