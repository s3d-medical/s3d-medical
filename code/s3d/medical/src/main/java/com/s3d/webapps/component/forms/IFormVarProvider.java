package com.s3d.webapps.component.forms;

import com.s3d.webapps.component.forms.exception.VarNotFoundException;

public interface IFormVarProvider {
	/**
	 * 根据数据块和变量名获取值，获取不到，抛出VarNotFoundException错误
	 * 
	 * @param contextData
	 * @param varName
	 * @return
	 * @throws Exception
	 * @throws VarNotFoundException
	 */
	public Object getValue(Object contextData, String varName)
			throws Exception, VarNotFoundException;
}
