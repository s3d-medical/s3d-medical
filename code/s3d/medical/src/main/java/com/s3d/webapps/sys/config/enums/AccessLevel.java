/**
 * 
 */
package com.s3d.webapps.sys.config.enums;

public enum AccessLevel implements BaseEnum<Integer>
{
	AL_0("U0", 0), AL_1("U1", 1), AL_2("U2", 2), AL_3("U3", 3), AL_4("U4", 4), 
	AL_5("U5", 5), AL_6("U6", 6), AL_7("U7", 7), AL_8("U8", 8), AL_9("U9", 9);

	private String desc;
	private Integer code;

	private AccessLevel(String desc, Integer code)
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
