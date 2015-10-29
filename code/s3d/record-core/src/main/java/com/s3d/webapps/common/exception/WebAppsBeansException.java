package com.s3d.webapps.common.exception;

import org.springframework.beans.BeansException;

public class WebAppsBeansException extends BeansException {

	public WebAppsBeansException(String msg) {
		super(msg);
	}
}
