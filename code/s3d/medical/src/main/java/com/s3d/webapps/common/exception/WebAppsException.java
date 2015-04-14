package com.s3d.webapps.common.exception;

import com.s3d.webapps.util.WebAppsMessage;
import com.s3d.webapps.util.WebAppsMessages;

/**
 * 用于抛出程序过程中的错误，建议当处理错误的时候直接调用或者通过继承的方式编写新的异常。<br>
 * 本类结合了{@link com.s3d.webapps.util.WebAppsMessage WebAppsMessage}，使国际化的实现更加简便。<br>
 * 与实时错误不一样的是，当该错误抛出时，在类中一定要声明异常的抛出，对于调用者来说需要接住或声明抛出。
 * 
 * @author s3d
 * @version 1.0 2006-04-02
 */
public class WebAppsException extends Exception {
	public WebAppsMessages webappsMessages = null;

	public WebAppsException(Throwable cause) {
		super(cause.toString(), cause);
		webappsMessages = new WebAppsMessages().addError(cause);
	}

	public WebAppsException(WebAppsMessage msg) {
		webappsMessages = new WebAppsMessages().addError(msg.setThrowable(this));
	}

	public WebAppsException(WebAppsMessage msg, Throwable cause) {
		super(cause.toString(), cause);
		webappsMessages = new WebAppsMessages().addError(msg.setThrowable(cause));
	}

	public WebAppsException(WebAppsMessages msgs) {
		super("errors.unknown");
		webappsMessages = new WebAppsMessages().concat(msgs).setHasError();
	}

	public WebAppsException(WebAppsMessages msgs, Throwable cause) {
		super(cause.toString(), cause);
		webappsMessages = new WebAppsMessages().addError(cause).concat(msgs);
	}

	public WebAppsMessages getWebAppsMessages() {
		return webappsMessages;
	}
}
