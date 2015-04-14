package com.s3d.webapps.da.config;

import com.s3d.webapps.sys.config.enums.BaseEnum;

public enum DaConfigCategoryEnum implements BaseEnum<Integer>{
	Other_page("其他页", 0),
	Index_page("病案首页", 1), 
	Disputable_page("重复(无效)页", 9);

	private String desc;
	private Integer code;

	private DaConfigCategoryEnum(String desc, Integer code)
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
