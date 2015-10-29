package com.s3d.webapps.sys.security.exception;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class MethodErrorException extends AuthenticationException {

	public MethodErrorException(String msg) {
		super(msg);
	}

	public MethodErrorException(String msg, Throwable t) {
		super(msg, t);
	}

}
