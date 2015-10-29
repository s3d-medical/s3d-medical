package com.s3d.webapps.sys.config.enums;


public enum YesNo implements BaseEnum<Integer>
{
	Yes("是",0),No("否",1);
	
	private String desc;
	private Integer code;
	
	private YesNo(String desc,Integer code)
	{
		this.desc = desc;
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getDesc() {
		// TODO Auto-generated method stub
		return this.desc;
	}
	
	public static YesNo bool2YesNo(boolean flag)
	{
		if (flag)
		{
			return YesNo.Yes;
		}
		return YesNo.No;
	}
	
	public boolean boolValue()
	{
		if (this.equals(YesNo.Yes))
		{
			return true;
		}
		return false;
	}
}
