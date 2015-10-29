package com.s3d.webapps.sys.security.exception;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public class ValidateCodeException extends AuthenticationException {

	public ValidateCodeException(String msg) {
		super(msg);
	}

	public ValidateCodeException(String msg, Throwable t) {
		super(msg, t);
	}
}
