package com.s3d.webapps.common.exception;

import com.s3d.webapps.util.WebAppsMessage;

/**
 * 树产生循环嵌套异常
 * 
 * @author s3d
 */
public class TreeCycleException extends WebAppsRuntimeException {
	public TreeCycleException() {
		super(new WebAppsMessage("errors.treeCycle"));
	}
}
