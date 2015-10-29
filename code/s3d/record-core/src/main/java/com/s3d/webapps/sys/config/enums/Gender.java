package com.s3d.webapps.sys.config.enums;

public enum Gender implements BaseEnum<Integer>
{
	Male("男",1),FMale("女",0);
	
	private String desc;
	private Integer code;
	
	private Gender(String desc,Integer code)
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
