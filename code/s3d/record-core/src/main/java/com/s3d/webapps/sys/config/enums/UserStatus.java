package com.s3d.webapps.sys.config.enums;


public enum UserStatus implements BaseEnum<Integer>
{
	Pending_User("待审核状态", -1),Active_User("正常状态",1),InActive_User("停用状态", 2),Delete_User("已删除状态", 3);
	
	private String desc;
	private Integer code;
	
	private UserStatus(String desc, Integer code)
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
