package com.s3d.webapps.component.forms.exception;

import com.s3d.webapps.common.exception.WebAppsRuntimeException;
import com.s3d.webapps.util.WebAppsMessage;

/**
 * 变量未找到错误
 * 
 * @author s3d
 * 
 */
public class VarNotFoundException extends WebAppsRuntimeException {
	public VarNotFoundException(String varName) {
		super(new WebAppsMessage("error.varNotFound", varName));
	}
}
