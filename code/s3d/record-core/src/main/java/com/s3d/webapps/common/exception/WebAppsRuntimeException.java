package com.s3d.webapps.common.exception;

import org.springframework.core.NestedRuntimeException;

import com.s3d.webapps.util.WebAppsMessage;
import com.s3d.webapps.util.WebAppsMessages;

/**
 * 用于抛出程序过程中的实时错误，建议当处理错误的时候直接调用或者通过继承的方式编写新的异常。<br>
 * 本类结合了{@link com.s3d.webapps.util.WebAppsMessage WebAppsMessage}，使国际化的实现更加简便。<br>
 * 实时的异常，对调用者来说不一定需要接住或抛出，一旦该异常抛出，若上一层调用没有接住，错误会一致往上冒。
 * 
 * @author s3d
 * @version 1.0 2006-04-02
 */
public class WebAppsRuntimeException extends NestedRuntimeException {
	private WebAppsMessages webappsMessages = null;

	public WebAppsRuntimeException(Throwable cause) {
		super(cause.toString(), cause);
		webappsMessages = new WebAppsMessages().addError(cause);
	}

	public WebAppsRuntimeException(WebAppsMessage msg) {
		super(msg.getMessageKey());
		webappsMessages = new WebAppsMessages().addError(msg.setThrowable(this));
	}

	public WebAppsRuntimeException(WebAppsMessage msg, Throwable cause) {
		super(cause.toString(), cause);
		webappsMessages = new WebAppsMessages().addError(msg.setThrowable(cause));
	}

	public WebAppsRuntimeException(WebAppsMessages msgs) {
		super("errors.unknown");
		webappsMessages = new WebAppsMessages().concat(msgs).setHasError();
	}

	public WebAppsRuntimeException(WebAppsMessages msgs, Throwable cause) {
		super(cause.toString(), cause);
		webappsMessages = new WebAppsMessages().addError(cause).concat(msgs);
	}

	public WebAppsMessages getWebAppsMessages() {
		return webappsMessages;
	}
}
