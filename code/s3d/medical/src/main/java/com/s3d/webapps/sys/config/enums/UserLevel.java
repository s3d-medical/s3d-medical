package com.s3d.webapps.sys.config.enums;

public enum UserLevel implements BaseEnum<Integer>
{
	;
	private String desc;
	private Integer code;
	
	private UserLevel(String desc,Integer code)
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
