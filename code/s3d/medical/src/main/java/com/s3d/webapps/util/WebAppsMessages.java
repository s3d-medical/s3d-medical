package com.s3d.webapps.util;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

import com.s3d.webapps.common.exception.WebAppsException;
import com.s3d.webapps.common.exception.WebAppsRuntimeException;

/**
 * 信息列表。
 * 
 * @author s3d
 * @version 1.0 2006-04-02
 */
public class WebAppsMessages {
	private boolean error = false;

	/**
	 * @return true：返回列表中包含错误信息
	 */
	public boolean hasError() {
		return error;
	}

	/**
	 * 将信息列表设置为已经包含了错误信息。
	 * 
	 * @return 当前实例
	 */
	public WebAppsMessages setHasError() {
		this.error = true;
		return this;
	}

	private List messages = new ArrayList();

	public WebAppsMessages() {
	}

	/**
	 * 添加信息。
	 * 
	 * @param msg
	 *            信息对象
	 * @return 当前实例
	 */
	public WebAppsMessages addMsg(WebAppsMessage msg) {
		messages.add(msg);
		return this;
	}

	/**
	 * 将信息作为错误信息添加。
	 * 
	 * @param e
	 *            信息对象。
	 * @return 当前实例
	 */
	public WebAppsMessages addError(WebAppsMessage e) {
		error = true;
		messages.add(e.setMessageType(WebAppsMessage.MESSAGE_ERROR));
		return this;
	}

	/**
	 * 添加一个异常。
	 * 
	 * @param e
	 *            异常对象
	 * @return 当前实例
	 */
	public WebAppsMessages addError(Throwable e) {
		error = true;
		if (e instanceof WebAppsRuntimeException)
			return concat(((WebAppsRuntimeException) e).getWebAppsMessages());
		if (e instanceof WebAppsException)
			return concat(((WebAppsException) e).getWebAppsMessages());
		Throwable ex = e;
		while (ex.getCause() != null) {
			ex = ex.getCause();
		}
		if (ex instanceof BatchUpdateException) {
			String msgInfo = ex.getMessage();
			messages
					.add((new WebAppsMessage("error.constraintViolationException"))
							.setThrowable(e).setMessageType(
									WebAppsMessage.MESSAGE_ERROR));
			return this;
		}
		messages.add((new WebAppsMessage("errors.unknown")).setThrowable(e)
				.setMessageType(WebAppsMessage.MESSAGE_ERROR));
		return this;
	}

	/**
	 * 添加一个异常，并指定异常的消息。
	 * 
	 * @param msg
	 *            异常信息
	 * @param e
	 *            异常对象
	 * @return 当前实例
	 */
	public WebAppsMessages addError(WebAppsMessage msg, Throwable e) {
		messages.add(msg.setThrowable(e).setMessageType(
				WebAppsMessage.MESSAGE_ERROR));
		return this;
	}

	/**
	 * 链接另外一个信息列表。
	 * 
	 * @param msgs
	 *            信息列表对象
	 * @return 当前实例
	 */
	public WebAppsMessages concat(WebAppsMessages msgs) {
		messages.removeAll(msgs.getMessages());
		messages.addAll(msgs.getMessages());
		error = (error || msgs.hasError());
		return this;
	}

	/**
	 * @return 信息列表中的所有信息
	 */
	public List getMessages() {
		return messages;
	}
}
