/**
 * 
 */
package com.s3d.tech.exception;

import java.io.Serializable;

/**
 * 主要用于各类不返回runtimeexception的check方法， 直接返回该IError接口.
 * @author wind.chen
 */
public class CustError implements ICustError, Serializable {

    private static final long serialVersionUID = -3140728191055227417L;
    private String code;
	private String desc;

	public CustError(String code, String desc){
		this.code = code;
		this.desc = desc;
	}

	/**
	 * @return the code
	 */
	public String getErrCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setErrCode(String code) {
		this.code = code;
	}

	/**
	 * @return the desc
	 */
	public String getErrDesc() {
		return desc;
	}

    /**
     * @param desc the desc to set
     */
    public void setErrDesc(String desc) {
        this.desc = desc;
    }

}
