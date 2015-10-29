package com.s3d.webapps.util;

/**
 * 单个信息。<br>
 * 基本概念：<br>
 * 1、MessageKey：在ApplicationResources中定义消息内容的key值，用于国际化。<br>
 * 2、参数：MessageKey的信息体中通常会{n}表示第n个参数，这样可以简单的对信息进行拼装。在本类中，参数可以是：<br>
 * a）WebAppsMessage对象，对WebAppsMessage的MessageKey进行解释，然后再塞到{n}中<br>
 * b）其他对象，转换为字符串直接塞到{n}中。<br>
 * <br>
 * 说明：本类并不提供信息解释为实际信息的方法，而是在界面展现的时候再进行处理。
 * 
 * @author s3d
 * @version 1.0 2006-04-02
 */
public class WebAppsMessage {
	/**
	 * 常量：错误信息。
	 */
	public final static int MESSAGE_ERROR = 1;

	/**
	 * 常量：普通信息。
	 */
	public final static int MESSAGE_COMMON = 0;

	private int messageType = 0;

	private String messageKey;

	private Throwable throwable = null;

	private Object[] parameter = null;

	/**
	 * 通过一个MessageKey构建一个信息对象。
	 * 
	 * @param messageKey
	 */
	public WebAppsMessage(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * 通过一个MessageKey加一个参数构建一个信息对象。
	 * 
	 * @param messageKey
	 * @param param1
	 *            参数一
	 */
	public WebAppsMessage(String messageKey, Object param1) {
		this.messageKey = messageKey;
		this.parameter = new Object[] { param1 };
	}

	/**
	 * 通过一个MessageKey加两个参数构建一个信息对象。
	 * 
	 * @param messageKey
	 * @param param1
	 *            参数一
	 * @param param2
	 *            参数二
	 */
	public WebAppsMessage(String messageKey, Object param1, Object param2) {
		this.messageKey = messageKey;
		this.parameter = new Object[] { param1, param2 };
	}

	/**
	 * 通过一个MessageKey加三个参数构建一个信息对象。
	 * 
	 * @param messageKey
	 * @param param1
	 *            参数一
	 * @param param2
	 *            参数二
	 * @param param3
	 *            参数三
	 */
	public WebAppsMessage(String messageKey, Object param1, Object param2,
			Object param3) {
		this.messageKey = messageKey;
		this.parameter = new Object[] { param1, param2, param3 };
	}

	/**
	 * 通过一个MessageKey加参数数组构建一个信息对象。
	 * 
	 * @param messageKey
	 * @param params
	 *            参数数组
	 */
	public WebAppsMessage(String messageKey, Object[] params) {
		this.messageKey = messageKey;
		this.parameter = params;
	}

	/**
	 * @return MessageKey
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * @return 参数数组，若参数不存在，则返回null
	 */
	public Object[] getParameter() {
		return parameter;
	}

	/**
	 * @return 错误信息的类，不存在则返回null
	 */
	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * 设置错误信息错误类
	 * 
	 * @param throwable
	 * @return 当前实例
	 */
	public WebAppsMessage setThrowable(Throwable throwable) {
		this.throwable = throwable;
		return this;
	}

	/**
	 * @return 消息类型，见本类的MESSAGE_常量
	 */
	public int getMessageType() {
		return messageType;
	}

	/**
	 * 设置消息类型。
	 * 
	 * @param messageType
	 *            请使用本类的MESSAGE_常量
	 * @return
	 */
	public WebAppsMessage setMessageType(int messageType) {
		this.messageType = messageType;
		return this;
	}
}
